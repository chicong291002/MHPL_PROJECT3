package BanHang.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Price")
	private float price;

	@Column(name = "SubTotal")
	private float subTotal;

	@ManyToOne
	@JoinColumn(name = "ToyID", updatable = false)
	private Toy toy;

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

	@ManyToOne
	@JoinColumn(name = "OrderID", updatable = false)
	private Order order;

	public OrderDetail() {

	}

	public OrderDetail(int id, int orderId, int toyId, int quantity, float price, float subTotal) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public float getPrice() {
		return price;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}