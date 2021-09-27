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
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               
                HttpSession session = ((HttpServletRequest) request).getSession();
              
        if(request.getParameter("logout")!=null){
          session.removeAttribute("username");
          session.removeAttribute("userId");
          ((HttpServletResponse) response).sendRedirect("/GiftHack/");
          return;
        }
            
        String username = toUTF8(request.getParameter("username"));
        String password = util.Hasher.fromString(request.getParameter("password"));

        Connection con;

         try{
            con = data.DBConnection.GetConnection();
            Statement cmd = con.createStatement();
            
             ResultSet res = cmd.executeQuery( "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'" ) ;
            if (res.next()){
                session.setAttribute("username", res.getString("name"));
                session.setAttribute("userId", res.getString("id"));
                //request.getRequestDispatcher("lists.jsp").forward(request, response);
                ((HttpServletResponse) response).sendRedirect("/GiftHack/lists");
            }
            else {
                request.setAttribute("loginError", "Not valid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
         }
         catch(Exception ex){
            request.setAttribute("dbError", ex.getMessage());
            request.getRequestDispatcher("static.jsp").forward(request, response);
            return;
         }
	}

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              HttpSession session = ((HttpServletRequest) request).getSession();
                    if(request.getParameter("logout")!=null){
                    session.removeAttribute("username");
                    session.removeAttribute("userId");
                    ((HttpServletResponse) response).sendRedirect("/GiftHack/");
                    return;
                  }
                request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	 private String toUTF8(String parameter){
            byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
}
