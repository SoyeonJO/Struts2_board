package kr.or.ddit.user.member.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;

public class DeleteMemberAction {

	private String mem_id;
	private String message;

	public String execute() {
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.memberDelete(this.mem_id);
		
		try {
			this.message = URLEncoder.encode("회원 탈퇴가 완료되었습니다.", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
