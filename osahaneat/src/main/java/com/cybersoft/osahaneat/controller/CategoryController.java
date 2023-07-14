package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.CategoryServiceImp;
import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import com.cybersoft.osahaneat.request.CategoryRequest;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImp categoryServiceImp;

    @Autowired
    FileServiceImp fileServiceImp;

   @PostMapping("/allcategory")
    public ResponseEntity <?> getAllCategory (){
      ResponeDataRes data = new ResponeDataRes();
      data.setData(categoryServiceImp.listCategory());
      return  new ResponseEntity<>(data , HttpStatus.OK);
   }

   @PostMapping("/addcate")
    public ResponseEntity <?> insertCate (@RequestBody CategoryRequest categoryRequest){
       ResponeDataRes data = new ResponeDataRes();
       if(categoryServiceImp.insertCategory(categoryRequest)){
           data.setData(true);
       }else{
           data.setData(false);
       }
       return new ResponseEntity<>(data, HttpStatus.OK);
   }




}
