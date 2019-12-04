package kr.or.ddit.user.member.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class InsertMemberAction implements ModelDriven<MemberVO>{
	
	private MemberVO memberInfo;
	private String message;
	
	public String execute() {
		
		try {
			this.message = URLEncoder.encode("회원 가입되셨습니다!!", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.memberInsert(this.memberInfo);
		
		return "success";
	}

	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		return this.memberInfo;
	}

	public String getMessage() {
		return message;
	}
	
}
