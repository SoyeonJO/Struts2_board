package kr.or.ddit.user.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.user.noticeitem.service.INoticeItemService;
import kr.or.ddit.user.noticeitem.service.INoticeItemServiceImpl;
import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

import com.opensymphony.xwork2.ModelDriven;

public class NoticeInsertAction implements ModelDriven<NoticeVO> {

	private NoticeVO noticeInfo;
	private String message;
	private String fileName;
	private List<File> files;
	private List<String> fileNames;
	private String fileSaveName;
	
	public String fileUploadMethod(){
		
		this.files = this.noticeInfo.getFiles();
		this.fileNames = this.noticeInfo.getFilesFileName();
		
		INoticeService service = INoticeServiceImpl.getInstance();
		
		List<NoticeItemVO> noticeList = new ArrayList<NoticeItemVO>();
		
		NoticeItemVO file = null;
		
		String notice_no = service.insertNoticeInfo(noticeInfo);
		noticeInfo.setNotice_no(notice_no);
		
    		
    		for(int i=0; i<this.fileNames.size(); i++){
    			file = new NoticeItemVO();
    			
    			file.setFi_not_no(notice_no);
    			
    			File baseFile = this.files.get(i);
    			
    			String name = this.fileNames.get(i);
    			
    			List<String> contentType = noticeInfo.getFilesContentType();
    			long size = baseFile.length();
    			
    			file.setFi_not_name(name);
    			file.setFi_not_content_type(contentType.get(i));
    			file.setFi_not_size(String.valueOf(size));
    			
    			String baseName = FilenameUtils.getBaseName(name);
    			String extension = FilenameUtils.getExtension(name);
    			
    			String genID = UUID.randomUUID().toString().replace("-", "");
    			
    			this.fileSaveName = baseName + "-" + genID + "." + extension;
    			
    			file.setFi_not_save_name(this.fileSaveName);
    			
    			File saveFile = new File(GlobalConstant.FILE_PATH, this.fileSaveName);
    			
    			noticeList.add(file);
    			if(baseFile.length() > 0){
    				try{
    					this.fileName = fileNames.get(i);
    					FileUtils.copyFile(baseFile, saveFile);
    				}catch(IOException e){
    					e.printStackTrace();
    				}
    			}
    		}
    		
    		INoticeItemService itemService = INoticeItemServiceImpl.getInstance();
    		itemService.insertNoticeItemInfo(noticeList);	
		
    		return "success";
		
	}
	
	@Override
	public NoticeVO getModel() {
		this.noticeInfo = new NoticeVO();
		
		return this.noticeInfo;
	}
	
	public String getMessage(){
		return message;
	}
	public List<String> getFileNames() {
		return fileNames;
	}

	public String getFileSaveName() {
		return fileSaveName;
	}
}
