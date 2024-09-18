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
import StudentDataBaseDto.Teacher;

@WebServlet("/teacherlog")
public class TeacherLogin  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("u1");
		String pass=req.getParameter("p1");
		List<Teacher> l = new ArrayList<>();
		StudentDatabaseDao s1 = new StudentDatabaseDao();
		ResultSet r =s1.teacherLogin(user, pass);
		
		try {
			if(r.next())
			{
				Teacher t = new Teacher();
				t.setId(r.getInt(1));
				t.setName(r.getString(2));
				t.setSubject(r.getString(3));
				t.setClassTeacher(r.getString(4));
				t.setPhone(r.getString(5));
				t.setEmail(r.getString(6));
				t.setSalary(r.getString(7));
				l.add(t);
				HttpSession h = req.getSession();
				h.setAttribute("list6", l);
				resp.sendRedirect("Teacherloginfotm.jsp");
			}
			else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid password. Please try again.');");
				out.println("window.location = 'TeacherLogin.html';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
