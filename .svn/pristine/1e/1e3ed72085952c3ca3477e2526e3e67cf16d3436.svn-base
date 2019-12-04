package kr.or.ddit.admin.status.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import kr.or.ddit.admin.status.service.IStatusService;
import kr.or.ddit.admin.status.service.IStatusServiceImpl;

public class InsertDateStatusAction {
	
	public String execute() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		IStatusService service = IStatusServiceImpl.getInstance();
		
		for(int i = 1; i <= 12; i++ ) {
			if(i < 10) {
				String date = String.valueOf(i);
				String lessdate = "0" + date;
				date = service.countInsertDate(lessdate);
				request.setAttribute("date" + i , date);
			}else {
				String date = String.valueOf(i);
				date = service.countInsertDate(date);
				request.setAttribute("date" + i, date);
			}
		}
		
		return "success";
	}
	

}
