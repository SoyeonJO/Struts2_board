package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.utiles.RolePagingUtilesNotDoyoung;
import kr.or.ddit.vo.NoticeVO;


public class NoticeListAction {

	private List<NoticeVO> noticeList;
	private String search_keycode;
	private String search_keyword;
	private String currentPage;
	private String paginationContent;

	
	public String execute(){
		 HttpServletRequest request = ServletActionContext.getRequest();		
		
		if(currentPage == null){
			currentPage = "1";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("search_keycode", this.search_keycode);
		params.put("search_keyword", this.search_keyword);
		
		INoticeService service = INoticeServiceImpl.getInstance();
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtilesNotDoyoung pagingUtiles = new RolePagingUtilesNotDoyoung(Integer.parseInt(this.currentPage), Integer.parseInt(totalCount), request);		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount",  String.valueOf(pagingUtiles.getEndCount()));
		
		this.noticeList = service.noticeList(params);
		
	    this.paginationContent = pagingUtiles.getPagingHTMLs();
	    
		return "success";
		
		
		
		
		
		
	}
	
	  public List<NoticeVO> getnoticeList() {
	      return noticeList;
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

	   public String getPaginationContent() {
	      return paginationContent;
	   }

	
}
