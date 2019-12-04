package kr.or.ddit.admin.join.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.admin.join.dao.IJoinDao;
import kr.or.ddit.admin.join.dao.IJoinDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class IJoinServiceImpl implements IJoinService{
	
	private IJoinDao dao;
	private IJoinServiceImpl() {
		dao = IJoinDaoImpl.getInstance();
	}
	
	private static IJoinService service;
	public static IJoinService getInstance() {
		return (service == null) ? new IJoinServiceImpl() : service;
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO member = null;
		try {
			member = dao.memberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return member;
	}

}
