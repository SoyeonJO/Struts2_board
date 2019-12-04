package kr.or.ddit.admin.thumbnailboard.controller;

import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardService;
import kr.or.ddit.admin.thumbnailboard.service.IThumbnailBoardServiceImpl;
import kr.or.ddit.vo.ThumbnailVO;

import com.opensymphony.xwork2.ModelDriven;

public class UpdateThumbnailBoard implements ModelDriven<ThumbnailVO>{
	private String message;
	private ThumbnailVO tbInfo;
	
	public String execute(){
		IThumbnailBoardService service = IThumbnailBoardServiceImpl.getInstance();
		service.updateThumbnailBoard(tbInfo);
		
		this.message = "게시글 수정이 완료되었습니다.";
		
		return "success";
	}

	@Override
	public ThumbnailVO getModel() {
		this.tbInfo = new ThumbnailVO();
		return tbInfo;
	}

	public String getMessage() {
		return message;
	}
}
