package BanHang.Entity;

import java.io.Serializable;
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
@Table(name = "Categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private Integer categoryId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Description")
	private String description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Category", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Toy> Toys;

	public Category() {

	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Toy> getToys() {
		return Toys;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setVegetables(List<Toy> Toys) {
		this.Toys = Toys;
	}

	public Category(Integer categoryId, String name, String description) {
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}
}
