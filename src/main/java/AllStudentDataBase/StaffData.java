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
import StudentDataBaseDto.Staff;

@WebServlet("/staff")
public class StaffData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDatabaseDao s = new StudentDatabaseDao();
		List<Staff> l = s.allStaffData();
		HttpSession h = req.getSession();
		h.setAttribute("list", l);
		resp.sendRedirect("staffalldata.jsp");
	}
}
