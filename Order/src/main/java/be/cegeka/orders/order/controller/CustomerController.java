package be.cegeka.orders.order.controller;

import be.cegeka.orders.order.domain.customers.Address;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import be.cegeka.orders.order.domain.packages.Package;
import be.cegeka.orders.order.domain.stock.ItemQuantityCombo;
import be.cegeka.orders.order.domain.stock.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by christom on 23/02/2017.
 */
@Controller
@RequestMapping("/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Inject
    private OrderService orderService;

    @Inject
    private StockService stockService;

    @Inject
    private ItemService itemService;


    @RequestMapping(path = "/order", method = POST)
    @ResponseBody
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @RequestMapping(method = POST)
    @ResponseBody
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ItemQuantityCombo> getStock() {
        return stockService.getStock();
    }

    @RequestMapping(path = "/reallyreallyfilthy", method = RequestMethod.GET)
    @ResponseBody
    public String filthyRoel() {
        Address address = new Address("poepenholleken", 69, 6969, "Hollekepoep");
        Customer customer = new Customer("filthy", "Roel", "filthyroel@beardy.com", address, "0469696969");
        customerService.addCustomer(customer);
        Order order = new Order(LocalDate.now(), customer);
        orderService.addOrder(order);
        Item item = new Item("stupid", "this is filthy", 69);
        orderService.addPackage(item, LocalDate.now(),order.getId());
        return "fuck you";
    }

//    @RequestMapping(path = "/createOrder", method = POST)
//    @ResponseBody
//    public void createOrder(@RequestBody List<Item> items, Customer customer) {
//        List<Package> packagesInOrder = stockService.itemsShippedTomorrow(items).addAll(stockService.itemsShippedNextWeek(items));
//        Order order = new Order(LocalDate.now(), customer);
//        orderService.addOrder(order);
//
//    }
}
