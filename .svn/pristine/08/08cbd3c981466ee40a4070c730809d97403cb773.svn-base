package kr.or.ddit.user.freeboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.fileitem.service.IFileItemService;
import kr.or.ddit.user.fileitem.service.IFileItemServiceImpl;
import kr.or.ddit.vo.FileItemVO;

public class downloadFreeboardAction {
	
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	private String bo_no;
	private String file_seq;
	
	public String fileDownloadMethod(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("file_seq", this.file_seq);
		
		IFileItemService service = IFileItemServiceImpl.getInstance();
		FileItemVO fileInfo = service.fileItemInfo(params);
		
		String saveName =fileInfo.getFile_save_name();
	
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

	public void setBo_no(String bo_no) {
		this.bo_no = bo_no;
	}

	public void setFile_seq(String file_seq) {
		this.file_seq = file_seq;
	}

	
	
}
