package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.stock.StockEntry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paulienl on 23/02/2017.
 */
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    public List<StockEntry> getStock() {
        return entityManager.createQuery("select s from StockEntry s" , StockEntry.class).getResultList();
    }
}
