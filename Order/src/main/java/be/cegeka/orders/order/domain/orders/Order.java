package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.shipment.Shipment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customerId;


    @OneToMany
    @JoinColumn(name = "ORDER_ID")
    private List<Shipment> shipments;

    public Order() {
    }

    public Order(LocalDate orderDate, Customer customerId ) {
        this.orderDate = orderDate;
        this.customerId = customerId;
    }
}
