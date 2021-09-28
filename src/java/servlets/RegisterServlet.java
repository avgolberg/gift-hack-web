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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                HttpSession session = ((HttpServletRequest) request).getSession();
                String username = toUTF8(request.getParameter("username"));
                String name = toUTF8(request.getParameter("name"));
		String surname = toUTF8(request.getParameter("surname"));
		String email = toUTF8(request.getParameter("email"));
                String birthday = toUTF8(request.getParameter("birthday"));
                String password = util.Hasher.fromString(request.getParameter("password"));
                
                Connection con;
                try{
                    con = data.DBConnection.GetConnection();
                    Statement cmd = con.createStatement();
                    ResultSet r = cmd.executeQuery("SELECT COUNT(*) AS rowcount FROM Users WHERE username='" + username +  "'");
                    r.next();   
                    int count = r.getInt("rowcount");
                    r.close();
                    if(count == 0){                    
                        cmd.executeUpdate(
                            "INSERT INTO Users (username, name, surname, email, birthday, password) VALUES "
                            + "('" + username + "', '" + name + "', '" + surname + "', '" + email + "', '" +  birthday + "', '" + password +  "')"
                        );
                        request.setAttribute("registration", "User registered successfully!");
                        
                        ResultSet res = cmd.executeQuery( "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "'" ) ;
                        if (res.next()){
                            session.setAttribute("username", res.getString("name"));
                            session.setAttribute("userId", res.getString("id"));
                            ((HttpServletResponse) response).sendRedirect("/GiftHack/lists");
                        }
                    }
                    else{
                        request.setAttribute("registration", "Username has already been used.");
                        
                        request.setAttribute("name", name);
                        request.setAttribute("surname", surname);
                        request.setAttribute("email", email);
                        request.setAttribute("birthday", birthday);

                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    }
                 }
                 catch(Exception ex){
                    request.setAttribute("registration", "User is not registered!");
                    request.setAttribute("dbError", ex.getMessage());
                    request.getRequestDispatcher("static.jsp").forward(request, response);
                    return;
                 }
	}

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	private String toUTF8(String parameter){
            byte[] bytes = parameter.getBytes(StandardCharsets.ISO_8859_1);
            return new String(bytes, StandardCharsets.UTF_8);
        }
}
