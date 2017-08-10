package entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Product extends AbstractEntity {
	@Column(nullable = false)
	private String name;
	private String description;
	@Column(nullable = false)
	private BigDecimal price;
	@ElementCollection
	private Map<String, String> attributes = new HashMap<String, String>();
}
