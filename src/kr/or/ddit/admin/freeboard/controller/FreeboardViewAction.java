package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Request;

import kr.or.ddit.admin.fileitem.service.IFileItemService;
import kr.or.ddit.admin.fileitem.service.IFileItemServiceImpl;
import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;
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
	
	
	   public String execute(){
		   return "success";
	   }
}
