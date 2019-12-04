package kr.or.ddit.thumbnailboard.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.ThumbnailItemVO;
import kr.or.ddit.vo.ThumbnailVO;

public interface IThumbnailBoardService {
	// 등록
//	public String insertThumbnailBoard(ThumbnailVO thumbnamilInfo);
	public void insertThumbnailBoard(ThumbnailVO thumbnamilInfo);
	
	// 수정
	public void updateThumbnailBoard(ThumbnailVO thumbnamilInfo);
	
	// 삭제
	public void deleteThumbnailBoard(Map<String, String> params);
	
	// 전체 목록 출력
	public List<ThumbnailVO> ThumbnailList(Map<String, String> params);
	
	// 상세보기
	public ThumbnailVO thumbnailInfo(Map<String, String> params);
	
	public String totalCount(Map<String, String> params);
	
	public String getTbSeq();
	
	public List<ThumbnailItemVO> getSaveName(Map<String, String> params);
}
