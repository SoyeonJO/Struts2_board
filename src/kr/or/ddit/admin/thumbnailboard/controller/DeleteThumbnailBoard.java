package kr.or.ddit.admin.thumbnailboard.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardService;
import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardServiceImpl;

public class DeleteThumbnailBoard {
	private String tb_no;
	private String message;
	
	public String execute(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("tb_no", tb_no);
		
		IThumbnailBoardService service = IThumbnailBoardServiceImpl.getInstance();
		service.deleteThumbnailBoard(params);
		
		this.message = "게시글 삭제가 완료되었습니다.";
		
		return "success";
	}

	public void setTb_no(String tb_no) {
		this.tb_no = tb_no;
	}

	public String getMessage() {
		return message;
	}
	
}
