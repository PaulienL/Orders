package be.cegeka.orders.order.domain.shipment;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by roelg on 24/02/2017.
 */
@Entity
@Table(name = "SHIPMENTS")
public class Shipment {
    @Id
    @Column(name = "SHIPMENT_ID")
    int ioo;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    Item item;

    @Column(name = "SHIPPING_DATE")
    LocalDate shipping_date;

    public Shipment() {
    }

    public Shipment(Item item, LocalDate shipping_date) {
        this.item = item;
        this.shipping_date = shipping_date;
    }
}
