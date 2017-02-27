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
    @Column(name = "EMAIL")
    private String emailAddress;
    @ManyToOne
    @JoinColumn(name="ADDRESS_ID")
    private Address address_Id;
    @Column (name="PHONE")
    private String phoneNumber;

    private Customer() {
    }

    public Customer(String name, String lastName, String emailAddress, Address address, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address_Id = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
