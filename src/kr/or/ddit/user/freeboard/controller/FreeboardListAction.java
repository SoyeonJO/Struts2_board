package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardListAction {
     private List<FreeboardVO> freeboardList;
 	private String search_keycode;
 	private String search_keyword;
 	private String currentPage;
 	private String paginationContent;
     
     
     public String execute(){
    	
    	 HttpServletRequest request = ServletActionContext.getRequest();
    	 
    	 //페이징
    	 if(currentPage == null){
    		 currentPage = "1";
    	 }
    	 
    	 
    	 Map<String, String> params = new HashMap<String, String>();
 		
   
 		params.put("search_keycode", this.search_keycode);
 		params.put("search_keyword", this.search_keyword);
 		
 		IfreeboardService service = FreeboardServiceImpl.getInstance();
 		//페이징 
 		String totalCount = service.totalCount(params);
 		
 		RolePagingUtilesNotDoyoung pagingUtiles = new RolePagingUtilesNotDoyoung(Integer.parseInt(this.currentPage),
 				Integer.parseInt(totalCount),
 				request); 
 				
    	 //페이지당 글수
    	 params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
    	 params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));

 	
 		this.paginationContent = pagingUtiles.getPagingHTMLs();
    	this.freeboardList = service.FreeboardList(params);
 		
    	 return "success";
     }


	public List<FreeboardVO> getFreeboardList() {
		return freeboardList;
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
     
     
     
     

     
     
}
