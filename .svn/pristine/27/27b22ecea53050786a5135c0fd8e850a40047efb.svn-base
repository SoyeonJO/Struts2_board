package kr.or.ddit.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.sun.org.apache.regexp.internal.RESyntaxException;

public class IPCheckFilter implements Filter {

	private static Map<String, String> ipMap;
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("IPCheckFilter의 init() 콜백");
	
		// -Djava.net.preferIPv4Stack=true 
		// (debug configuration argument 맨 아래 적어야하는 것)
		ipMap = new HashMap<String, String>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("0:0:0:0:0:0:0:1", "A");
		ipMap.put("0:0:0:0:0:0:0:1", "A");
		ipMap.put("192.168.207.141", "A");
//		ipMap.put("192.168.207.144", "F");
	}
		

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		String clientIP = servletRequest.getRemoteAddr();
		
		boolean flag = true;
		// clientIP != null || clientIP != "" 일때만 true
		if(!StringUtils.isNotEmpty(clientIP) && !ipMap.containsKey(clientIP)) {
			flag = false;
		}
		
		if(flag) {
			filterChain.doFilter(servletRequest, servletResponse);
		}else {
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<font color='red'>접근이 금지된 아이피입니다. 관리자에게 문의해 주세요.</font>");
			
			out.println("</body>");
			out.println("</html>");
		}
	}
}
