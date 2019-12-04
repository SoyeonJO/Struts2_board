package kr.or.ddit.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.ZipCodeVO;

public class ZipSearchAction {
	
	private String dong;
	private List<ZipCodeVO> ziplist;
	
	public void execute() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		IMemberService service = IMemberServiceImpl.getInstance();
		this.ziplist = service.zipcodeList(this.dong);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonData;
		
		try {
			jsonData = mapper.writeValueAsString(this.ziplist);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public List<ZipCodeVO> getZiplist() {
		return ziplist;
	}
	
	

}
