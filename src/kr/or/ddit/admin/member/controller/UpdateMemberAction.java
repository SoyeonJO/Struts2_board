package kr.or.ddit.admin.member.controller;

import kr.or.ddit.admin.member.service.IAdminMemberService;
import kr.or.ddit.admin.member.service.IAdminMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateMemberAction implements ModelDriven<MemberVO>{

	private MemberVO memberInfo;
	
	public String execute() {
		
		IAdminMemberService service = IAdminMemberServiceImpl.getInstance();
		service.updateMember(this.memberInfo);
		
		return "success";
	}
	
	@Override
	public MemberVO getModel() {
		this.memberInfo = new MemberVO();
		return this.memberInfo; 
	}

}
