package kr.or.ddit.admin.thumbnailitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ThumbnailItemVO;

public class IThumbnailItemDaoImpl implements IThumbnailItemDao {
	private static IThumbnailItemDao dao = new IThumbnailItemDaoImpl();
	private SqlMapClient client;
	
	private IThumbnailItemDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IThumbnailItemDao getInstance(){
		return (dao == null) ? dao = new IThumbnailItemDaoImpl() : dao;
	}
	
	@Override
	public void insertThumbnailItemInfo(List<ThumbnailItemVO> thumbnailItemList)
			throws SQLException {
		try{
			client.startTransaction();
			for(ThumbnailItemVO fileItemInfo : thumbnailItemList){
				client.insert("thumbnailitem.insertThumbnailItem", fileItemInfo);
			}
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
		
	}

	@Override
	public ThumbnailItemVO thumbnailItemInfo(Map<String, String> params)
			throws SQLException {
		return (ThumbnailItemVO) client.queryForObject("thumbnailitem.thumbnailItemInfo", params);
	}

}
