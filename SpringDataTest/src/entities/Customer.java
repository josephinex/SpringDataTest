package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer extends AbstractEntity {
	
	private String firstname, lastname;
	
	@Column(unique = true)
	private EmailAddress emailAddress;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "customer_id")
	private Set<Address> addresses;

	public Object getId() {
		return null;
	}

}
