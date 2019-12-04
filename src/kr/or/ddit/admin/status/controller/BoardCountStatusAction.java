package kr.or.ddit.admin.status.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.admin.status.service.IStatusService;
import kr.or.ddit.admin.status.service.IStatusServiceImpl;
import kr.or.ddit.vo.BoardVO;

import org.apache.struts2.ServletActionContext;

public class BoardCountStatusAction {
	
	public String execute() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		IStatusService service = IStatusServiceImpl.getInstance();
		
		List<BoardVO> boardCnt = service.countBoard();
		
		request.setAttribute("freeboard", boardCnt.get(0).getFreeboard());
		request.setAttribute("thumbnail", boardCnt.get(0).getThumbnail());
		request.setAttribute("notice", boardCnt.get(0).getNotice());
		request.setAttribute("ref", boardCnt.get(0).getRef());
		
		return "success";
	}

	
}
