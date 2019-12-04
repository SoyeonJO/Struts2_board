package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

import org.apache.commons.lang3.StringUtils;

public class LoginCheckFilter implements Filter{

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      HttpServletRequest request = (HttpServletRequest) servletRequest;
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      MemberVO isLogin =  (MemberVO) request.getSession().getAttribute("LOGIN_MEMBERINFO");
      String requestURI = request.getParameter("contentPage");
      
      if(isLogin == null){
         String requestUrl = request.getRequestURL().toString();
         if(request.getRequestURL().toString().split("/")[request.getRequestURL().toString().split("/").length-1].equals("loginCheck.jsp")){
            filterChain.doFilter(servletRequest, servletResponse);
         }else if(requestURI != null){
               if(requestURI.contains("freeboardView")||requestURI.contains("freeboardList")){
                  filterChain.doFilter(servletRequest, servletResponse);
               }else{
                  request.getRequestDispatcher("/13/main.jsp?contentPage=/13/freeboard/freeboardList.jsp").forward(request, response);
               }
         }else{
            request.getRequestDispatcher("/13/main.jsp?contentPage=/13/freeboard/freeboardList.jsp").forward(request, response);
         }
      }else{
         filterChain.doFilter(servletRequest, servletResponse);
      }
      
   }

   @Override
   public void destroy() {
      // TODO Auto-generated method stub
      
   }
   
   @Override
   public void init(FilterConfig arg0) throws ServletException {
      // TODO Auto-generated method stub
      
   }

}