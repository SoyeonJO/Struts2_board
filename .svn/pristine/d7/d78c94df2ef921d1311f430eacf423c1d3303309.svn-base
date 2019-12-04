package kr.or.ddit.user.reference.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeboardVO;
import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;

public interface IRefService {
	
	public List<RefVO> refList(Map<String, String> params);
	public RefVO refInfo(Map<String, String> params);
	public void insertRefInfo(RefVO refInfo);
	public void updateRefInfo(RefVO refInfo);
	public void deleteRefInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	public void insertRefReplyInfo(RefVO refInfo);

	public String getRefSeq();
	
	public List<RefItemVO> getSavaName(Map<String, String> params);
}
