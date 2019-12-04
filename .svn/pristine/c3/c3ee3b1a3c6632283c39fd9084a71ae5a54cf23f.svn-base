package kr.or.ddit.admin.thumbnailboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public interface IThumbnailBoardDao {
	// 등록
//	public String insertThumbnailBoard(ThumbnailVO thumbnamilInfo) throws SQLException;
	public void insertThumbnailBoard(ThumbnailVO thumbnamilInfo) throws SQLException;
	
	// 수정
	public void updateThumbnailBoard(ThumbnailVO thumbnamilInfo) throws SQLException;
	
	// 삭제
	public void deleteThumbnailBoard(Map<String, String> params) throws SQLException;
	
	// 전체 목록 출력
	public List<ThumbnailVO> ThumbnailList(Map<String, String> params) throws SQLException;
	
	// 상세보기
	public ThumbnailVO thumbnailInfo(Map<String, String> params) throws SQLException;
	
	public String totalCount(Map<String, String> params) throws SQLException;
	
	public String getTbSeq() throws SQLException;
	
	public List<ThumbnailItemVO> getSaveName(Map<String, String> params) throws SQLException;
}
