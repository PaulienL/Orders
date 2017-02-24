package be.cegeka.orders.order.domain.packages;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by roelg on 24/02/2017.
 */
@Entity
@Table(name = "PACKAGES")
public class Package {
    @Id
    @Column(name = "PACKAGE_ID")
    int id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    Item item;

    @Column(name = "SHIPPING_DATE")
    LocalDate shipping_date;

    public Package() {
    }

    public Package(Item item, LocalDate shipping_date) {
        this.item = item;
        this.shipping_date = shipping_date;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", item=" + item +
                ", shipping_date=" + shipping_date +
                '}';
    }
}
