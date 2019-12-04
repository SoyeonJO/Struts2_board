package kr.or.ddit.admin.reference.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.admin.reference.service.IRefService;
import kr.or.ddit.admin.reference.service.IRefServiceImpl;
import kr.or.ddit.admin.refitem.service.IRefItemService;
import kr.or.ddit.admin.refitem.service.IRefItemServiceImpl;
import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;

import com.opensymphony.xwork2.ModelDriven;

public class RefItemAction{
	
	private String fileName;
	
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
//	private String firefSEQ;
//	private String ref_no;
//	private String fi_ref_seq;
	
	public String fileDownloadMethod(){
		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("ref_no", this.ref_no);
//		params.put("fi_ref_seq", this.fi_ref_seq);
//		
//		IRefItemService service = IRefItemServiceImpl.getInstance();
//		RefItemVO refItemInfo = service.fileInfo(params);
		
		
		File downloadFile = new File(GlobalConstant.FILE_PATH, this.fileName);
		this.contentDisposition = "attachment;fileName=" + this.fileName;
		this.contentLength = downloadFile.length();
		
		try {
			this.inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return "success";
		
		
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("fi_ref_seq", this.firefSEQ);
//		
//		File downloadFile = new File(GlobalConstant.FILE_PATH, this.fileName);
//		this.contentDisposition = "attachment;fileName=" + this.fileName;
//		this.contentLength = downloadFile.length();
//		try {
//			this.inputStream = new FileInputStream(downloadFile);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		return "success";
		
//		파일업로드		
//		List<File> files = this.refInfo.getFiles();
//		List<String> fileNames = this.refInfo.getFilesFileName();
//		
//		for (int i = 0; i < fileNames.size(); i++) {
//			File baseFile = files.get(i);
//			if(baseFile.length() > 0){
//				File saveFile = new File(GlobalConstant.FILE_PATH, fileNames.get(i));
//				
//				try {
//					FileUtils.copyFile(baseFile, saveFile);
//					this.fileName = fileNames.get(i);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return "success";
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

//	public void setFirefSEQ(String firefSEQ) {
//		this.firefSEQ = firefSEQ;
//	}

//	public String getFileName() {
//		return fileName;
//	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

//	public void setRef_no(String ref_no) {
//		this.ref_no = ref_no;
//	}
//
//	public void setFi_ref_seq(String fi_ref_seq) {
//		this.fi_ref_seq = fi_ref_seq;
//	}
	
	
	
	
	
}
