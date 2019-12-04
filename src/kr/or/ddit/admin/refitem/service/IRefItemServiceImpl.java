package kr.or.ddit.admin.refitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.refitem.dao.IRefItemDao;
import kr.or.ddit.admin.refitem.dao.IRefItemDaoImpl;
import kr.or.ddit.vo.RefItemVO;

public class IRefItemServiceImpl implements IRefItemService {

	private static IRefItemService service = new IRefItemServiceImpl();
	   
	   private IRefItemDao dao;
	   private IRefItemServiceImpl(){
		   dao = IRefItemDaoImpl.getInstance();
	   }
	   
	   public static IRefItemService getInstance(){
		   
		   return (service  == null) ? service = new IRefItemServiceImpl() : service; 
	   }
	   
	
	
	@Override
	public void insertFile(List<RefItemVO> refItemList) {

		try {
			dao.insertFile(refItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RefItemVO fileInfo(Map<String, String> params) {
			RefItemVO fileInfo = null;
	       
	       try {
			fileInfo = dao.fileInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileInfo;
	}

}
