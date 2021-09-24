package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import javax.servlet.http.HttpSession;


@WebServlet("/new-list")
public class NewListServlet extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                
            
                request.getRequestDispatcher("newList.jsp").forward(request, response);
	}
        
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                HttpSession session = ((HttpServletRequest) request).getSession();
                
                String uniqueId = UUID.randomUUID().toString().substring(0, 8);
                String listName = toUTF8(request.getParameter("name"));
                String authorId = toUTF8(request.getParameter("authorId"));
                
                Connection con;
                
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "INSERT INTO Lists (id, name, authorId) VALUES "
                            + "('" + uniqueId + "', '" + listName + "', '" + authorId +  "')"
                        );                    
                }
                catch(Exception ex){
                   request.setAttribute("dbError", ex.getMessage());
                   request.getRequestDispatcher("static.jsp").forward(request, response);
                   return;
                }
                ((HttpServletResponse) response).sendRedirect("/GiftHack/lists");
	}

         private String toUTF8(String parameter){
            byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
      
}
