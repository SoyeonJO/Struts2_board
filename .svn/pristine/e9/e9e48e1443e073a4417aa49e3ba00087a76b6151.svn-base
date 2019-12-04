package kr.or.ddit.user.reference.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.user.reference.service.IRefService;
import kr.or.ddit.user.reference.service.IRefServiceImpl;
import kr.or.ddit.vo.RefVO;

import com.opensymphony.xwork2.ModelDriven;

public class DeleteRefAction implements ModelDriven<RefVO>{

	private RefVO refInfo;
	private String ref_no;
	
	public String execute(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("ref_no", ref_no);
		
		IRefService service = IRefServiceImpl.getInstance();
		service.deleteRefInfo(params);
		
		return "success";
	}
	
	@Override
	public RefVO getModel() {
		return refInfo;
	}

	public RefVO getRefInfo() {
		return refInfo;
	}

	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	
	

		
}
