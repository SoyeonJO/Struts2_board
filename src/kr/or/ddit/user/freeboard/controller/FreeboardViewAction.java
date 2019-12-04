package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Request;

import kr.or.ddit.user.fileitem.service.IFileItemService;
import kr.or.ddit.user.fileitem.service.IFileItemServiceImpl;
import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardViewAction {
	
	
	    private String bo_no ;
	    private FreeboardVO freeboardInfo;


	public String freeboardInfo(){

		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", this.bo_no);
		
		
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		this.freeboardInfo = service.freeboardInfo(params);
		
		return "success";
		
		
	}

	public FreeboardVO getFreeboardInfo() {
		return freeboardInfo;
	}
	
	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}
}
