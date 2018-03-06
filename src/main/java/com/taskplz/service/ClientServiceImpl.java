package com.taskplz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.taskplz.model.Client;
import com.taskplz.model.ClientPicture;
import com.taskplz.model.ClientVO;
import com.taskplz.model.EmailVerification;
import com.taskplz.model.EmailVerificationVO;
import com.taskplz.model.ModelException;
import com.taskplz.model.ModelManager;
import com.taskplz.timer.EmailAuthTimer;
import com.taskplz.util.BCrypt;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ModelManager modelManager;
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Client signup(ClientVO clientVO) {
		Client client = null;
		
		try {
			//이미 가입된 아이디일때
			if(modelManager.getClientByEmail(clientVO.getEmail()) != null ||
			   modelManager.getClientByNickname(clientVO.getNickname()) != null){
				return null;
			}
			client = modelManager.newClient();
			/*
			//TestClientVO
			clientVO.setEmail("test@test.com");
			clientVO.setPassword("testpassword");
			clientVO.setName("테스트이름 test name");
			clientVO.setNickname("test nickname");
			clientVO.setIntroduce("Test Introduce 테스트 인트로듀스");
			clientVO.setMajorDescription("전공 설명 major description");
			clientVO.setAverageAnswerTime(0);
			clientVO.setOrigin("Taskplz");
			*/
			client.copy(clientVO);
			client.setPassword(BCrypt.hashpw(client.getPassword(),BCrypt.gensalt()));
			client.setJoinDate(new java.sql.Timestamp(System.currentTimeMillis()));
			client.setLoginDate(new java.sql.Timestamp(System.currentTimeMillis()));
			
			client.save();
			client.setPassword("PASSWORD_SECURED");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return client;
	}
	
	@Override
	public boolean isEmailDuplicated(String email) {
		Client client = null;
		try {
			client = modelManager.getClientByEmail(email);
			if(client != null) return false;
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean isNicknameDuplicated(String nickname) {
		Client client = null;
		try {
			client = modelManager.getClientByNickname(nickname);
			if(client != null) return false;
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ClientVO getClientByID(String clientID) {
		Client client = null;
		ClientVO vo = null;
		try {
			client = modelManager.getClient(clientID);
			vo = new ClientVO();
			vo.copy(client);
			vo.setPassword("PASSWORD_SECURED");
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public ClientVO signin(String id, String pwd, HttpServletRequest request) {
		Client client = null;
		ClientVO clientVO = null;
		try {
			client = modelManager.getClientByEmail(id);
			if(client.equals(null)){
				// ID Error!
			}
			if(BCrypt.checkpw(pwd, client.getPassword())){
				// Signin Success
				clientVO = new ClientVO();
				clientVO.copy(client);
				// Assign to Session
				clientVO.setPassword("PASSWORD_SECURED");
				HttpSession session = request.getSession();
				session.setAttribute("client", clientVO);
			}else{
				// Password Error
			}
		} catch (ModelException e) {
			e.printStackTrace();
		}
		
		return clientVO;
	}

	@Override
	public boolean requestEmailAuthNumber(String clientID) {
		//1난수 생성
		String authNumber;
		Random random = new Random();
		String emailAddr = "";
		authNumber = random.nextInt(10) + "" +
				random.nextInt(10) + "" +
				random.nextInt(10) + "" +
				random.nextInt(10) + "" +
				random.nextInt(10) + "" +
				random.nextInt(10) + "";
		
		//2이메일 인증테이블 생성여부 확인 및 난수 포함하여 생성
		//2-1 클라이언트 로드
		try {
			Client client = modelManager.getClient(clientID);
			emailAddr = client.getEmail();
			EmailVerification ver = client.getEmailVerification();
			if(ver == null){
				ver = client.appendEmailVerification();
			}
			ver.setHashNumber(authNumber);
			ver.setVerDate(new java.sql.Timestamp(System.currentTimeMillis()));
			ver.setVerified("F");
			ver.save();

			//인증정보 미입력시 3분 후 인증코드 삭제요청
			Timer timer = new Timer();
			timer.schedule(new EmailAuthTimer(modelManager , ver), 1000*60*3);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3난수 메일 발송
		String from = "noreply@taskplz.com";
		String to = emailAddr;
		String title = "Taskplz 가입 인증 메일입니다.";
		String content = "<div align='center'><h2>아래의 문자를 인증코드 입력란에 입력해주세요.</h2><br />"+
						"<h3>"+authNumber+"</h3></div>";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
			
			mailSender.send(message);
			
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean requestEmailAuth(String clientID, String authNumber) {
		Client client = null;
		EmailVerification ver = null;
		try {
			// 1 인증 요청 정보 불러오기
			client = modelManager.getClient(clientID);
			ver = client.getEmailVerification();
			// 2 인증번호 대조 확인
			if(ver.getHashNumber() != null && ver.getHashNumber().equals(authNumber)){
				// 3 인증 정보 저장
				ver.setHashNumber(null);
				ver.setVerDate(new java.sql.Timestamp(System.currentTimeMillis()));
				ver.setVerified("T");
				ver.save();
				return true;
			}
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String uploadPicture(String clientID, String filePath) {
		Client client = null;
		ClientPicture picture = null;
		// 1 클라이언트 로드
		try {
			client = modelManager.getClient(clientID);
			// 2 클라이언트 사진 로드
			picture = client.getClientPicture();
			// 3 클라이언트 사진 유무 여부에따라 새로 생성 또는 경로 수정하여 업로드
			if(picture == null){
				picture = client.appendClientPicture();
			}
			picture.setFilePath(filePath);
			picture.save();
			return filePath;
		} catch (ModelException e) {
			e.printStackTrace();
		}
		// 4 파일경로 리턴
		return null;
	}

	@Override
	public String loadPicture(String clientID) {
		Client client = null;
		ClientPicture picture = null;
		// 1 클라이언트 로드
		try {
			client = modelManager.getClient(clientID);
			// 2 클라이언트 사진 로드
			picture = client.getClientPicture();
			// 3 클라이언트 사진 유무 여부에따라 파일경로 반환
			if(picture == null){
				return null;
			}
			return picture.getFilePath();
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deletePicture(String clientID) {
		Client client = null;
		ClientPicture picture = null;
		// 1 클라이언트 로드
		try {
			client = modelManager.getClient(clientID);
			// 2 클라이언트 사진 로드
			picture = client.getClientPicture();
			// 3 클라이언트 사진 유무 여부에따라 삭제 또는 미처리
			if(picture == null){
				return true;
			}
			picture.delete();
			return true;
		} catch (ModelException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ClientVO> getClientsByTag(String tag) {
		List<ClientVO> clients = new ArrayList<ClientVO>();
		
		try {
			clients = modelManager.getClientsByTag(tag);
		} catch (ModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clients;
	}

	@Override
	public Client getClientByIDAll(String clientID) {
		Client client = null;
		
		try {
			client = modelManager.getClient(clientID);
		} catch (ModelException e) {
			e.printStackTrace();
		}
		
		return client;
	}
	
	// Strong Get
	
	
//	@Override
//	public ClientVO modify(ClientVO clientVO) {
//		Client client = null;
//		
//		try {
//			client = modelManager.getClient(clientVO.getClientID());
//			client.copy(clientVO);
//			client.save();
//		} catch (ModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return client;
//	}
//
//	@Override
//	public boolean unregister(String clientID) {
//		Client client = null;
//		
//		try {
//			client = modelManager.getClient(clientID);
//			client.setIsSignout("T");
//			client.setSignoutDate(new java.sql.Timestamp(System.currentTimeMillis()));
//			client.save();
//			return true;
//		} catch (ModelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}

}
