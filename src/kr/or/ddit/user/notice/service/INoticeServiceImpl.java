package kr.or.ddit.user.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;








import kr.or.ddit.user.notice.dao.INoticeDao;
import kr.or.ddit.user.notice.dao.INoticeDaoImpl;
import kr.or.ddit.user.noticeitem.dao.INoticeItemDao;
import kr.or.ddit.user.noticeitem.dao.INoticeItemDaoImpl;
import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public class INoticeServiceImpl implements INoticeService {

	private static INoticeService service = new INoticeServiceImpl();
	private INoticeDao noticeDao;
	private INoticeItemDao noticeitemDao;
	
	private INoticeServiceImpl(){
		noticeDao = INoticeDaoImpl.getInstance();
		noticeitemDao = INoticeItemDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance(){
		return (service == null) ? service = new INoticeServiceImpl() : service;
	}
	
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) {
		List<NoticeVO> noticeList = null;
		try{
			noticeList = noticeDao.noticeList(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo){
		String notice_no = null;
		try{
			notice_no = noticeDao.insertNoticeInfo(noticeInfo);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return notice_no;
	}


	@Override
	public NoticeVO noticeInfo(Map<String, String> params) {
		NoticeVO noticeInfo = null;
		try{
			noticeInfo = noticeDao.noticeInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeInfo;
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) {
		try{
			noticeDao.updateNoticeInfo(noticeInfo);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params) {
		try{
			noticeDao.deleteNoticeInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String cnt = null;
		try{
			cnt = noticeDao.totalCount(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cnt;
	}

	

}
