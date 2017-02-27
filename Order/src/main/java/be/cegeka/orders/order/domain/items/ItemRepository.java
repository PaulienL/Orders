package be.cegeka.orders.order.domain.items;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by roelg on 27/02/2017.
 */
@Named
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addItem(Item item) {
        entityManager.persist(item);
    }

    public List<Item> getItems() {
        return entityManager.createQuery("select o from Item o" , Item.class).getResultList();
    }
}
