package filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      
       
         chain.doFilter(request, response);
       //((HttpServletResponse) response).sendRedirect("/GiftHack/");
       //request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private String toUTF8(String parameter){
      byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
      return new String(bytes, StandardCharsets.UTF_8);
    }
    
    @Override
    public void destroy() {
        
    }
    
}
