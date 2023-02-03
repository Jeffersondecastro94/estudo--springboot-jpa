package com.estudo.estudo.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.estudo.entities.Order;
import com.estudo.estudo.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//NAO TEMOS CONSTRUTORES AQUI
//quem recebe as chaves compostas 
@Embeddable 
public class OrdemItemPK implements Serializable{
	private static final long serialVersionUID=1L;

	//associa com a chave primaria de order
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	//associa com a chave primaria de product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	//GETERS E SETERS
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	//HASH CODE DOS DOIS
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemItemPK other = (OrdemItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
}
