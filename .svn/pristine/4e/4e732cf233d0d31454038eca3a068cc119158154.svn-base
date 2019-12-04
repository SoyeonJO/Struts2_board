package kr.or.ddit.user.reference.controller;

import kr.or.ddit.user.reference.service.IRefService;
import kr.or.ddit.user.reference.service.IRefServiceImpl;
import kr.or.ddit.vo.RefVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateRefAction implements ModelDriven<RefVO>{

	private RefVO refInfo;
	
	public String execute(){
		
		IRefService service = IRefServiceImpl.getInstance();
		service.updateRefInfo(this.refInfo);
		
		return "success";
	}
	
	@Override
	public RefVO getModel() {
		
		this.refInfo = new RefVO();
		
		return refInfo;
	}

}
