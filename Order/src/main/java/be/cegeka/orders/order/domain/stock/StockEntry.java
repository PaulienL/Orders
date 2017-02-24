package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class StockEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private int id;

    @OneToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    public StockEntry(Item item) {
        this.item = item;
    }

    public StockEntry(){}

    public int getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }
}
