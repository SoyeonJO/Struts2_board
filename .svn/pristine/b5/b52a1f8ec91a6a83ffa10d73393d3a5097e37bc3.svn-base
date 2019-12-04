package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

import com.opensymphony.xwork2.ModelDriven;

public class NoticeDeleteAction implements ModelDriven<NoticeVO> {

	private NoticeVO noticeInfo;
	private String notice_no;
	
	public String execute(){
		Map<String, String> params  = new HashMap<String, String>();
		params.put("notice_no", notice_no);
		
		INoticeService service = INoticeServiceImpl.getInstance();
		service.deleteNoticeInfo(params);
		
		return "success";
	}
	
	
	@Override
	public NoticeVO getModel() {
		return noticeInfo;
	}
	
	
	public NoticeVO getNoticeInfo(){
		return noticeInfo;
	}
	public void setNotice_no(String notice_no){
		this.notice_no = notice_no;
	}

}
