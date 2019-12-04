package kr.or.ddit.admin.join.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

public interface IJoinService {

	public MemberVO memberInfo(Map<String, String> params);
}
