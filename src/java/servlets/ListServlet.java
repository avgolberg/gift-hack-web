/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher("list.jsp").forward(request, response); 
//        String info = request.getPathInfo();
//         if(info!=null) {
//             if(!extractId(request).equals("")){
//                String id = extractId(request);
//                Connection con;
//                 try{
//                    con = data.DBConnection.GetConnection();
//                    Statement cmd = con.createStatement();
//                    ResultSet r = cmd.executeQuery("SELECT * FROM Lists WHERE id='" + id +  "'");
//                    if(r.next()){
//                        request.setAttribute("listId", id);
//                        request.setAttribute("listName", r.getString("name"));
//                        r.close();
//                        ResultSet r2 = cmd.executeQuery("SELECT * FROM Users WHERE id='" + r.getString("authorId") +  "'");
//                        request.setAttribute("authorName", r2.getString("username"));
//                        r2.close();
//                        //((HttpServletResponse) response).sendRedirect("/GiftHack/lists/" + id);
//                        //request.getRequestDispatcher("list.jsp").forward(request, response);
//                    }
//                    else{
//                       // response.setStatus(404);
//                        request.getRequestDispatcher("not-found.jsp").forward(request, response);
//                        return;
//                    }
//                    
//                 }
//                 catch(Exception ex){
//                    request.setAttribute("dbError", ex.getMessage());
//                    request.getRequestDispatcher("static.jsp").forward(request, response);
//                    return;
//                 }
//                 
//              }
//              request.getRequestDispatcher("list.jsp").forward(request, response);
//         }
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
             request.getRequestDispatcher("list.jsp").forward(request, response);
              
	}
        
        private String extractId(HttpServletRequest req){
            String info = req.getPathInfo(); 
            if(info!=null){
                int len = info.length();
                if(info.endsWith("/")){
                    len--;
                }
                info = info.substring(1, len);
                return info;
            }
            return "";
        }
}
