package kr.or.ddit.admin.reference.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.admin.reference.dao.IRefDao;
import kr.or.ddit.admin.reference.dao.IRefDaoImpl;
import kr.or.ddit.admin.refitem.dao.IRefItemDao;
import kr.or.ddit.admin.refitem.dao.IRefItemDaoImpl;
import kr.or.ddit.utiles.RefAttachFileMapper;
import kr.or.ddit.vo.RefItemVO;
import kr.or.ddit.vo.RefVO;

public class IRefServiceImpl implements IRefService {

	private static IRefService service = new IRefServiceImpl();
	private IRefDao refDao;
	private IRefItemDao refitemDao;
	
	private IRefServiceImpl(){
		refDao = IRefDaoImpl.getInstance();
		refitemDao = IRefItemDaoImpl.getInstance();
	}
	
	public static IRefService getInstance(){
		return (service == null) ? service = new IRefServiceImpl() : service;
	}
	
	@Override
	public List<RefVO> refList(Map<String, String> params) {
		List<RefVO> list = null;
		
		try {
			list = refDao.refList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public RefVO refInfo(Map<String, String> params) {
		RefVO info = null;
		
		try {
			return refDao.refInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return info;
		
	}

	@Override
	public void insertRefInfo(RefVO refInfo) {

		try {
			refDao.insertRefInfo(refInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRefInfo(RefVO refInfo) {
		
		try {
			refDao.updateRefInfo(refInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteRefInfo(Map<String, String> params) {

		try {
			refDao.deleteRefInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		
		String totalCount = null;

		try {
			totalCount = refDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

	@Override
	public void insertRefReplyInfo(RefVO refInfo) {
		
		try {
			refDao.insertRefReplyInfo(refInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getRefSeq() {
		String seq = "";
		
		try {
			seq = refDao.getRefSeq();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public List<RefItemVO> getSavaName(Map<String, String> params) {
		List<RefItemVO> list = null;
		
		try {
			list = refDao.getSavaName(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
