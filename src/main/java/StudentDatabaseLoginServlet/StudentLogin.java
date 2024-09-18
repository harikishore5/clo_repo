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
import StudentDataBaseDto.Student;

@WebServlet("/studentlogin1")
public class StudentLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user =req.getParameter("u");
		String pass = req.getParameter("p");
//		System.out.println(user);
//		System.out.println(pass);
//		PrintWriter p = resp.getWriter();
//		p.print(user+" "+pass);
		
		
		StudentDatabaseDao s1 = new StudentDatabaseDao();
		List<Student> l = new ArrayList<>();
		ResultSet r = s1.studentLogin(user,pass);
		
		try {
			if(r.next())
			{
				Student s = new Student();
				s.setId(r.getInt(1));
				s.setName(r.getString(2));
				s.setSubject(r.getString(3));
				s.setSection(r.getString(4));
				s.setParent_contact(r.getString(5));
				s.setEmail(r.getString(6));
				s.setOverallPercentage(r.getString(7));
				s.setGender(r.getString(8));
				l.add(s);
				HttpSession h =req.getSession();
				h.setAttribute("list5", l);
				resp.sendRedirect("Studentlogindetails.jsp");
				
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid password. Please try again.');");
				out.println("window.location = 'slogin.html';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
