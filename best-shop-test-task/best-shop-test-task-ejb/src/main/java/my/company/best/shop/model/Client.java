package my.company.best.shop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client {

	@Id
	private Long id;

	private String name;

	@OneToMany
	private List<SuperOrder> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SuperOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<SuperOrder> orders) {
		this.orders = orders;
	}
}
