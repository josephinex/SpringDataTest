package services;

import java.util.List;

import dto.ContactDTO;
import entities.Contact;
import exception.NotFoundException;

public interface ContactService {
	public Contact add(ContactDTO added);

	public Contact deleteById(Long id) throws NotFoundException;

	public List<Contact> findAll();

	public Contact findById(Long id) throws NotFoundException;

	public Contact update(ContactDTO updated) throws NotFoundException;
}
