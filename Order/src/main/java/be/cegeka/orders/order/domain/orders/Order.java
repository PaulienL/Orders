package be.cegeka.orders.order.domain.orders;


import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.packages.Package;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<Package> packages= new ArrayList<>();

    public Order() {
    }

    public Order(LocalDate orderDate, Customer customer) {
        this.orderDate = orderDate;
        this.customer = customer;
    }
    public Order(LocalDate orderDate, Customer customer, Package... packages) {
        this.orderDate = orderDate;
        this.customer = customer;
        this.packages.addAll(Arrays.asList(packages));
    }

    public int getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addPackage(Package aPackage) {
        packages.add(aPackage);
    }

    public List<Package> getPackages() {
        return packages;
    }

    public double getTotalPrice(){
        double output = 0;
        for (Package aPackage : packages) {
            output += aPackage.getItem().getPrice();
        }
        return output;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", customer=" + customer +
                ", packages=" + packages +
                '}';
    }
}
