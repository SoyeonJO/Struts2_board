package kr.or.ddit.admin.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {


	public List<NoticeVO> noticeList(Map<String, String> params);
	public String insertNoticeInfo(NoticeVO noticeInfo);
	public void updateNoticeInfo(NoticeVO noticeInfo);
	public NoticeVO noticeInfo(Map<String, String> params);
	public void deleteNoticeInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);

}
