package servlets;

import data.ReservedGift;
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

@WebServlet("/shop-for")
public class ShopForServlet extends HttpServlet{
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          try{
                HttpSession session = ((HttpServletRequest) request).getSession();
                int userId = parseInt((String)session.getAttribute("userId"));
                Connection con = data.DBConnection.GetConnection();
                Statement cmd = con.createStatement();
                ResultSet r = cmd.executeQuery("SELECT gifts.id as giftId, gifts.name as giftName, quantity, link, ranking, comment, authorId, users.name "
                        + "FROM gifts inner join lists on gifts.listId = lists.id inner join users on authorId = users.id "
                        + "WHERE gifts.id IN (SELECT giftId FROM reservedgifts WHERE userId = '" + userId + "')");
                ArrayList<ReservedGift> reservedGifts = new ArrayList<>();
                while(r.next()){
                    reservedGifts.add(new ReservedGift(r.getInt("giftId"),r.getString("giftName"),
                            r.getInt("quantity"),r.getString("link"),r.getInt("ranking"),
                            r.getString("comment"),r.getInt("authorId"),r.getString("name")));
                }
                r.close();  
                request.setAttribute("reservedGifts",reservedGifts);   
                request.getRequestDispatcher("shopFor.jsp").forward(request, response);
                }
            catch(Exception ex){
               request.setAttribute("dbError", ex.getMessage());
               request.getRequestDispatcher("static.jsp").forward(request, response);
               return;
            }
    }
}
