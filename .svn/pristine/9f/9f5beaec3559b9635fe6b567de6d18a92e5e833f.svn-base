package kr.or.ddit.admin.thumbnailboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.admin.thumbnailitem.service.IThumbnailItemService;
import kr.or.ddit.admin.thumbnailitem.service.IThumbnailItemServiceImpl;
import kr.or.ddit.vo.ThumbnailItemVO;

public class DownloadThumbnail {
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	private String tb_no;
	private String tbi_seq;
	
	public String fileDownloadMethod(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("tb_no", this.tb_no);
		params.put("tbi_seq", this.tbi_seq);
		
		IThumbnailItemService service = IThumbnailItemServiceImpl.getInstance();
		ThumbnailItemVO tbiInfo = service.thumbnailItemInfo(params);
		
		String saveName = tbiInfo.getTbi_save_name();
		
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

	public void setTb_no(String tb_no) {
		this.tb_no = tb_no;
	}

	public void setTbi_seq(String tbi_seq) {
		this.tbi_seq = tbi_seq;
	}
	
}
