package querydsl;

import java.util.HashSet;
import java.util.Set;

import org.dom4j.tree.AbstractEntity;

import com.mysema.query.annotations.QueryEntity;

@QueryEntity
public class Customer extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String firstname, lastname;
	private EmailAddress emailAddress;
	private Set<Address> addresses = new HashSet<Address>();
}
