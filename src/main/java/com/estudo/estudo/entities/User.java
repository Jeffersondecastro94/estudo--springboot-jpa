package com.estudo.estudo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_user") //CRIA COM ESSE NOME NA TABELA. OU PASSAMOS ELA DE LA PRA CA ASSIM CASO JA EXISTA O BANCO
public class User implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String passoword;
													//QUANDO DERMOS O SELECT UM OU OUTRO DA ASSOCIACAO VAI TRAZER O VALOR DA OUTRA CLASSE ASSOCIADA, 	
													//É MELHOR COLOCAR ISSO, ONDE TEM O MUITOS, NAO A FK(NO CASO QUEM VAI TER A FK NA OUTRA TABELA)
	@JsonIgnore										//SERVE PARA AO DAR O GET , NAO TER UM LOOP INFINITO, POIS USER TEM ORDER, ORDER TEM USER , ENTAO UM FICARIA CHAMANDO O OUTRO. 
													//PODEMOS USAR O JSONIGNORE DE UM LADO OU DO OUTRO. 
													//spring.jpa.open-in-view=true MAS SO FUNCIONA SE DEIXARMOS ISSO NO application.properties
	
	@OneToMany(mappedBy="client") 					//mapeado na outra classe por "cliente", no order no caso													
	private List<Order> orders= new ArrayList<>(); // um cliente vai ter varios pedidos. logo criamos uma lista aq do order ,nao criamos set, nao colocamos ele no construtor daqui
	
	public User () {
		
	}

	public User(Long id, String name, String email, String phone, String passoword) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.passoword = passoword;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassoword() {
		return passoword;
	}

	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}
	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	



	
	
	
	
	
	
}
