package be.cegeka.orders.order.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by roelg on 27/02/2017.
 */
@Named
public class ItemService {
    @Inject
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        if (doesItemExist(item)) {
            throw new IllegalArgumentException("Item already exist");
        } else {
            itemRepository.addItem(item);
        }
    }

    private boolean doesItemExist(Item item) {
        return itemRepository.getItems().contains(item);
    }

    public List<Item> getItems() {
        return itemRepository.getItems();
    }

    public Item getItemById(int item_id) {
        for (Item item : getItems()) {
            if (item.getId() == item_id){
                return item;
            }
        }
        throw new IllegalArgumentException("Item does not exist");
    }
}
