package kr.or.ddit.admin.member.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.admin.member.service.IAdminMemberService;
import kr.or.ddit.admin.member.service.IAdminMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberDetailAction {
	
	private String mem_id;
	private MemberVO memberInfo;
	
	private String search_base_keyword;
	private String search_base;
	private String search_sido;
	private String search_gugun;
	private String search_hp;
	private String search_birth;
	private String currentPage;	
	
	public String memberInfo() {
		
	   if(this.currentPage == null){
            this.currentPage = "1";
         }

		   
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", this.mem_id);
		
		IAdminMemberService service = IAdminMemberServiceImpl.getInstance();
		this.memberInfo = service.memberInfo(params);
		
		return "success";
	}

	public MemberVO getMemberInfo() {
		return memberInfo;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getSearch_base_keyword() {
		return search_base_keyword;
	}

	public void setSearch_base_keyword(String search_base_keyword) {
		this.search_base_keyword = search_base_keyword;
	}

	public String getSearch_base() {
		return search_base;
	}

	public void setSearch_base(String search_base) {
		this.search_base = search_base;
	}

	public String getSearch_sido() {
		return search_sido;
	}

	public void setSearch_sido(String search_sido) {
		this.search_sido = search_sido;
	}

	public String getSearch_gugun() {
		return search_gugun;
	}

	public void setSearch_gugun(String search_gugun) {
		this.search_gugun = search_gugun;
	}

	public String getSearch_hp() {
		return search_hp;
	}

	public void setSearch_hp(String search_hp) {
		this.search_hp = search_hp;
	}

	public String getSearch_birth() {
		return search_birth;
	}

	public void setSearch_birth(String search_birth) {
		this.search_birth = search_birth;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
}
