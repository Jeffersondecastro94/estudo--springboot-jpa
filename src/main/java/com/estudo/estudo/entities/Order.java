package com.estudo.estudo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.estudo.estudo.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd'T'HH:mm:ss'Z'",timezone="GMT")
	private Instant moment;
	
//	private OrderStatus orderStatus;
	private Integer orderStatus;
	
	@ManyToOne 							//varios pededios para 1 cliente. colocamos o cliente no construtor ja que nao é uma lista
	@JoinColumn(name="client_id") 		//nome da chave estrangeria do banco que ta dentro dessa tabela
	private User client;
								// PRODUTO SAO OS PRODUGTOS EM SI , ORDER É UM PEDIDO REALIZADO QUE PODER TER VARIOS ITENS NESSE PEDIDO.
	@OneToMany(mappedBy = "id.order")	// TO COLOCANDO PRA O PEDIDO(ORDER) TER RELACAO COM ITENS DO PEDIDO( ORDER ITEMS)
	private Set<OrderItem>items= new HashSet<>();
										
	public Set<OrderItem> getItems() {  //get para esse items
		return items;
	}
	
	
	public Order() {
	
	}

	public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
//		this.orderStatus=orderStatus;
	}
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus) ; // tranforma em orderStatus
		//return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus!=null) {
			this.orderStatus = orderStatus.getCode();
		}
		
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	

	
}
