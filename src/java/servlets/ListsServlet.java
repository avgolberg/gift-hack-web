package servlets;

import data.GiftList;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            try{
                HttpSession session = ((HttpServletRequest) request).getSession();
                int authorId = parseInt((String)session.getAttribute("userId"));
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

        
//        String uri = ((String)request.getAttribute("javax.servlet.include.request_uri"));
//        String command = uri.substring(uri.lastIndexOf('/')+1);
//        
//        if(command!=null && command.equals("new")){
//            request.getRequestDispatcher("newList.jsp").forward(request, response);
//        }        

      @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              try{
                HttpSession session = ((HttpServletRequest) request).getSession();
                int authorId = (int)session.getAttribute("userId");
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
        
}
