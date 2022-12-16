package blog.panditmandar.sbswagger3;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "User", description = "All Details about the User Model")
public class User {

	@Schema(name = "id", description = "The Unique User ID Value", type = "integer", format = "int64", example = "5")
	private Long id;

	@Schema(name = "firstName", description = "The First Name of a User", type = "string", example = "Name")
	private String firstName;

	@Schema(name = "lastName", description = "The Last Name of a User", type = "string", example = "Surname")
	private String lastName;

	@Schema(name = "emailID", description = "The Email Address of a User", type = "string", example = "abc@example.com")
	private String emailID;

	public User() {

	}

	public User(String fName, String lName, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.emailID = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID=" + emailID + "]";
	}
}
