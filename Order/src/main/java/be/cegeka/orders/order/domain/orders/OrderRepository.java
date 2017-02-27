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


}
