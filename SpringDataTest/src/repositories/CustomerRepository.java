package repositories;

import org.springframework.data.repository.Repository;

import entities.Customer;
import entities.EmailAddress;

public interface CustomerRepository extends Repository<Customer, Long>{
	
	Customer findOne(Long num);

	Customer save(Customer account);

	Customer findByEmailAddress(EmailAddress emailAddress);
}
