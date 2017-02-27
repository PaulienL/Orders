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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (number != address.number) return false;
        if (zipCode != address.zipCode) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        return city != null ? city.equals(address.city) : address.city == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + number;
        result = 31 * result + zipCode;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
