package StudentDataSaveServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Staff;

@WebServlet("/staffsavee")
public class Staffsave extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone =req.getParameter("ph");
		String email = req.getParameter("email");
		String desig = req.getParameter("dg");
		String sal = req.getParameter("sal");
		Staff s = new Staff();
		StudentDatabaseDao s1 = new StudentDatabaseDao();
		s.setDesignation(desig);
		s.setEmail(email);
		s.setName(name);
		s.setPhoneNumber(phone);
		s.setSalary(sal);
		PrintWriter p = resp.getWriter();
		p.print("<h1>"+s1.saveStaff(s)+"</h1>");
		
	}
}
