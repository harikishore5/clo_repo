package AllStudentDataBase;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Com.StudentDao.StudentDatabaseDao;
import StudentDataBaseDto.Teacher;

@WebServlet("/teacherdata")
public class TeachersData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDatabaseDao s = new StudentDatabaseDao();
		List<Teacher> l = s.allTeachersData();
		//System.out.println(l);
		HttpSession h =req.getSession();
		h.setAttribute("list2", l);
		resp.sendRedirect("teacherAllData.jsp");
	}

}
