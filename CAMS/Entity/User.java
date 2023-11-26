package Entity;
import java.io.Serializable; 
/**
Represents the User of the CamsApp.
Students and Staff are all users of the application.
One must be a user in order to use the application.
@author Thor Jia Ying
@version 1.0
@since 2023-11-26
*/
public class User implements Serializable{
	/**
	 * id of the User.
	 * Required for Log in.
	 */
	private String id;
	/**
	 * Name of the User.
	 */
	private String name;
	/**
	 * Password of the user. By default it is "password".
	 * Must be changed during the first log in.
	 */
	private String password;
	/**
	 * Faculty of the user.
	 */
	private String faculty;

	/**
	 * Constructor for User.
	 * @param id the part before '@' of User's email.
	 * @param name	Name of user.
	 * @param password password set by the user.
	 * @param faculty faculty that the user belongs to.
	 */
	public User(String id, String name, String password, String faculty) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.faculty = faculty;
	}

	/**
	 * Returns the ID of the user.
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	*Set the id of the user
	*/
	public void setId(String ID) {
		this.id = ID;
	}
	/**
	 * Returns the name of user.
	 * @return
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of user.
	 * @param Name the name that user enters.
	 */
	public void setName(String Name) {
		this.name = Name;
	}

	/**
	 * Returns the password of user.
	 * @return
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Set the password of user.
	 * @param Password password keyed in.
	 */
	public void setPassword(String Password) {
		this.password = Password;
	}
	/**
	 * Return the faculty of user.
	 * @return
	 */
	public String getFaculty() {
		return this.faculty;
	}

	/**
	 * Set the faculty of user.
	 * @param Faculty Faculty of user.
	 */
	public void setFaculty(String Faculty) {
		this.faculty = Faculty;
	}

}