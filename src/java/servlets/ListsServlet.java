package servlets;

import data.Gift;
import data.GiftList;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lists/*")
public class ListsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        int authorId = parseInt((String)session.getAttribute("userId"));
            if(request.getParameter("id")==null){
            try{
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r = cmd.executeQuery("SELECT * FROM Lists WHERE authorId='" + authorId +  "'");
                ArrayList<GiftList> giftLists = new ArrayList<GiftList>();
                while(r.next()){
                    giftLists.add(new GiftList(r.getString("id"),r.getString("name"),authorId));
                }
                r.close();  
                request.setAttribute("lists",giftLists);   
                request.getRequestDispatcher("lists.jsp").forward(request, response);
                }
            catch(Exception ex){
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
         }
        else{
            String listId = request.getParameter("id");
            try {
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r1 = cmd.executeQuery("SELECT * FROM Gifts WHERE listId='" + listId +  "'");
                ArrayList<Gift> gifts = new ArrayList<Gift>();
                
                while(r1.next()){
                    gifts.add(new Gift(r1.getInt("id"), r1.getString("name"),r1.getString("link"), 
                            parseInt(r1.getString("ranking")), parseInt(r1.getString("quantity")),r1.getString("comment"), 
                            listId));
                }
                request.setAttribute("gifts",gifts);   
                r1 = cmd.executeQuery("SELECT * FROM Lists WHERE id='" + listId +  "'");
                if(r1.next()){
                    request.setAttribute("listName",r1.getString("name")); 
                    request.setAttribute("listId",listId); 
                    request.setAttribute("authorId",r1.getString("authorId")); 
                }
               
                r1.close();
                request.getRequestDispatcher("lists.jsp").forward(request, response);
                
                //if(authorId == )
            } catch (Exception ex) {
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
        }
    }
        
      @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                    HttpSession session = ((HttpServletRequest) request).getSession();
        int authorId = parseInt((String)session.getAttribute("userId"));
            if(request.getParameter("id")==null){
            try{
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r = cmd.executeQuery("SELECT * FROM Lists WHERE authorId='" + authorId +  "'");
                ArrayList<GiftList> giftLists = new ArrayList<GiftList>();
                while(r.next()){
                    giftLists.add(new GiftList(r.getString("id"),r.getString("name"),authorId));
                }
                r.close();  
                request.setAttribute("lists",giftLists);   
                request.getRequestDispatcher("lists.jsp").forward(request, response);
                }
            catch(Exception ex){
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
         }
        else{
            String listId = request.getParameter("id");
            try {
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r = cmd.executeQuery("SELECT * FROM Gifts WHERE listId='" + listId +  "'");
                ResultSet r2 = cmd.executeQuery("SELECT * FROM Lists WHERE id='" + listId +  "'");
                ArrayList<Gift> gifts = new ArrayList<Gift>();
                while(r.next()){
                    gifts.add(new Gift(parseInt(r.getString("id")), r.getString("name"),r.getString("link"), 
                            parseInt(r.getString("ranking")), parseInt(r.getString("quantity")),r.getString("comment"), 
                            listId));
                }
                r.close();  
                request.setAttribute("gifts",gifts);   
                request.setAttribute("listName",r2.getString("name")); 
                request.setAttribute("authorId",r2.getString("authorId")); 
                request.getRequestDispatcher("lists.jsp").forward(request, response);
                
                //if(authorId == )
            } catch (Exception ex) {
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
        }
	}
        
}
