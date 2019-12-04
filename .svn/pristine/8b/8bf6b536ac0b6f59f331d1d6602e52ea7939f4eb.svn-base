package kr.or.ddit.user.freeboard.controller;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardReplyFormAction implements ModelDriven<FreeboardVO>{
	
	private FreeboardVO freeboardInfo;
		
	   public String replyinsert(){
	    	
		    IfreeboardService service = FreeboardServiceImpl.getInstance();
		    this.freeboardInfo.setBo_depth(String.valueOf(Integer.parseInt(this.freeboardInfo.getBo_depth()) +1));
			service.insertReInfo(freeboardInfo);	
			
			return "success";
		 }

	@Override
	public FreeboardVO getModel() {

	this.freeboardInfo = new FreeboardVO();
	
		return this.freeboardInfo;
	}
	 
   public String execute(){
	   
	   return "success";
   }	
	 
	   
}
