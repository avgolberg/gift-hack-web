package servlets;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reserve-gift")
public class ReserveGiftServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getParameter("listId")!=null && request.getParameter("id")!=null){
                HttpSession session = ((HttpServletRequest) request).getSession();
                int userId = parseInt((String)session.getAttribute("userId"));
                String giftId = request.getParameter("id");
                String listId = request.getParameter("listId");                
                Connection con;
                try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    cmd.executeUpdate(
                            "INSERT INTO ReservedGifts (giftId, userId) VALUES "
                            + "('" + giftId + "', '" + userId + "')"
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
