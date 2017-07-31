package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
