package kr.or.ddit.admin.status.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.BoardVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class IStatusDaoImpl implements IStatusDao{

	private SqlMapClient smc;
	private IStatusDaoImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IStatusDao dao;
	public static IStatusDao getInstance() {
		return (dao == null) ? new IStatusDaoImpl() : dao;
	}
	
	@Override
	public String countInsertDate(String selectdate) throws SQLException {
		return (String) smc.queryForObject("adminStatus.countInsertDate", selectdate);
	}

	@Override
	public List<BoardVO> countBoard() throws SQLException {
		return smc.queryForList("adminStatus.countBoard");
	}
	


}
