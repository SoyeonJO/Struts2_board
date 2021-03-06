package kr.or.ddit.admin.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ZipCodeVO;

public interface IAdminMemberService {
	
	// 회원 조회 및 검색
	public List<MemberVO> memberList(Map<String, String> params);
	
	// 페이지네이션
	public String totalCountMember(Map<String, String> params);

	// 검색용 시 구군
	public List<ZipCodeVO> selectSido();
	public List<ZipCodeVO> selectGugun(String sido);
	
	// 회원 상세보기
	public MemberVO memberInfo(Map<String, String> params);
	
	// 관리자 회원 업데이트
	public void updateMember(MemberVO memberInfo);
	
	// 관리자 회원 탈퇴
	public void deleteMember(Map<String, String> params);
	
}
