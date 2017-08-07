package querydsl;

import java.util.HashSet;
import java.util.Set;

import org.dom4j.tree.AbstractEntity;

import com.mysema.query.annotations.QueryEntity;
import com.mysema.query.types.expr.BooleanExpression;

@QueryEntity
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String firstname, lastname;
	private EmailAddress emailAddress;
	private Set<Address> addresses = new HashSet<Address>();
	private long id;
	
	QCustomer customer = QCustomer.customer1;
	BooleanExpression idIsNull = customer.id.isNull();
	BooleanExpression lastNameContainsFragment = customer.lastname.contains("thew");
	BooleanExpression firstNameLikeCart = customer.firstname.like("Cart");
	EmailAddress reference = new EmailAddress("joseph.inex@gmail.com");
	BooleanExpression isJosephinesEmail = customer.emailAddress.eq(reference);
}
