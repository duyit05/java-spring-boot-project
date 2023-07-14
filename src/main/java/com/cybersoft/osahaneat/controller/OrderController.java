package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.OrderRepositoryImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import com.cybersoft.osahaneat.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepositoryImp orderRepositoryImp;

    @PostMapping
    public ResponseEntity <?> order (@RequestBody OrderRequest orderRequest){
        ResponeDataRes data = new ResponeDataRes();
        if(orderRepositoryImp.insertOrder(orderRequest)){
            data.setData(true);
        }else{
            data.setData(false);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @CacheEvict(value = "orderhome",allEntries = true)
    @GetMapping("/cleancach")
    public String cleanCach (){

        return "Clean successfully";
    }
}
