package querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface CustomerQueryDsl extends QueryDslPredicateExecutor<Customer>,  JpaRepository<Customer, Long> {
}

