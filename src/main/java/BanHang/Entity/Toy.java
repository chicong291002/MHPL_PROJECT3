package BanHang.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Toys")
public class Toy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ToyID")
	private int toyId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Unit")
	private String unit;

	@Column(name = "Amount")
	private int amount;

	@Column(name = "Image")
	private String image;

	@Column(name = "Price")
	private float price;

	@Column(name = "Sold")
	private int sold;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category Category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "toy", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<OrderDetail> orderDetails = new ArrayList<>();

	public Toy() {

	}

	public Toy(int toyId, String name, String unit, int amount, String image, float price, int sold) {
		this.toyId = toyId;
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.image = image;
		this.price = price;
		this.sold = sold;
	}

	public int getToyId() {
		return toyId;
	}

	public String getName() {
		return name;
	}

	public String getUnit() {
		return unit;
	}

	public int getAmount() {
		return amount;
	}

	public String getImage() {
		return image;
	}

	public float getPrice() {
		return price;
	}

	public int getSold() {
		return sold;
	}

	public Category getCategory() {
		return Category;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setToyId(int toyId) {
		this.toyId = toyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public void setCategory(Category Category) {
		this.Category = Category;
	}

	public void setOrderDetails(List<OrderDetail> OrderDetails) {
		this.orderDetails = OrderDetails;
	}

}