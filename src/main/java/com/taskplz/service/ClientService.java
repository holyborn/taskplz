package com.taskplz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.taskplz.model.Client;
import com.taskplz.model.ClientVO;

/*20171006 이찬영 Client Service*/
public interface ClientService {
	/*Client CRUD*/
	public ClientVO signup(ClientVO clientVO);
	public ClientVO getClientByID(String clientID);
//	public ClientVO modify(ClientVO clientVO);
//	public boolean unregister(String clientID);
	
	/*General methods*/
	public ClientVO signin(String id, String pwd, HttpServletRequest request);
	public boolean isEmailDuplicated(String email);
	public boolean isNicknameDuplicated(String nickname);
	
	/*Auth methods*/
	public boolean requestEmailAuthNumber(String clientID);
	public boolean requestEmailAuth(String clientID, String authNumber);
	
	/*Image methods*/
	public String uploadPicture(String clientID, String filePath);
	public String loadPicture(String clientID);
	public boolean deletePicture(String clientID);
	
	/*Search Clients*/
	public List<ClientVO> getClientsByTag(String tag);
	
	/*GET Client Info with chain*/
	public Client getClientByIDAll(String clientID);
}