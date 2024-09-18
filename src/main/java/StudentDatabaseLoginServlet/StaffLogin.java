package StudentDatabaseLoginServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Staff;
import StudentDataBaseDto.Teacher;

@WebServlet("/study")
public class StaffLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("u2");
		String pass=req.getParameter("p2");
		List<Staff> l = new ArrayList<>();
		StudentDatabaseDao s1 = new StudentDatabaseDao();
		ResultSet r =s1.staffLogin(user, pass);
		
		try {
			if(r.next())
			{
				Staff s = new Staff();
				s.setId(r.getInt(1));
				s.setName(r.getString(2));
				s.setPhoneNumber(r.getString(3));
				s.setEmail(r.getString(4));
				s.setDesignation(r.getString(5));
				s.setSalary(r.getString(6));
				l.add(s);
				HttpSession h = req.getSession();
				h.setAttribute("list7", l);
				resp.sendRedirect("Staffloginform.jsp");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid password. Please try again.');");
				out.println("window.location = 'Stafflogin.html';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}


