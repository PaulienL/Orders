package be.cegeka.orders.order.controller;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    ItemService itemService;

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


}
