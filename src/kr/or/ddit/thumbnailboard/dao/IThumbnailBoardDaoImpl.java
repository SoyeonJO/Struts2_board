package kr.or.ddit.thumbnailboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public class IThumbnailBoardDaoImpl implements IThumbnailBoardDao {
	private static IThumbnailBoardDao dao = new IThumbnailBoardDaoImpl();
	private SqlMapClient client;
	
	private IThumbnailBoardDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IThumbnailBoardDao getInstance(){
		return (dao == null) ? dao = new IThumbnailBoardDaoImpl() : dao;
	}

	@Override
	public void insertThumbnailBoard(ThumbnailVO thumbnamilInfo)
			throws SQLException {
		 client.insert("thumbnailboard.insertThumbnailboard", thumbnamilInfo);
	}

	@Override
	public void updateThumbnailBoard(ThumbnailVO thumbnamilInfo)
			throws SQLException {
		client.update("thumbnailboard.updateThumbnailBoard", thumbnamilInfo);
	}

	@Override
	public void deleteThumbnailBoard(Map<String, String> params)
			throws SQLException {
		client.update("thumbnailboard.deleteThumbnailBoard", params);
	}

	@Override
	public List<ThumbnailVO> ThumbnailList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("thumbnailboard.thumbnailList", params);
	}

	@Override
	public ThumbnailVO thumbnailInfo(Map<String, String> params)
			throws SQLException {
		client.update("thumbnailboard.updateBOHIT", params);
		return (ThumbnailVO) client.queryForObject("thumbnailboard.thumbnailView", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("thumbnailboard.totalCount", params);
	}

	@Override
	public String getTbSeq() throws SQLException {
		return (String) client.queryForObject("thumbnailboard.getTbSeq");
	}

	@Override
	public List<ThumbnailItemVO> getSaveName(Map<String, String> params)
			throws SQLException {
		return client.queryForList("thumbnailboard.getSaveName", params);
	}

}
