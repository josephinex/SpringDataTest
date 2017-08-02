package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	List<Contact> findByFirstNameStartingWithOrLastNameStartingWith(String firstName, String lastName);
}
