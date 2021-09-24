package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lists")
public class ListsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        
        
        
//        String uri = ((String)request.getAttribute("javax.servlet.include.request_uri"));
//        String command = uri.substring(uri.lastIndexOf('/')+1);
//        
//        if(command!=null && command.equals("new")){
//            request.getRequestDispatcher("newList.jsp").forward(request, response);
//        }        

        request.getRequestDispatcher("lists.jsp").forward(request, response);
        
      
    }
      @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              request.getRequestDispatcher("lists.jsp").forward(request, response);
              
	}
}
