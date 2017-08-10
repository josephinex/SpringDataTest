package entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LineItem extends AbstractEntity {
	@ManyToOne
	private Product product;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	private int amount;
}
