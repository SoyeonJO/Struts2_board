package kr.or.ddit.thumbnailitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.thumbnailitem.dao.IThumbnailItemDao;
import kr.or.ddit.thumbnailitem.dao.IThumbnailItemDaoImpl;
import kr.or.ddit.vo.ThumbnailItemVO;

public class IThumbnailItemServiceImpl implements IThumbnailItemService {
	private static IThumbnailItemService service = new IThumbnailItemServiceImpl();
	private IThumbnailItemDao dao;
	
	private IThumbnailItemServiceImpl(){
		dao = IThumbnailItemDaoImpl.getInstance();
	}
	
	public static IThumbnailItemService getInstance(){
		return (service == null) ? service = new IThumbnailItemServiceImpl() : service;
	}
	
	@Override
	public void insertThumbnailItemInfo(List<ThumbnailItemVO> thumbnailItemList) {
		
		try {
			dao.insertThumbnailItemInfo(thumbnailItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ThumbnailItemVO thumbnailItemInfo(Map<String, String> params) {
		ThumbnailItemVO thumbnailList = null;
		
		try {
			thumbnailList  = dao.thumbnailItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return thumbnailList;
	}

}
