package be.cegeka.orders.order.domain.orders;
import be.cegeka.orders.order.domain.items.Item;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paulienl on 23/02/2017.
 */
@Named
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    public List<Order> getOrders() {
        return entityManager.createQuery("select o from Order o", Order.class).getResultList();
    }

    public List<Order> getOrdersByCustomer(int id) {
        return entityManager.createQuery("select o from Order o where o.CUSTOMER_ID = " + id, Order.class).getResultList();
    }

    public List<Item> getQuantityOnStock(){
        return entityManager.createQuery("SELECT i.NAME, COUNT(s.ITEM_ID) FROM ITEMS i JOIN STOCK s ON s.ITEM_ID=i.ITEM_ID GROUP BY i.NAME", Item.class).getResultList();
    }
}
