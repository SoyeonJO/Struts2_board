package kr.or.ddit.user.refitem.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.RefItemVO;

public interface IRefItemService {
	
	public void insertFile(List<RefItemVO> refItemList);
	public RefItemVO fileInfo(Map<String, String> params);

}
