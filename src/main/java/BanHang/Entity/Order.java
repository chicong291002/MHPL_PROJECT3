package BanHang.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;

import java.util.ArrayList;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderId;

    @Column(name = "Date")
    private Date date;

    @Column(name = "Total")
    private float total;

    @Column(name = "Note")
    private String note;

    @Column(name = "Address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer Customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public void addToOrderDetail(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.orderDetails.add(orderDetail);
    }

    public Order() {

    }

    public Order(int orderId, Date date, float total, String note, String address) {
        this.orderId = orderId;
        this.date = date;
        this.total = total;
        this.note = note;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
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

    public Customer getCustomer() {
        return Customer;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> OrderDetails) {
        this.orderDetails = OrderDetails;
    }

}
