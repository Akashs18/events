package Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Registration;
@WebServlet(name = "Booking", urlPatterns = {"/booking"})
public class Booking extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		resp.setContentType("text/html;charset=UTF-8"); 
        // type of the response sent to the client or browser 
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Registration r = new Registration(session);
        try {
            
            
if (session.getAttribute("uname") != null && req.getParameter("bookevent") != null) {
                String status = r.Booknow(req);
                if (status.equals("success")) {
                    req.setAttribute("status", "Booking successful.<a href='EventStatus.jsp'>Click here</a> to check status.");
                    RequestDispatcher rd = req.getRequestDispatcher("BookingForm.jsp?event_id=" + req.getParameter("event_id"));
                    rd.forward(req, resp);
                } else if (status.equals("failure")) {
                    req.setAttribute("status", "Booking failed");
                    RequestDispatcher rd = req.getRequestDispatcher("BookingForm.jsp?event_id=" + req.getParameter("event_id"));
                    rd.forward(req, resp);
                } else if (status.equals("existed")) {
                    req.setAttribute("status", "Date not available for event");
                    RequestDispatcher rd = req.getRequestDispatcher("BookingForm.jsp?event_id=" + req.getParameter("event_id"));
                    rd.forward(req, resp);
                }
            } 
        } catch (Exception e) {
            e.printStackTrace();

        }
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	processRequest(req, resp);
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	processRequest(req, resp);
	}
@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>
}

