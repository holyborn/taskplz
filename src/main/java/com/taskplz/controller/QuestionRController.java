package com.taskplz.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.taskplz.model.Client;
import com.taskplz.model.ClientVO;
import com.taskplz.model.PhoneVerificationVO;
import com.taskplz.service.ClientService;
import com.taskplz.util.MediaUtils;
import com.taskplz.util.UploadFileUtils;

@RestController
@RequestMapping(value="/r/question")
public class QuestionRController {
	@Autowired
	private ClientService service;

	//Signup
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<ClientVO> signup(@RequestBody ClientVO vo){
		ResponseEntity<ClientVO> entity = null; 
		try{
			entity = new ResponseEntity<ClientVO>(service.signup(vo),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<ClientVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	// Check Duplication
	@RequestMapping(value="/dup/email", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isEmailDuplicated(@RequestParam String email){
		ResponseEntity<Boolean> entity = null; 
		try{
			entity = new ResponseEntity<Boolean>(service.isEmailDuplicated(email),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	@RequestMapping(value="/dup/nickname", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isNicknameDuplicated(@RequestParam String email){
		ResponseEntity<Boolean> entity = null; 
		try{
			entity = new ResponseEntity<Boolean>(service.isNicknameDuplicated(email),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	// Signin
	@ResponseBody
	@RequestMapping(value="/signin", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<ClientVO> signin(@RequestParam String id, @RequestParam String pw, HttpServletRequest request){
		ResponseEntity<ClientVO> entity = null; 
		try{
			entity = new ResponseEntity<ClientVO>(service.signin(id, pw, request),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<ClientVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	//Select
	@RequestMapping(value="/{clientID}", method = RequestMethod.GET)
	public ResponseEntity<ClientVO> getClientByID(@PathVariable("clientID") String clientID){
		ResponseEntity<ClientVO> entity = null;
		try{
			entity = new ResponseEntity<ClientVO>(service.getClientByID(clientID),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<ClientVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	@RequestMapping(value="/a/{clientID}", method = RequestMethod.GET)
	public ResponseEntity<Client> getAClientByID(@PathVariable("clientID") String clientID){
		ResponseEntity<Client> entity = null;
		try{
			entity = new ResponseEntity<Client>(service.getClientByIDAll(clientID),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	//Authorization 20180225

	@RequestMapping(value="/auth/email/{clientID}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> authorizeByEmail(@PathVariable("clientID") String clientID){
		ResponseEntity<Boolean> entity = null;
		try{
			entity = new ResponseEntity<Boolean>(service.requestEmailAuthNumber(clientID),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	@RequestMapping(value="/auth/email/{clientID}/{authNumber}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> requestAuthorizeByEmail(@PathVariable("clientID") String clientID, @PathVariable("authNumber") String authNumber,
			HttpSession session){
		ResponseEntity<Boolean> entity = null;
		try{
			entity = new ResponseEntity<Boolean>(service.requestEmailAuth(clientID, authNumber),HttpStatus.OK);
		}catch(Exception e){
//			entity = new ResponseEntity<ClientVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}

	@RequestMapping(value="/auth/phone/{clientID}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> authorizeByPhone(@PathVariable("clientID") String clientID,
													@RequestBody PhoneVerificationVO phoneVerVO,
													HttpSession session){
		ResponseEntity<Boolean> entity = null;
		try{
			entity = new ResponseEntity<Boolean>(service.requestEmailAuthNumber(clientID),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	// Image controller 20180226
	@RequestMapping(value="/{clientID}/image", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> uploadUserImage(@PathVariable("clientID") String clientID, MultipartFile file, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		ClientVO client = (ClientVO)session.getAttribute("client");
		ResponseEntity<String> entity = null;
		String dir = "/data/images/clientPicture";
		String filePath = UploadFileUtils.uploadFile(dir, file.getOriginalFilename(), file.getBytes());
		
		try {
			entity = new ResponseEntity<String>(service.uploadPicture(clientID, filePath),HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	@RequestMapping(value = "/image", method=RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	  public ResponseEntity<byte[]>  displayUserImage(@RequestParam String fileName, HttpServletRequest request)throws Exception{
		  String realPath = "/data/images/clientPicture";
	    InputStream in = null; 
	    ResponseEntity<byte[]> entity = null;
	    
	    try{
	      
	      String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
	      MediaType mType = MediaUtils.getMediaType(formatName);
	      HttpHeaders headers = new HttpHeaders();
	      
	      in = new FileInputStream(realPath+'/'+fileName);
	      if(mType != null){
	        headers.setContentType(mType);
	      }else{
	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition", "attachment; filename=\""+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	      }
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
	    }catch(Exception e){
	      e.printStackTrace();
	      entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally{
	      if(in!=null){in.close();};
	    }
	      return entity;    
	  }
	
	  @RequestMapping(value="/{clientID}/image", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
		public ResponseEntity<Boolean> deleteUserImage(@PathVariable("clientID") String clientID, HttpServletRequest request) throws Exception{
			ResponseEntity<Boolean> entity = null;
			
			try {
				entity = new ResponseEntity<Boolean>(service.deletePicture(clientID),HttpStatus.OK);
			} catch (Exception e) {
				entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
			return entity;
		}
	  
	  // 태그로 사용자 검색하기 20180228
	  @RequestMapping(value="/tag/{tag}", method = RequestMethod.GET)
		public ResponseEntity<List<ClientVO>> getClientByTag(@PathVariable("tag") String tag){
			ResponseEntity<List<ClientVO>> entity = null;
			try{
				entity = new ResponseEntity<List<ClientVO>>(service.getClientsByTag(tag),HttpStatus.OK);
			}catch(Exception e){
				entity = new ResponseEntity<List<ClientVO>>(HttpStatus.BAD_REQUEST);
				e.printStackTrace();
			}
			return entity;
		}
	  
	/*
	
	//Update
	@RequestMapping(value="/", method = RequestMethod.PUT)
	public ResponseEntity<ClientVO> modify(@RequestBody ClientVO vo){
		ResponseEntity<ClientVO> entity = null;
		try{
			entity = new ResponseEntity<ClientVO>(service.modify(vo),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<ClientVO>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	
	//Delete

	@RequestMapping(value="/{clientID}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> unregister(@PathVariable("clientID") String clientID){
		ResponseEntity<Boolean> entity = null;
		try{
			entity = new ResponseEntity<Boolean>(service.unregister(clientID),HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return entity;
	}
	*/
}
