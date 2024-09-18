package StudentDataBaseDto;

public class Student {
	private int id;
	private String name,subject,section,parent_contact,email,overallPercentage,gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getParent_contact() {
		return parent_contact;
	}
	public void setParent_contact(String parent_contact) {
		this.parent_contact = parent_contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOverallPercentage() {
		return overallPercentage;
	}
	public void setOverallPercentage(String overallPercentage) {
		this.overallPercentage = overallPercentage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + ", section=" + section
				+ ", parent_contact=" + parent_contact + ", email=" + email + ", overallPercentage=" + overallPercentage
				+ ", gender=" + gender + "]";
	}
	
	

}
