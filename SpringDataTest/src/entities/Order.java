package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "Orders")
public class Order extends AbstractEntity {
	@ManyToOne(optional = false)
	private Customer customer;
	@ManyToOne
	private Address billingAddress;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Address shippingAddress;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private Set<LineItem> lineItem;
	
	
	@SuppressWarnings("deprecation")
	public Order(Customer customer, Address shippingAddress, Address billingAddress) {
		Assert.notNull(customer);
			Assert.notNull(shippingAddress);
			this.customer = customer;
			this.shippingAddress = shippingAddress.getCopy();
			this.billingAddress = billingAddress == null ? null :
			billingAddress.getCopy();
			}
}

}
