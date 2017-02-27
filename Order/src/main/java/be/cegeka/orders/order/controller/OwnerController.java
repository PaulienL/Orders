package be.cegeka.orders.order.controller;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import be.cegeka.orders.order.domain.stock.ItemQuantityCombo;
import be.cegeka.orders.order.domain.stock.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by paulienl on 23/02/2017.
 */
@Controller
@RequestMapping("/owner")
@Transactional
public class OwnerController {
    @Inject
    private ItemService itemService;
    @Inject
    private CustomerService customerService;
    @Inject
    private OrderService orderService;
    @Inject
    private StockService stockService;

    @RequestMapping(path = "/item",method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @RequestMapping(path = "/item",method = RequestMethod.GET)
    @ResponseBody
    public List<Item> getGamma(){
        return itemService.getItems();
    }

    @RequestMapping(path = "/stock",method = RequestMethod.POST)
    @ResponseBody
    public void addItemToStock(@RequestBody int item_id){
     stockService.addEntry(itemService.getItemById(item_id));
    }

    @RequestMapping(path = "/stock",method = RequestMethod.GET)
    @ResponseBody
    public List<ItemQuantityCombo> getStock(){
        return stockService.getStock();
    }

    @RequestMapping(path = "/customer",method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @RequestMapping(path = "/customer/{id}/orders",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getCustomers(@PathVariable int id){
        return orderService.getOrdersByCustomer(id);
    }
}
