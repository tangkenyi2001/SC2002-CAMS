public class User {

	private String id;
	private String name;
	private String password;
	private String faculty;

	public User(String id, String name, String password, String faculty) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.faculty = faculty;
	}

	public String getId() {
		return id;
	}

	public void setId(String ID) {
		this.id = ID;
	}

	public String getName() {
		return this.name;
	}


	public void setName(String Name) {
		this.name = Name;
	}

	public String getPassword() {
		return this.password;
	}


	public void setPassword(String Password) {
		this.password = Password;
	}

	public String getFaculty() {
		return this.faculty;
	}


	public void setFaculty(String Faculty) {
		this.faculty = Faculty;
	}

}