package kr.or.ddit.admin.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ZipCodeVO;

public class IAdminMemberDaoImpl implements IAdminMemberDao{

	private SqlMapClient client;
	private IAdminMemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IAdminMemberDao dao;
	public static IAdminMemberDao getInstance() {
		return (dao == null) ? new IAdminMemberDaoImpl() : dao;
	}
	
	@Override
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException {
		return client.queryForList("adminMem.memberList", params);
	}

	@Override
	public String totalCountMember(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("adminMem.totalCountMember", params);
	}

	@Override
	public List<ZipCodeVO> selectSido() throws SQLException {
		return client.queryForList("adminMem.selectSido");
	}

	@Override
	public List<ZipCodeVO> selectGugun(String sido) throws SQLException {
		return client.queryForList("adminMem.selectGugun", sido);
	}

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("adminMem.memberInfo", params);
	}

	@Override
	public void updateMember(MemberVO memberInfo) throws SQLException {
		client.update("adminMem.updateMember", memberInfo);
	}

	@Override
	public void deleteMember(Map<String, String> params) throws SQLException {
		client.delete("adminMem.deleteMember", params);
	}

}
