package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.admin.member.service.IAdminMemberService;
import kr.or.ddit.admin.member.service.IAdminMemberServiceImpl;

public class DeleteMemberAction {
	
	private String mem_id;
	
	public String execute() {
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IAdminMemberService service = IAdminMemberServiceImpl.getInstance();
		service.deleteMember(params);
		
		return "success";
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	

}
