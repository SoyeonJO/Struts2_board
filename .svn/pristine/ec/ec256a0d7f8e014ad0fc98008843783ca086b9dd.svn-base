package kr.or.ddit.admin.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import kr.or.ddit.admin.member.service.IAdminMemberService;
import kr.or.ddit.admin.member.service.IAdminMemberServiceImpl;
import kr.or.ddit.vo.ZipCodeVO;

public class SelectGugun {

	private String sido;
	
	public void execute() {
		
		IAdminMemberService service = IAdminMemberServiceImpl.getInstance();
		List<ZipCodeVO> selectGugun = service.selectGugun(this.sido);
		
		Map<Object, Object> jsonMap = new HashMap<Object, Object>();
		jsonMap.put("selectGugun", selectGugun);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonData;
		
		try {
			jsonData = mapper.writeValueAsString(jsonMap);

			HttpServletResponse response = ServletActionContext.getResponse();
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

	public void setSido(String sido) {
		this.sido = sido;
	}

	
}
