package querydsl;

import javax.persistence.Entity;

@Entity
public class EmailAddress {
	private String firstName;
	private String lastName;
	private String emailAddress;

	public EmailAddress(String string) {
		this.emailAddress = string;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
