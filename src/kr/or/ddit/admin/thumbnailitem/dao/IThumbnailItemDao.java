package kr.or.ddit.admin.thumbnailitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ThumbnailItemVO;

public interface IThumbnailItemDao {
	public void insertThumbnailItemInfo(List<ThumbnailItemVO> thumbnailItemList) throws SQLException;
	
	public ThumbnailItemVO thumbnailItemInfo(Map<String, String> params) throws SQLException;
}
