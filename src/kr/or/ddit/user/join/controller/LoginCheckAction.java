package kr.or.ddit.user.join.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.admin.join.service.IJoinService;
import kr.or.ddit.admin.join.service.IJoinServiceImpl;
import kr.or.ddit.listener.SessionManager;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.MemberVO;

import org.apache.struts2.ServletActionContext;

public class LoginCheckAction {
	
	private String mem_id;
	private String mem_pass;
	
	private String message;

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();  
		HttpSession session = request.getSession(true);
		
		this.mem_id = CryptoGenerator.decryptRSA(session, mem_id);
	    this.mem_pass = CryptoGenerator.decryptRSA(session, mem_pass);
	    
	    SessionManager.getInstance().loginDuplicationCheck(session.getId(), this.mem_id);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		params.put("mem_pass", this.mem_pass);
		
		IJoinService service = IJoinServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		if(memberInfo == null) {
			try {
				this.message = URLEncoder.encode("회원이 아닙니다. 하단의 회원가입을 이용해주세요.", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "loginForm";
		}else {
			session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
			return "noticeList";
		}
		
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMessage() {
		return message;
	}
}
