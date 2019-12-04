package kr.or.ddit.user.reference.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;



public interface IRefDao {
	
	public List<RefVO> refList(Map<String, String> params) throws SQLException;
	public RefVO refInfo(Map<String, String> params) throws SQLException;
	public void insertRefInfo(RefVO refInfo) throws SQLException;
	public void updateRefInfo(RefVO refInfo) throws SQLException;
	public void deleteRefInfo(Map<String, String> params) throws SQLException;
	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertRefReplyInfo(RefVO refInfo) throws SQLException;
	
	public String getRefSeq() throws SQLException;
	
	public List<RefItemVO> getSavaName(Map<String, String> params) throws SQLException;
}
