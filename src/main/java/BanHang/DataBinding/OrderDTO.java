package BanHang.DataBinding;

import java.util.List;
import java.util.ArrayList;

public class OrderDTO {
	private int customerId;

    private float total;

    private String note;

    private String address;

    private List<OrderDetailDTO> orderDetailDtos = new ArrayList<>();

    public int getCustomerId() {
        return customerId;
    }

    public float getTotal() {
        return total;
    }

    public String getNote() {
        return note;
    }

    public String getAddress() {
        return address;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderDetailDTO> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    public void setOrderDetailDtos(List<OrderDetailDTO> OrderDetailDtos) {
        this.orderDetailDtos = OrderDetailDtos;
    }

}
