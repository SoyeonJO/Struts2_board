package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.RefItemVO;


public class AttachFileMapperRef {
	public static List<RefItemVO> mapping(FileItem[] items, String ref_no){
		List<RefItemVO> refItemList = new ArrayList<RefItemVO>();
		
		if(items != null){
			RefItemVO refItemInfo = null;
			for(FileItem item : items){
				refItemInfo = new RefItemVO();
				
				refItemInfo.setFi_ref_no(ref_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				refItemInfo.setFi_ref_name(fileName);
				refItemInfo.setFi_ref_content(item.getContentType());
				refItemInfo.setFi_ref_size(String.valueOf(item.getSize()));
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				String genId = UUID.randomUUID().toString().replace("-", "");
				String refSaveName = baseName + "-" + genId + "." + extension;
				
				refItemInfo.setFi_ref_save_name(refSaveName);
				
//				refItemInfo.add(refItemInfo);
				saveRef(refSaveName, item);
			}
		}
		return refItemList;
	}
	
	private static void saveRef(String refSaveName, FileItem item){
		File saveRef = new File(GlobalConstant.FILE_PATH, refSaveName);
		
		try{
			item.write(saveRef);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
