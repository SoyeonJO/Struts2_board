package kr.or.ddit.admin.thumbnailboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardService;
import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardServiceImpl;
import kr.or.ddit.admin.thumbnailitem.service.IThumbnailItemService;
import kr.or.ddit.admin.thumbnailitem.service.IThumbnailItemServiceImpl;
import kr.or.ddit.utiles.RolePagingUtilesThumbnail;
import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public class ThumbnailBoardList {
	private List<ThumbnailVO> thumbnailList;
	private String search_keycode;
	private String search_keyword;
	private String currentPage;
	private String paginationContent;
	private ThumbnailItemVO tbi;
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		if(this.currentPage == null){
			this.currentPage = "1";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", this.search_keycode);
		params.put("search_keyword", this.search_keyword);
		
		IThumbnailBoardService service = IThumbnailBoardServiceImpl.getInstance();
		IThumbnailItemService itemService = IThumbnailItemServiceImpl.getInstance();
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtilesThumbnail pagingUtiles = new RolePagingUtilesThumbnail(Integer.parseInt(this.currentPage), Integer.parseInt(totalCount), request);
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		Map<String, String> pa = new HashMap<String, String>();
		
		this.thumbnailList = service.ThumbnailList(params);
		this.paginationContent = pagingUtiles.getPagingHTMLs();
		
		
		for(int i=0; i<this.thumbnailList.size(); i++){
			String tb_no = this.thumbnailList.get(i).getTb_no();
			
			pa.put("tb_no", tb_no);
			
			this.tbi = itemService.thumbnailItemInfo(pa);
		}

		return "success";
	}

	public List<ThumbnailVO> getThumbnailList() {
		return thumbnailList;
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

	public ThumbnailItemVO getTbi() {
		return tbi;
	}

	public String getSearch_keycode() {
		return search_keycode;
	}

	public String getSearch_keyword() {
		return search_keyword;
	}
}
