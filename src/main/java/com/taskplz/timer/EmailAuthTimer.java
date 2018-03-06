package com.taskplz.timer;

import java.util.TimerTask;

import org.springframework.stereotype.Component;

import com.taskplz.model.EmailVerification;
import com.taskplz.model.ModelException;
import com.taskplz.model.ModelManager;

@Component
public class EmailAuthTimer extends TimerTask {
	private EmailVerification ver;
	private ModelManager modelManager;
	public EmailAuthTimer(){
	}
	
	public EmailAuthTimer(ModelManager modelManager, EmailVerification ver) {
		this.modelManager = modelManager;
		this.ver = ver;
	}
	@Override
	public void run() {
		try {
			EmailVerification savedVer = modelManager.getClient(ver.getClientID()).getEmailVerification();
			if(savedVer.getVerificationID().equals("F") && savedVer.getHashNumber().equals(ver.getHashNumber())){
				// 사용자가 마지막으로 요청한 인증코드를 시간 내에 입력하지 못했음을 판단하고 인증번호 정보 삭제
				ver.setHashNumber(null);
				ver.save();
			}
		} catch (ModelException e) {
			e.printStackTrace();
		}
	}
}
