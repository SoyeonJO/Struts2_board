package kr.or.ddit.admin.status.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IStatusDao {
	
	// 회원가입 월 통계
	public String countInsertDate(String selectdate) throws SQLException;
	
	// 게시판 별 게시글 갯수 통계
	public List<BoardVO> countBoard() throws SQLException;
}
