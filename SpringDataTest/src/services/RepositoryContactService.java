package services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.ContactDTO;
import entities.Contact;
import exception.NotFoundException;
import repositories.ContactRepository;

@Service
public class RepositoryContactService implements ContactService {

	@Resource
	private ContactRepository repository;

	@Transactional
	@Override
	public Contact add(ContactDTO added) {
		Contact contact = Contact.getBuilder(added.getFirstName(), added.getLastName())
				.address(added.getStreetAddress(), added.getPostCode(), added.getPostOffice(), added.getState(),
						added.getCountry())
				.emailAddress(added.getEmailAddress()).phoneNumber(added.getPhoneNumber()).build();

		return repository.save(contact);

	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Contact deleteById(Long id) throws NotFoundException {
		Contact deleted = findById(id);
		repository.delete(deleted);

		return deleted;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Contact> findAll() {
		return repository.findAll();

	}

	@Transactional(readOnly = true)
	@Override
	public Contact findById(Long id) throws NotFoundException {
		Contact found = repository.findOne(id);
		if (found == null) {
			throw new NotFoundException("No contact found with id: " + id);
		}
		return found;
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public Contact update(ContactDTO updated) throws NotFoundException {

		Contact found = findById(updated.getId());

		found.update(updated.getFirstName(), updated.getLastName(), updated.getEmailAddress(),
				updated.getPhoneNumber());

		found.updateAddress(updated.getStreetAddress(), updated.getPostCode(), updated.getPostOffice(),
				updated.getState(), updated.getCountry());

		return found;

	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Contact> search(String searchTerm) {
	return repository.findByFirstNameStartingWithOrLastNameStartingWith(searchTerm, searchTerm);
	}



}
