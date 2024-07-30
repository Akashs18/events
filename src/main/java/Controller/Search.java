package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Registration;

@WebServlet(name = "Search", urlPatterns = {"/search"})
public class Search extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Registration u = new Registration(session);
        try {
            if(session.getAttribute("id") != null && session.getAttribute("id").equals("1")){
            String id = req.getParameter("id");
            //request.getRequestDispatcher("search.jsp?id=" + id).forward(request, response);
	resp.sendRedirect("search.jsp?id="+id);            
	}
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

		
	}


