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
        return null;
    }
    //entityManager.createQuery("select s from stock s", StockEntry.class).getResultList()
}