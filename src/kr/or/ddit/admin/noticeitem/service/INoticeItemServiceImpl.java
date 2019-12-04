package kr.or.ddit.admin.noticeitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.noticeitem.dao.INoticeItemDao;
import kr.or.ddit.admin.noticeitem.dao.INoticeItemDaoImpl;
import kr.or.ddit.vo.NoticeItemVO;

public class INoticeItemServiceImpl implements INoticeItemService {

	private static INoticeItemService service = new INoticeItemServiceImpl();
	private INoticeItemDao dao;
	private INoticeItemServiceImpl() {
		dao = INoticeItemDaoImpl.getInstance();
	}
	 

	public static INoticeItemService getInstance(){
		return(service == null) ? service = new INoticeItemServiceImpl() : service;
	}
	
	@Override
	public void insertNoticeItemInfo(List<NoticeItemVO> noticeItemList) {
		try{
			dao.insertNoticeItemInfo(noticeItemList);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public NoticeItemVO noticeItemInfo(Map<String, String> params) {
		NoticeItemVO noticeItemList = null;
		try{
			noticeItemList = dao.noticeItemInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeItemList;
	}

}
