package kr.or.ddit.admin.refitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.RefItemVO;

public class IRefItemDaoImpl implements IRefItemDao {
    
	
	private static IRefItemDao dao =  new IRefItemDaoImpl();
	private SqlMapClient client;
	
	private IRefItemDaoImpl(){
         client = SqlMapClientFactory.getSqlMapClient();

	}
	
	public static IRefItemDao getInstance(){
		return (dao == null) ? dao = new IRefItemDaoImpl() : dao ;
	}

	@Override
	public void insertFile(List<RefItemVO> refItemList) throws SQLException {
		
		try {
			client.startTransaction();
			for(RefItemVO fileInfo : refItemList){
				client.insert("refitem.insertRefItem", fileInfo);
			}
			client.commitTransaction();
		}finally {
			client.endTransaction();
		}
	}

	@Override
	public RefItemVO fileInfo(Map<String, String> params) throws SQLException {
		return (RefItemVO) client.queryForObject("refitem.refItemInfo", params);
	}	
	
}
