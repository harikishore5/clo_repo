package Com.StudentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import StudentDataBaseDto.Admin;
import StudentDataBaseDto.Staff;
import StudentDataBaseDto.Student;
import StudentDataBaseDto.Teacher;

public interface Dao {
	public Connection getConnection();
	public void saveAdmin(Admin a);
	public String saveStudent(Student s);
	public String saveTeacher(Teacher t);
	public String saveStaff(Staff s);
	public boolean adminLogin(String user,String pass);
	public List<Student> allSudentsData();
	public List<Teacher> allTeachersData();
	public List<Staff> allStaffData();
	public ResultSet studentLogin(String user,String pass);
	public ResultSet teacherLogin(String user,String pass);
	public ResultSet staffLogin(String user,String pass);

}
