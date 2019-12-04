package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.admin.member.service.IAdminMemberService;
import kr.or.ddit.admin.member.service.IAdminMemberServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ZipCodeVO;

public class MemberListAjaxAction {
	
	private List<MemberVO> memberlist;
	private String paginationContent;
	private String currentPage;
	private String blockCount;
	
	private String search_base_keyword;
	private String search_base;
	private String search_sido;
	private String search_gugun;
	private String search_hp;
	private String search_birth;
	
	public void execute() {
	
		if(this.currentPage == null) {
			this.currentPage = "1";
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_base_keyword", this.search_base_keyword);
		params.put("search_base", this.search_base);
		params.put("search_sido", this.search_sido);
		params.put("search_gugun", this.search_gugun);
		params.put("search_hp", this.search_hp);
		params.put("search_birth", this.search_birth);
		
		IAdminMemberService service = IAdminMemberServiceImpl.getInstance();
		String totalCount = service.totalCountMember(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(this.currentPage), Integer.parseInt(totalCount), request);

		if(this.blockCount != null){
			pagingUtiles.makePagination(Integer.parseInt(blockCount));
		}else{
			pagingUtiles.makePagination(0);
		}
		
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		this.memberlist = service.memberList(params);
		this.paginationContent = pagingUtiles.getPagingHTMLS();
		
		Map<Object, Object> jsonMap = new HashMap<Object, Object>();
		jsonMap.put("memberList", this.memberlist);
		jsonMap.put("paginationContent", this.paginationContent);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonData;
		try {
			jsonData = mapper.writeValueAsString(jsonMap);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public List<MemberVO> getMemberlist() {
		return memberlist;
	}

	public String getPaginationContent() {
		return paginationContent;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public String getBlockCount() {
		return blockCount;
	}
	
	public void setBlockCount(String blockCount) {
		this.blockCount = blockCount;
	}

	public void setSearch_base_keyword(String search_base_keyword) {
		this.search_base_keyword = search_base_keyword;
	}

	public void setSearch_base(String search_base) {
		this.search_base = search_base;
	}

	public void setSearch_sido(String search_sido) {
		this.search_sido = search_sido;
	}

	public void setSearch_gugun(String search_gugun) {
		this.search_gugun = search_gugun;
	}

	public void setSearch_hp(String search_hp) {
		this.search_hp = search_hp;
	}

	public void setSearch_birth(String search_birth) {
		this.search_birth = search_birth;
	}

	
}
