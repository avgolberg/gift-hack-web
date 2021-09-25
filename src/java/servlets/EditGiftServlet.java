package servlets;

import data.Gift;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-gift")
public class EditGiftServlet extends HttpServlet{
       @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            if(request.getParameter("listId")!=null && request.getParameter("id")!=null){
                        String listId = request.getParameter("listId");
                        String id = request.getParameter("id");       
                        
                Connection con;
                
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    ResultSet r1 = cmd.executeQuery(
                            "SELECT * FROM Gifts WHERE `listId`='" + listId + "' AND `id`='"+ id + "'"
                    );     
                    
                     if(r1.next()){
                         request.setAttribute("giftName", r1.getString("name"));
                         request.setAttribute("quantity", r1.getString("quantity"));
                         request.setAttribute("ranking", r1.getString("ranking"));
                         request.setAttribute("comment", r1.getString("comment"));
                         request.setAttribute("link", r1.getString("link"));
                }
                       
                }
                catch(Exception ex){
                   request.setAttribute("dbError", ex.getMessage());
                   request.getRequestDispatcher("static.jsp").forward(request, response);
                   return;
                }
                request.getRequestDispatcher("editGift.jsp").forward(request, response);
                }
	}
        
     @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   
                 if(request.getParameter("listId")!=null && request.getParameter("id")!=null){
                        String listId = request.getParameter("listId");
                        String id = request.getParameter("id");       
                        
                        String giftName = toUTF8(request.getParameter("name"));
                        String quantity = toUTF8(request.getParameter("quantity"));
                        String ranking = toUTF8(request.getParameter("ranking"));
                        String comment = toUTF8(request.getParameter("comment"));
                        String link = toUTF8(request.getParameter("link"));
                
                
                Connection con;
                
                 try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "UPDATE Gifts SET `id`='" + id + "', `name`='" + giftName + "', `quantity`='" + quantity + "', `link`='" + link
                                    + "', `ranking`='" + ranking + "', `comment`='" + comment + "', `listId`='" + listId 
                                    + "' WHERE `id`='" + id + "' AND `listId`='"+ listId + "'"
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
