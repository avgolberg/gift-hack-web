
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-gift")
public class DeleteGiftServlet extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          if(request.getParameter("listId")!=null && request.getParameter("id")!=null){
                String listId = request.getParameter("listId");
                String id = request.getParameter("id");
                Connection con;
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "DELETE FROM Gifts WHERE `listId`='" + listId + "' AND `id`='"+ id + "'"
                        );                    
                }
                catch(Exception ex){
                   request.setAttribute("dbError", ex.getMessage());
                   request.getRequestDispatcher("static.jsp").forward(request, response);
                   return;
                }
                ((HttpServletResponse) response).sendRedirect("/GiftHack/lists?id=" + listId);
        }
    }
}
