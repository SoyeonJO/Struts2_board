package kr.or.ddit.admin.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ZipCodeVO;

public interface IAdminMemberDao {
	
	// 회원 조회 및 검색
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException;
	
	// 페이지네이션
	public String totalCountMember(Map<String, String> params) throws SQLException;
	
	// 검색용 시 구군
	public List<ZipCodeVO> selectSido() throws SQLException;
	public List<ZipCodeVO> selectGugun(String sido) throws SQLException;

	// 회원 상세보기
	public MemberVO memberInfo(Map<String, String> params) throws SQLException;
	
	// 관리자 회원 업데이트
	public void updateMember(MemberVO memberInfo) throws SQLException;
	
	// 관리자 회원 탈퇴
	public void deleteMember(Map<String, String> params) throws SQLException;
}
