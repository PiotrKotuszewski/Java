package main.shop.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(name = "delivery_type", nullable = false)
    private String deliveryType;
    @Column(name = "order_sum", nullable = false)
    private float orderSum;
    @Column(name = "post_date", nullable = false)
    private String postDate;
    @Column(nullable = false)
    private String address;
    @Column(name = "recipient_first_name", nullable = false)
    private String firstName;
    @Column(name = "recipient_last_name", nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    private ShoppingCart shoppingCart;

    public Order(){}

    public Order(String deliveryType, float orderSum, String postDate, String address, String firstName, String lastName) {
        this.deliveryType = deliveryType;
        this.orderSum = orderSum;
        this.postDate = postDate;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public float getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(float orderSum) {
        this.orderSum = orderSum;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deliveryType='" + deliveryType + '\'' +
                ", orderSum=" + orderSum +
                ", postDate='" + postDate + '\'' +
                ", address='" + address + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", user=" + user +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
