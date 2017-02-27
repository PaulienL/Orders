package be.cegeka.orders.order.domain.customers;

import javax.persistence.*;

/**
 * Created by paulienl on 27/02/2017.
 */
@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private int id;
    @Column(name = "STREET")
    private String street;
    @Column (name="HOUSENUMBER")
    private int number;
    @Column(name="ZIPCODE")
    private int zipCode;
    @Column(name="CITY")
    private String city;

    public Address(String street, int number, int zipCode, String city) {
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
    }
}
