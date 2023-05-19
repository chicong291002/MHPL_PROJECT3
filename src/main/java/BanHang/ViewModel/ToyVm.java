package BanHang.ViewModel;

public class ToyVm {
	private int toyId;

	public int getToyId() {
		return toyId;
	}

	public void setToyId(int toyId) {
		this.toyId = toyId;
	}

	private String categoryName;

	private String name;

	private String unit;

	private int amount;

	private String image;

	private float price;

	private int sold;

	public ToyVm() {

	}

	public String getCategoryName() {
		return categoryName;
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

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

	public ToyVm(int toyId, String categoryName, String name, String unit, int amount, String image, float price,
			int sold) {
		this.toyId = toyId;
		this.categoryName = categoryName;
		this.name = name;
		this.unit = unit;
		this.amount = amount;
		this.image = image;
		this.price = price;
		this.sold = sold;
	}
}
