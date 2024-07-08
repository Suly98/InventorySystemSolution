package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Inventory;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Services.SlackService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ReportingController {


    @Autowired
    SlackService slackService;

    @GetMapping("inventoryCheck")
    public void lowOnInventory(@NotNull List<Product> productList) {
        String channel = "Teams";
        if(productList.size() <= 5) {
            String message = "Stock is very low!";
            slackService.sendMessage(channel,message);
        } else {
            String message = "Inventory is OK!";
            slackService.sendMessage(channel,message);
        }
    }

    @GetMapping("isThere")
    public Boolean isThere(@NotNull Inventory products){
        for(Product p : products.getProductsInInventory() ){
            if(p.getQuantity().equals(0)){
                return false;
            }
        }
        return true;
    }

    //to report all the stock every month!
    //@Scheduled(cron = "0 0 0 L * *")
    @GetMapping("report")
    public String reportAll(){
        return "Inventory";
    }


}
