package repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import entities.Customer;
import entities.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
	List<Order> findByCustomer(Customer customer);
}
