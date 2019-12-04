package kr.or.ddit.user.freeboard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.user.fileitem.service.IFileItemService;
import kr.or.ddit.user.fileitem.service.IFileItemServiceImpl;
import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;


public class insertFreeboardAction implements ModelDriven<FreeboardVO>{
	
	  private FreeboardVO freeboardInfo;
	   private String message;
	   private String fileName;
	   private List<File> files;
	   private List<String> fileNames;
	   private String fileSaveName;

	 
	   public String fileUploadMethod(){
		   
		   this.files = this.freeboardInfo.getFiles();
		   this.fileNames = this.freeboardInfo.getFilesFileName();
		   
		   
		 IfreeboardService service = FreeboardServiceImpl.getInstance();
		 
		 List<FileItemVO> fileList = new ArrayList<FileItemVO>();
		 
		 FileItemVO file = null;
		 
		 String bo_no = service.insertInfo(freeboardInfo);
		 freeboardInfo.setBo_no(bo_no);
		 
	 if(this.files != null){
		 
		 for(int i =0; i<this.fileNames.size(); i++){
			 file = new FileItemVO();
			 
			 file.setFile_bo_no(bo_no);
			 
			 File baseFile = this.files.get(i);
			 
			 String name =this.fileNames.get(i);
			 
			 List<String> contentType = freeboardInfo.getFilesContentType();
			 
			 long size = baseFile.length();
			 
			 file.setFile_name(name);
			 file.setFile_content_type(contentType.get(i));
			 file.setFile_size(String.valueOf(size));
			 
			 String baseName = FilenameUtils.getBaseName(name);
			 String extension = FilenameUtils.getExtension(name);
			 
			 String genID = UUID.randomUUID().toString().replace("-", "");
			 
			 this.fileSaveName = baseName+"-"+genID+"."+extension;
			 
			 file.setFile_save_name(this.fileSaveName);
			 
			 File savaFile = new File(GlobalConstant.FILE_PATH, this.fileSaveName);
			 
			 fileList.add(file);
			 if(baseFile.length()>0){
				  try{
					  
					  this.fileName = fileNames.get(i);
					  FileUtils.copyFile(baseFile, savaFile);
					  
				  }catch(IOException e){
					  
					  e.printStackTrace();
				  }
			 }
		 }
		 
		 
		 IFileItemService itemService = IFileItemServiceImpl.getInstance();
		 itemService.insertFileItemInfo(fileList);
		 
		 
	 }
		 return "success";
		 
	 }

	@Override
	public FreeboardVO getModel() {
		
		this.freeboardInfo  = new FreeboardVO();
		
		return this.freeboardInfo;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getFileNames() {
		return fileNames;
	}

	public String getFileSaveName() {
		return fileSaveName;
	}

	
	
	  
}
