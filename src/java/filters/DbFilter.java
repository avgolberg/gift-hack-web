package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DbFilter implements Filter  {
 private FilterConfig filterConfig;
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
           data.DBConnection.GetConnection();
        }
        catch(Exception ex){
           //переадресация на статическую страницу
           request.setAttribute("dbError", ex.getMessage());
           request.getRequestDispatcher("static.jsp").forward(request, response);
           return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
    
}
