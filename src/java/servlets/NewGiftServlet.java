package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new-gift")
public class NewGiftServlet extends HttpServlet{
     @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                request.getRequestDispatcher("newGift.jsp").forward(request, response);
	}
        
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {                
              if(request.getParameter("listId")!=null){    
            
                String giftName = toUTF8(request.getParameter("name"));
                String quantity = toUTF8(request.getParameter("quantity"));
                String ranking = toUTF8(request.getParameter("ranking"));
                String comment = toUTF8(request.getParameter("comment"));
                String link = toUTF8(request.getParameter("link"));
                String listId = (String)request.getParameter("listId");
                
                Connection con;
                
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "INSERT INTO Gifts (name, quantity, link, ranking, comment, listId) VALUES "
                            + "('" + giftName + "', '" + quantity + "', '" + link + "', '" + ranking + "', '" + comment + "', '" + listId +  "')"
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

         private String toUTF8(String parameter){
            byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
}
