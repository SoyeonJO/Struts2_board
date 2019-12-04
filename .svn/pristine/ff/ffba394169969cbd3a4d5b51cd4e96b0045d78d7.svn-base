package kr.or.ddit.user.fileitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.fileitem.dao.IFileItemDao;
import kr.or.ddit.user.fileitem.dao.IFileItemDaoImpl;
import kr.or.ddit.vo.FileItemVO;

public class IFileItemServiceImpl implements IFileItemService {

	  private static IFileItemService service = new IFileItemServiceImpl();
	  private IFileItemDao dao;
	  private IFileItemServiceImpl(){
		  dao = IFileItemDaoImpl.getInstance();
	  }
	  
	  public static IFileItemService getInstance(){
		   return (service == null) ? service = new IFileItemServiceImpl() : service;
	  }
	  
	  
	
	
	@Override
	public void insertFileItemInfo(List<FileItemVO> fileItemList) {
                 try {
					dao.insertFileItemInfo(fileItemList);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public FileItemVO fileItemInfo(Map<String, String> params) {
         FileItemVO fileItemInfo = null;
         try {
			fileItemInfo = dao.fileItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileItemInfo;
	}

}
