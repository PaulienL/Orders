package be.cegeka.orders.order.domain.stock;

import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;

@Entity
public class StockEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private String id;

    @OneToOne
    private Item item;

    public StockEntry(Item item) {
        this.item = item;
    }

    public StockEntry(){}

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }
}
