package entities;

import javax.persistence.Entity;

@Entity
public class Address extends AbstractEntity {
	private String street, city, country;
	
	public Address() {}
	
	public Address (Address addr) {
		this.street = addr.street;
		this.city = addr.city;
		this.country = addr.country;
	}

}
