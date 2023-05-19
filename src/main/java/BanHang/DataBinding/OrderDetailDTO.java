package BanHang.DataBinding;

public class OrderDetailDTO {
	 private int quantity;

	    private float price;

	    private float subTotal;

	    private int vegetableId;

	    public int getQuantity() {
	        return quantity;
	    }

	    public float getPrice() {
	        return price;
	    }

	    public float getSubTotal() {
	        return subTotal;
	    }

	    public int getVegetableId() {
	        return vegetableId;
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

	    public void setVegetableId(int vegetableId) {
	        this.vegetableId = vegetableId;
	    }
}
