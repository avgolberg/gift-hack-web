package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit-list")
public class EditListServlet extends HttpServlet{
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                request.getRequestDispatcher("editList.jsp").forward(request, response);
	}
        
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   
                 if(request.getParameter("id")!=null){
                        String listId = request.getParameter("id");
                        String listName = toUTF8(request.getParameter("name"));
                        String authorId = toUTF8(request.getParameter("authorId"));
                
                Connection con;
                
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "UPDATE Lists SET `id`='" + listId + "', `name`='" + listName + "', `authorId`='" + authorId + "' WHERE `id`='" + listId + "'"
                        );                    
                }
                catch(Exception ex){
                   request.setAttribute("dbError", ex.getMessage());
                   request.getRequestDispatcher("static.jsp").forward(request, response);
                   return;
                }
                ((HttpServletResponse) response).sendRedirect("/GiftHack/lists");
                }
               
	}

         private String toUTF8(String parameter){
            byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
}
