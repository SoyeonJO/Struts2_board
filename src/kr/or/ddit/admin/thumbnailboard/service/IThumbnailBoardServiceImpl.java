package kr.or.ddit.admin.thumbnailboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import kr.or.ddit.admin.thumbnailboard.dao.IThumbnailBoardDao;
import kr.or.ddit.admin.thumbnailboard.dao.IThumbnailBoardDaoImpl;
import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public class IThumbnailBoardServiceImpl implements IThumbnailBoardService {
	private static IThumbnailBoardService service = new IThumbnailBoardServiceImpl();
	private IThumbnailBoardDao boardDao;
	
	private IThumbnailBoardServiceImpl(){
		boardDao = IThumbnailBoardDaoImpl.getInstance();
	}
	
	public static IThumbnailBoardService getInstance(){
		return (service == null) ? service = new IThumbnailBoardServiceImpl() : service;
	}


	@Override
	public void updateThumbnailBoard(ThumbnailVO thumbnamilInfo) {
		try {
			boardDao.updateThumbnailBoard(thumbnamilInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteThumbnailBoard(Map<String, String> params) {
		try {
			boardDao.deleteThumbnailBoard(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ThumbnailVO> ThumbnailList(Map<String, String> params) {
		List<ThumbnailVO> list = null;
		
		try {
			list = boardDao.ThumbnailList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ThumbnailVO thumbnailInfo(Map<String, String> params) {
		ThumbnailVO tbInfo = null;
		
		try {
			return boardDao.thumbnailInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tbInfo;
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String count = "0";
		
		try {
			count = boardDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void insertThumbnailBoard(ThumbnailVO thumbnamilInfo) {
		try {
			boardDao.insertThumbnailBoard(thumbnamilInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getTbSeq() {
		String seq = "";
		
		try {
			seq = boardDao.getTbSeq();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seq;
	}

	@Override
	public List<ThumbnailItemVO> getSaveName(Map<String, String> params) {
		List<ThumbnailItemVO> list = null;
		
		try {
			list = boardDao.getSaveName(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
