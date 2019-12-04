package kr.or.ddit.admin.reference.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.reference.service.IRefService;
import kr.or.ddit.admin.reference.service.IRefServiceImpl;
import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;

public class RefViewAction {
	
	private String ref_no;
	private RefVO refInfo;
	private List<RefItemVO> refItemList;
	
	public String refInfo(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("ref_no", this.ref_no);
		
		IRefService service = IRefServiceImpl.getInstance();
		this.refInfo = service.refInfo(params);
		this.refItemList = service.getSavaName(params);
		
		return "success";
		
	}
	
	public RefVO getRefInfo() {
		return refInfo;
	}
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	public List<RefItemVO> getRefItemList() {
		return refItemList;
	}
	
	
}
