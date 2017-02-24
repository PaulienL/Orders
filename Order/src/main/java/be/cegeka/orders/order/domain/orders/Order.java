package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by paulienl on 23/02/2017.
 */
@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int id;

    @Column(name="ORDER_DATE")
    private LocalDate orderDate;

//    @Column(name="CUSTOMER_ID")
//    private int customerId;


    public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Order() {
    }
}
