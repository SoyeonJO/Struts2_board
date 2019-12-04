package kr.or.ddit.user.reference.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.user.reference.service.IRefService;
import kr.or.ddit.user.reference.service.IRefServiceImpl;
import kr.or.ddit.utiles.RolePagingUtilesNotDoyoung;
import kr.or.ddit.vo.RefVO;

public class RefListAction {
	
	private List<RefVO> refList;
	private String search_keycode;
	private String search_keyword;
	private String currentPage;
	private String paginationContent;

	public String execute(){
		
		HttpServletRequest request= ServletActionContext.getRequest();
		
		if(currentPage == null){
			currentPage = "1";
		}
		
		Map<String, String> params = new HashMap<String, String>();

		params.put("search_keycode", this.search_keycode);
		params.put("search_keyword", this.search_keyword);
		
		
		IRefService service = IRefServiceImpl.getInstance();
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtilesNotDoyoung pagingUtils = new RolePagingUtilesNotDoyoung(Integer.parseInt(this.currentPage), Integer.parseInt(totalCount), request);
		params.put("startCount", String.valueOf(pagingUtils.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtils.getEndCount()));
		
		this.refList = service.refList(params);
		this.paginationContent = pagingUtils.getPagingHTMLs();
		
		return "success";
	}
	
	public List<RefVO> getRefList() {
		return refList;
	}

	public String getPaginationContent() {
		return paginationContent;
	}

	public void setSearch_keycode(String search_keycode) {
		this.search_keycode = search_keycode;
	}

	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getSearch_keycode() {
		return search_keycode;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}
	
	
}
