package be.cegeka.orders.order.domain.itemsOnOrder;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by roelg on 24/02/2017.
 */
@Entity
@Table(name = "ITEMS_ON_ORDERS")
public class ItemOnOrder {
    @Id
    @Column(name = "IOO_ID")
    int ioo;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    Order order;

    @Column(name = "SHIPPING_DATE")
    LocalDate shipping_date;

    public ItemOnOrder() {
    }

    public ItemOnOrder(Item item, Order order, LocalDate shipping_date) {
        this.item = item;
        this.order = order;
        this.shipping_date = shipping_date;
    }
}
