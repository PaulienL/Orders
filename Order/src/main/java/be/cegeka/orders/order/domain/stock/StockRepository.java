package be.cegeka.orders.order.domain.stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by xanv on 23/02/2017.
 */
@Named
public class StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<StockEntry> getStock() {
        return entityManager.createQuery("select s from StockEntry s", StockEntry.class).getResultList();
    }

    public List<Object[]> getQuantityOnStock(){
        return entityManager.createQuery("SELECT s.item, COUNT(*) FROM StockEntry s GROUP BY s.item", Object[].class).getResultList();
    }

    public void addEntry(StockEntry stock) {
        entityManager.persist(stock);
    }
}
