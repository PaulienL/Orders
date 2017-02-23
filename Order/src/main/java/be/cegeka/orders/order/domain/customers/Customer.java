package be.cegeka.orders.order.domain.customers;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "LAST_NAME")
    private String lastName;

    private Customer() {
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

}
