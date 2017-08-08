package entities;

import javax.persistence.Entity;

@Entity
public class Address extends AbstractEntity {
	private String street, city, country;
}
