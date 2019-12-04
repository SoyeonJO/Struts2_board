package kr.or.ddit.thumbnailitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.ThumbnailItemVO;

public interface IThumbnailItemService {
	public void insertThumbnailItemInfo(List<ThumbnailItemVO> thumbnailItemList);
	
	public ThumbnailItemVO thumbnailItemInfo(Map<String, String> params);
}
