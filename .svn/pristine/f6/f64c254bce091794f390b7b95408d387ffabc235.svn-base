package kr.or.ddit.user.freeboard.controller;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;


public class updateFreeboardAction implements ModelDriven<FreeboardVO>{
       private FreeboardVO freeboardInfo; 
       
       public String execute(){
    	   
    	   IfreeboardService service = FreeboardServiceImpl.getInstance();
    	   service.updateInfo(freeboardInfo);
    	   
    	   return "success";
    	   
       }
       
	@Override
	public FreeboardVO getModel() {
		this.freeboardInfo = new FreeboardVO();
		
		return this.freeboardInfo;
	}
       
       
}
