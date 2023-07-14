package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.imp.FoodServiceImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin("*")
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodServiceImp foodServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

    @PostMapping("/savefoodtofile")
    public ResponseEntity<?> saveFoodToFile(@RequestParam MultipartFile file,
                                            @RequestParam String title,
                                            @RequestParam String time_ship,
                                            @RequestParam boolean is_free_ship,
                                            @RequestParam double price,
                                            @RequestParam String des,
                                            @RequestParam int cate_id) {
        ResponeDataRes data = new ResponeDataRes();
        boolean isSuccess = foodServiceImp.createFood(file, title, time_ship, is_free_ship, price, des, cate_id);
        data.setData(isSuccess);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> uploadFile(@PathVariable String filename) {
        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @PostMapping("/deletefood/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable int id) {
        ResponeDataRes data = new ResponeDataRes();

        data.setData(foodServiceImp.deleteFood(id) ? true : false);

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping ("/allfood")
    public ResponseEntity <?> getAllFood (){
        ResponeDataRes data = new ResponeDataRes();
        data.setData(foodServiceImp.getAllFood());
        return new ResponseEntity<>(data , HttpStatus.OK);
    }
}
