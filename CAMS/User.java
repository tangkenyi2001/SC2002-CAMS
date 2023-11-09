public class User {

	private String id;
	private String name;
	private String password;
	private String faculty;

	public User() {
		// TODO - implement User.User
		throw new UnsupportedOperationException();
	}

	public String getid() {
		return this.id;
	}

	/**
	 * 
	 * @param ID
	 */
	public void setid(String ID) {
		this.id = ID;
	}

	public String getname() {
		return this.name;
	}

	/**
	 * 
	 * @param Name
	 */
	public void setname(String Name) {
		this.name = Name;
	}

	public String getpassword() {
		return this.password;
	}

	/**
	 * 
	 * @param Password                         
	 */
	public void setpassword(String Password) {
		this.password = Password;
	}

	public String getfaculty() {
		return this.faculty;
	}

	/**
	 * 
	 * @param Faculty
	 */
	public void setfaculty(String Faculty) {
		this.faculty = Faculty;
	}

}