package kr.or.ddit.user.notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.noticeitem.service.INoticeItemService;
import kr.or.ddit.user.noticeitem.service.INoticeItemServiceImpl;
import kr.or.ddit.vo.NoticeItemVO;

public class NoticeDownloadAction {

	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	private String notice_no;
	private String fi_not_seq;
	
	public String fileDownloadMethod(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("fi_not_seq", this.fi_not_seq);
		params.put("notice_no", this.notice_no);
		
		INoticeItemService service = INoticeItemServiceImpl.getInstance();
		NoticeItemVO ItemInfo = service.noticeItemInfo(params);
		
		String saveName = ItemInfo.getFi_not_save_name();
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, saveName);
		this.contentDisposition = "attachment;fileName=" + saveName;
		this.contentLength = downloadFile.length();
		
		try {
			this.inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getContentDisposition() {
		return contentDisposition;
	}

	public long getContentLength() {
		return contentLength;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setNotice_no(String notice_no){
		this.notice_no = notice_no;
	}
	
	public void setFi_not_seq(String fi_not_seq){
		this.fi_not_seq = fi_not_seq;
	}
}
