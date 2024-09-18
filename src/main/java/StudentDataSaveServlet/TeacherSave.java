package StudentDataSaveServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Teacher;

@WebServlet("/teachersave")
public class TeacherSave extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name =req.getParameter("name");
		String sub = req.getParameter("sub");
		String classTeacher= req.getParameter("ct");
		String phone = req.getParameter("ph");
		String email = req.getParameter("email");
		String salary = req.getParameter("sal");
		Teacher t = new Teacher();
		t.setName(name);
		t.setEmail(email);
		t.setPhone(phone);
		t.setSalary(salary);
		t.setClassTeacher(classTeacher);
		t.setSubject(sub);
		StudentDatabaseDao s= new StudentDatabaseDao();
		
		PrintWriter p = resp.getWriter();
		p.print("<h1>"+s.saveTeacher(t)+"</h1>");
	}

}
