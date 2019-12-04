package kr.or.ddit.admin.reference.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.opensymphony.xwork2.ModelDriven;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.admin.reference.service.IRefService;
import kr.or.ddit.admin.reference.service.IRefServiceImpl;
import kr.or.ddit.admin.refitem.service.IRefItemService;
import kr.or.ddit.admin.refitem.service.IRefItemServiceImpl;
import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;

public class InsertRefAction implements ModelDriven<RefVO>{
	
	private RefVO refInfo;
	private String fileName;
	private String message;
	private List<File> files;
	private List<String> fileNames;
	private String fileSaveName;
	
	public String fileUploadMethod(){
		
		this.files = this.refInfo.getFiles();
		this.fileNames = this.refInfo.getFilesFileName();
		
		IRefService service = IRefServiceImpl.getInstance();
		
		List<RefItemVO> refitemList = new ArrayList<RefItemVO>();
		
		RefItemVO refitemVO = null;
		
		String ref_no = service.getRefSeq();
		
		refInfo.setRef_no(ref_no);
		
		for(int i=0; i<this.fileNames.size(); i++){
			
			refitemVO = new RefItemVO();
			refitemVO.setFi_ref_no(ref_no);
			
			File baseFile = this.files.get(i);
			
			String name = this.fileNames.get(i);
			
			List<String> contentType = refInfo.getFilesContentType();
			
			long size = baseFile.length();
			
			refitemVO.setFi_ref_name(name);
			refitemVO.setFi_ref_content(contentType.get(i));
			refitemVO.setFi_ref_size(String.valueOf(size));
			
			String baseName = FilenameUtils.getBaseName(name);
			String extension = FilenameUtils.getExtension(name);
			String genID = UUID.randomUUID().toString().replace("-", "");
			
			this.fileSaveName = baseName + "_" + genID + "." + extension;
			
			refitemVO.setFi_ref_save_name(this.fileSaveName);
			
			File savaFile = new File(GlobalConstant.FILE_PATH, this.fileSaveName);
			
			refitemList.add(refitemVO);
			if(baseFile.length() > 0){
				try{
					this.fileName = fileNames.get(i);
					FileUtils.copyFile(baseFile, savaFile);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
		this.refInfo.setRef_savename(this.fileSaveName);
		
		service.insertRefInfo(this.refInfo);
		
		IRefItemService itemService = IRefItemServiceImpl.getInstance();
		itemService.insertFile(refitemList);
		
		return "success";
	}
	
	@Override
	public RefVO getModel() {
		this.refInfo = new RefVO();
		return this.refInfo;
	}

	public String getFileName() {
		return fileName;
	}

	public String getMessage() {
		return message;
	}

	public String getFileSaveName() {
		return fileSaveName;
	}
	
	
}
