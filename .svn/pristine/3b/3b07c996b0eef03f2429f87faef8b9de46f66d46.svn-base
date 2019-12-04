package kr.or.ddit.user.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberViewAction {

	private String mem_id;
	private MemberVO memberInfo;
	
	// method="memberInfo" : 액션 메서드
	public String memberInfo() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		this.memberInfo = service.memberInfo(params);
		
		return "success";
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public MemberVO getMemberInfo() {
		return memberInfo;
	}
}
