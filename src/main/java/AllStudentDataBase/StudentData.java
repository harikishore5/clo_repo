package AllStudentDataBase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Student;
@WebServlet("/studentdata")
public class StudentData extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDatabaseDao s = new StudentDatabaseDao();
		List<Student> l =s.allSudentsData();
				HttpSession h = req.getSession();
				h.setAttribute("list3", l);
				resp.sendRedirect("StudentAllData.jsp");
			
			
	}

}
