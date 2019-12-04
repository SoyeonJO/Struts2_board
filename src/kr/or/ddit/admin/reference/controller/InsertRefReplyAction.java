package kr.or.ddit.admin.reference.controller;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.admin.reference.service.IRefService;
import kr.or.ddit.admin.reference.service.IRefServiceImpl;
import kr.or.ddit.vo.RefVO;

public class InsertRefReplyAction implements ModelDriven<RefVO>{
	private RefVO refInfo;
	
	public String execute(){
		
		IRefService service = IRefServiceImpl.getInstance();
		service.insertRefReplyInfo(refInfo);
		
		return "success";
	}

	@Override
	public RefVO getModel() {
		this.refInfo = new RefVO();
		return refInfo;
	}
	
	
}
