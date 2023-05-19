package BanHang.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustomerID")
	private int customerId;

	@Column(name = "UserName")
	private String userName;

	@Column(name = "Password")
	private String password;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Address")
	private String address;

	@Column(name = "City")
	private String city;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Customer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Order> Orders;

	public Customer() {

	}

	public Customer(int customerId, String userName, String password, String fullName, String address, String city) {
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.city = city;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFullName() {
		return fullName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public List<Order> getOrders() {
		return Orders;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setOrders(List<Order> Orders) {
		this.Orders = Orders;
	}

}
