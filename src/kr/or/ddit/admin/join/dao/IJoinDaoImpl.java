package kr.or.ddit.admin.join.dao;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class IJoinDaoImpl implements IJoinDao{
	
	private SqlMapClient client;
	private IJoinDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IJoinDao dao;
	public static IJoinDao getInstance() {
		return (dao == null) ? new IJoinDaoImpl() : dao;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("adminMem.memberInfo", params);
	}

}
