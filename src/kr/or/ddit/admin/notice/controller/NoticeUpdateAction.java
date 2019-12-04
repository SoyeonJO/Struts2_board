package kr.or.ddit.admin.notice.controller;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.admin.notice.service.INoticeService;
import kr.or.ddit.admin.notice.service.INoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

public class NoticeUpdateAction implements ModelDriven<NoticeVO> {

	private NoticeVO noticeInfo;

	public String execute(){
		INoticeService service = INoticeServiceImpl.getInstance();
		service.updateNoticeInfo(this.noticeInfo);
		
		return "success";
	}
	
	@Override
	public NoticeVO getModel() {
		this.noticeInfo = new NoticeVO();
		
		return noticeInfo;
	}
	
}
