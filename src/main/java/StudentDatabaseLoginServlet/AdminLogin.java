package StudentDatabaseLoginServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.StudentDao.StudentDatabaseDao;

@WebServlet("/log")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		StudentDatabaseDao s = new StudentDatabaseDao();
		if(s.adminLogin(user, pass))
		{
			resp.sendRedirect("AllStudentsave.html");
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid password. Please try again.');");
			out.println("window.location = 'AdminLogin.html';");
			out.println("</script>");
		}
	}

}
