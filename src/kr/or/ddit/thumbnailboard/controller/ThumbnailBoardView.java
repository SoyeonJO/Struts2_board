package kr.or.ddit.thumbnailboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.thumbnailboard.service.IThumbnailBoardService;
import kr.or.ddit.thumbnailboard.service.IThumbnailBoardServiceImpl;
import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public class ThumbnailBoardView {
	private String tb_no;
	private ThumbnailVO tbInfo;
	private List<ThumbnailItemVO> tbiList;
	
	public String execute(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("tb_no", this.tb_no);
		
		IThumbnailBoardService service = IThumbnailBoardServiceImpl.getInstance();
		this.tbInfo = service.thumbnailInfo(params);
		this.tbiList = service.getSaveName(params);
		
		return "success";
	}
	
	public void setTb_no(String tb_no) {
		this.tb_no = tb_no;
	}

	public ThumbnailVO getTbInfo() {
		return tbInfo;
	}

	public List<ThumbnailItemVO> getTbiList() {
		return tbiList;
	}
	
}
