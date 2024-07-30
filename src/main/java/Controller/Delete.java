package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Registration;
@WebServlet(name = "Delete", urlPatterns = {"/delete"}) 
public class Delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try { 
			HttpSession session=req.getSession(); 
			Registration reg=new Registration(session); 
			int id=Integer.parseInt(req.getParameter("userid"));  
			String status=reg.delete(id); 
			if(status.equals("success")) { 
			req.setAttribute("status", "Account Deleted Sucessfully"); 
			RequestDispatcher re=req.getRequestDispatcher("delete.jsp"); 
			re.forward(req, resp); 
			}else { 
			req.setAttribute("status", "Failure Occured"); 
			RequestDispatcher re=req.getRequestDispatcher("delete.jsp"); 
			re.forward(req, resp); 
			} 
			}catch(Exception e) { 
			e.printStackTrace(); 
			} 		
	}
}
