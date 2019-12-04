package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public class NoticeViewAction {

	private String notice_no;
	private NoticeVO noticeInfo;
	
	public String noticeInfo(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("notice_no", this.notice_no);
		
		INoticeService service = INoticeServiceImpl.getInstance();
		this.noticeInfo = service.noticeInfo(params);
		
		return "success";
	}
	
	public NoticeVO getNoticeInfo() {
		return noticeInfo;
	}

	public void setNotice_no(String notice_no){
		this.notice_no = notice_no;
		
	}


}
