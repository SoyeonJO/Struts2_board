package kr.or.ddit.user.fileitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;



import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;

public class IFileItemDaoImpl implements IFileItemDao {
	private static IFileItemDao dao = new IFileItemDaoImpl();
	private SqlMapClient client;
	
	private IFileItemDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IFileItemDao getInstance(){
		return (dao == null) ? dao = new IFileItemDaoImpl() : dao;
	}
	
	@Override
	public void insertFileItemInfo(List<FileItemVO> fileItemList)
				throws SQLException {
		try{
			client.startTransaction();
		for(FileItemVO fileItemInfo : fileItemList){
			client.insert("fileitem.insertFileItem", fileItemInfo);
	    	}
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params) throws SQLException {
		
		return (FileItemVO) client.queryForObject("fileitem.fileItemInfo", params);
	}

}







