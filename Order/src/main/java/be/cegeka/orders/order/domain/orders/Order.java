package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;

/**
 * Created by paulienl on 23/02/2017.
 */
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private String id;

    @Column(name="ORDER_DATE")
    private String orderDate;

    public Order(String orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
    }
}
