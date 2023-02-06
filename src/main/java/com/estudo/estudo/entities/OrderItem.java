package com.estudo.estudo.entities;

import java.io.Serializable;
import java.util.Objects;

import com.estudo.estudo.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name="tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID=1L;
	
	//identicador
	@EmbeddedId  				// forma de identificar como id  temos que instaciar 
	private OrderItemPK id =new OrderItemPK();
	
	//colocar referencia da coluna caso exista uma tabela no banco
	private Integer quantity;
	
	//colocar referencia da coluna caso exista uma tabela no banco
	private Double price;
	
	
	public OrderItem() {
	}

	//CONSTRUTOR PARA CASO QUEIRA PASSAR AS INFORMACOES POR ELE
	//CRIAMOS O PRODUTO E A ORDEM MANUALMENTE, NAO COLOCAMOS O ID 
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	//GET E SETS 
	//ESTAO DENTRO DO ID, LOGO CRIAMOS COMO ABAIXO
	@JsonIgnore		//usar para evitar o loop 
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
		
	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
	
	
	
	//GET E SETS  "PADRAO"
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	
}
