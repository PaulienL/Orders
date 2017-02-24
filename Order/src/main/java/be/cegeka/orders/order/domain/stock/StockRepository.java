package be.cegeka.orders.order.domain.stock;

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

    public void addEntry(StockEntry stock) {
        entityManager.persist(stock);
    }
}
