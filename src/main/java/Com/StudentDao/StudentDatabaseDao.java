package Com.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import StudentDataBaseDto.Admin;
import StudentDataBaseDto.Staff;
import StudentDataBaseDto.Student;
import StudentDataBaseDto.Teacher;

public class StudentDatabaseDao implements Dao {

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/student_database?user=root&password=Root";
			Connection c = DriverManager.getConnection(url);
			return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveAdmin(Admin a) {
		
	}

	@Override
	public String saveStudent(Student s) {
		Connection con = getConnection();
		String sql = "insert into student values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement p =con.prepareStatement(sql);
			p.setInt(1, s.getId());
			p.setString(2,s.getName());
			p.setString(3,s.getSubject());
			p.setString(4,s.getSection());
			p.setString(5,s.getParent_contact());
			p.setString(6,s.getEmail());
			p.setString(7, s.getOverallPercentage());
			p.setString(8,s.getGender());
			int r =p.executeUpdate();
			return "No of Rows Are Updated  " +r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Updated";
	}

	@Override
	public String saveTeacher(Teacher t) {
		Connection con = getConnection();
		String sql = "insert into teacher values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement p =con.prepareStatement(sql);
			p.setInt(1, t.getId());
			p.setString(2,t.getName());
			p.setString(3,t.getSubject());
			p.setString(4,t.getClassTeacher());
			p.setString(5,t.getPhone());
			p.setString(6,t.getEmail());
			p.setString(7,t.getSalary());
			int r = p.executeUpdate();
			return "No of Rows Are Updated  " +r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Not Updated";
	}

		
		


	@Override
	public boolean adminLogin(String user,String pass) {
		boolean flag =false;
		Admin a1 = new Admin();
		Connection con = getConnection();
		String sql="select * from admin where username=? and password=?";
		try {
			PreparedStatement p=con.prepareStatement(sql);
			p.setString(1, user);
			p.setString(2, pass);
			ResultSet r = p.executeQuery();
			if(r.next())
			{
				flag=true;
			}
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String saveStaff(Staff s) {
		Connection con = getConnection();
		String sql = "insert into staff values(?,?,?,?,?,?)";
		
			try {
				PreparedStatement p =con.prepareStatement(sql);
				p.setInt(1, s.getId());
				p.setString(2, s.getName());
				p.setString(3, s.getPhoneNumber());
				p.setString(4, s.getEmail());
				p.setString(5, s.getDesignation());
				p.setString(6, s.getSalary());
				int r =p.executeUpdate();
				
				
				return "Rows are Updated "+r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return "Not Updated Rows";
	}

	@Override
	public List<Student> allSudentsData() {
		List<Student> l = new ArrayList<>();
		
		Connection con = getConnection();
		String sql ="select * from student";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet r =p.executeQuery();
			while(r.next())
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
			}
			return l;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Teacher> allTeachersData() {
		List<Teacher> l = new ArrayList<>();
		
		Connection con = getConnection();
		String sql ="select * from teacher";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet r =p.executeQuery();
			while(r.next())
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
			}
			con.close();
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Staff> allStaffData() {
		List<Staff> l = new ArrayList<>();
		Connection con = getConnection();
		String sql ="select * from staff";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			ResultSet r =p.executeQuery();
			while(r.next())
			{
				Staff s = new Staff();
				s.setId(r.getInt(1));
				s.setName(r.getString(2));
				s.setPhoneNumber(r.getString(3));
				s.setEmail(r.getString(4));
				s.setDesignation(r.getString(5));
				s.setSalary(r.getString(6));
				l.add(s);
			}
			con.close();
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ResultSet studentLogin(String user, String pass) {
		Connection con = getConnection();
	
		
		String sql ="select * from student where name=? and email=?";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user);
			p.setString(2, pass);
			ResultSet r = p.executeQuery();
			
					
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ResultSet teacherLogin(String user, String pass) {
		Connection con = getConnection();
		
		
		String sql ="select * from teacher where name=? and email=?";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user);
			p.setString(2, pass);
			ResultSet r = p.executeQuery();
			
					
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		

	}

	@Override
	public ResultSet staffLogin(String user, String pass) {
		Connection con = getConnection();

		
		String sql ="select * from staff where name=? and email=?";
		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user);
			p.setString(2, pass);
			ResultSet r = p.executeQuery();
			
					
			return r;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
	

}
