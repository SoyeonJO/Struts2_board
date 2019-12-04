package kr.or.ddit.admin.join.dao;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface IJoinDao {
	
	public MemberVO memberInfo(Map<String, String> params) throws SQLException;

}
