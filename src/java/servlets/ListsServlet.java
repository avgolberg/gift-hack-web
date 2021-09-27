package servlets;

import data.Gift;
import data.GiftList;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
        lists(request, response);
    }
    
    private void lists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
                
                ArrayList<Integer> reservedGifts = new ArrayList<>();
                ResultSet r1 = cmd.executeQuery("SELECT giftId FROM reservedgifts");
                while(r1.next()){
                    reservedGifts.add(r1.getInt("giftId"));
                }
                r1 = cmd.executeQuery("SELECT * FROM Gifts WHERE listId='" + listId +  "'");
                ArrayList<Gift> gifts = new ArrayList<Gift>();
                boolean isReserved;
              
                while(r1.next()){
                    isReserved = reservedGifts.contains(r1.getInt("id"));
                    if(isReserved){
                        int reservedBy = reservedBy(request, response, r1.getInt("id"));
                        if(reservedBy!=0)
                        gifts.add(new Gift(r1.getInt("id"), r1.getString("name"),r1.getString("link"), 
                       parseInt(r1.getString("ranking")), parseInt(r1.getString("quantity")),r1.getString("comment"), 
                       listId, isReserved, reservedBy));
                    }
                    else{
                       gifts.add(new Gift(r1.getInt("id"), r1.getString("name"),r1.getString("link"), 
                       parseInt(r1.getString("ranking")), parseInt(r1.getString("quantity")),r1.getString("comment"), 
                       listId, isReserved)); 
                    }
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
            } catch (Exception ex) {
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
        }
    }
    
    private int reservedBy(HttpServletRequest request, HttpServletResponse response, int giftId) throws ServletException, IOException{
        try{
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r2 = cmd.executeQuery("SELECT userId FROM reservedgifts WHERE giftId='" + giftId +  "'");
                if(r2.next()){
                   return r2.getInt("userId");
                }
        }catch (Exception ex) {
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return 0;
        }
        return 0;
    }
        
      @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                lists(request, response);
	}
        
}
