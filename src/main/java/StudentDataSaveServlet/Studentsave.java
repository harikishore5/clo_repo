package StudentDataSaveServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Student;
@WebServlet("/studentsave")
public class Studentsave extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String subj=req.getParameter("sub");
		String section =req.getParameter("sec");
		String parentContact=req.getParameter("pcontact");
		
		String email =req.getParameter("email");
		String overallPercenteage =req.getParameter("op");
		String gender =req.getParameter("gender");
		Student s1 = new Student();
		StudentDatabaseDao s2 = new StudentDatabaseDao();
		s1.setName(name);
		s1.setEmail(email);
		s1.setSection(section);
		s1.setGender(gender);
		s1.setOverallPercentage(overallPercenteage);
		s1.setGender(gender);
		s1.setSubject(subj);
		s1.setParent_contact(parentContact);
		PrintWriter p =resp.getWriter();
		p.print("<h1>"+s2.saveStudent(s1)+"</h1>");
		
		
		
		
		
		
		
	}

}
