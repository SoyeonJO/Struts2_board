package kr.or.ddit.admin.status.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.status.dao.IStatusDao;
import kr.or.ddit.admin.status.dao.IStatusDaoImpl;
import kr.or.ddit.vo.BoardVO;

public class IStatusServiceImpl implements IStatusService{
	
	private IStatusDao dao;
	private IStatusServiceImpl() {
		dao = IStatusDaoImpl.getInstance();
	}
	
	private static IStatusService service;
	public static IStatusService getInstance() {
		return (service == null) ? new IStatusServiceImpl() : service;
	}

	@Override
	public String countInsertDate(String selectdate) {
		String cnt = null;
		try {
			cnt = dao.countInsertDate(selectdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<BoardVO> countBoard() {
		List<BoardVO> cnt = null;
		try {
			cnt = dao.countBoard();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
