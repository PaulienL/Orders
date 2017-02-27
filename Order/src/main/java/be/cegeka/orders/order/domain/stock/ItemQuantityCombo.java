package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;

/**
 * Created by paulienl on 27/02/2017.
 */
public class ItemQuantityCombo {
    int quantity;
    Item item;

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
