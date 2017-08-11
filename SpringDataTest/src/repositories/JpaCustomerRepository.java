package repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Customer;
import entities.EmailAddress;

@Repository
@Transactional(readOnly = true)
public class JpaCustomerRepository implements CustomerRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Customer save(Customer customer) {
		if (customer.getId() == null) {
			em.persist(customer);
			return customer;
		} else {
			return em.merge(customer);
		}
	}

	@Override
	public Customer findByEmailAddress(EmailAddress emailAddress) {
		TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.emailAddress = :emailAddress",
				Customer.class);
		query.setParameter("emailAddress", emailAddress);
		return query.getSingleResult();
	}

	@Override
	public Customer findOne(Long num) {
		// TODO Auto-generated method stub
		return null;
	}
}
