package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;

public class deleteFreeboardAction {
	private String bo_group;
	private FreeboardVO freeboardInfo;

	
	public String execute(){
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_group", this.bo_group);
		
		
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		service.deleteInfo(params);
		
		return "success";
	}


    
	public void setBo_group(String bo_group) {
		this.bo_group = bo_group;
	}



	public FreeboardVO getFreeboardInfo() {
		return freeboardInfo;
	}
	
    	

}
