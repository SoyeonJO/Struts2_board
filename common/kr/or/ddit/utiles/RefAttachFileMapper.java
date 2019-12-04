package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.RefItemVO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

public class RefAttachFileMapper {
	public static List<RefItemVO> mapping(FileItem[] items, String ref_no) {
		List<RefItemVO> refItemList = new ArrayList<RefItemVO>();
		
		if(items != null) {
			RefItemVO refItemInfo = null;
			for( FileItem item : items) {
				refItemInfo = new RefItemVO();
				
				refItemInfo.setFi_ref_no(ref_no);
				
				// d:\temp\a.png   or   a.png   를 확정적으로 a.png로 리턴해주는 것
				String fileName = FilenameUtils.getName(item.getName());
				refItemInfo.setFi_ref_name(fileName);
				refItemInfo.setFi_ref_content(item.getContentType());
				refItemInfo.setFi_ref_size(String.valueOf(item.getSize()));
				
				// a.png => a만 얻어내기
				String baseName = FilenameUtils.getBaseName(fileName);  
				// a.png => png만 얻어내기		
				String extension = FilenameUtils.getExtension(fileName);
				// 파일명_랜덤값.확장자 => file_save_name으로 활용
				// 랜덤값 : UUID(Universially Unique IDentifier) : 128bit 랜덤 유일값 반환(-포함)
				String genID = UUID.randomUUID().toString().replace("-", "");
				
				String fileSaveName = baseName + "_" + genID + "." + extension;
				
				refItemInfo.setFi_ref_save_name(fileSaveName);
				
				refItemList.add(refItemInfo);
				
				saveFile(fileSaveName, item);
			}
		}
		return refItemList;
	}

	private static void saveFile(String fileSaveName, FileItem item) {
		File saveFile = new File(GlobalConstant.FILE_PATH, fileSaveName);
		
		try {
			item.write(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
