package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.CategoryServiceImp;
import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import com.cybersoft.osahaneat.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

   @PostMapping("/deletecategory/{id}")
    public ResponseEntity<?> deleteCategory (@PathVariable int id){
       ResponeDataRes data = new ResponeDataRes();
       data.setData(categoryServiceImp.deteleCategory(id) ? true : false);
       return new ResponseEntity<>(data , HttpStatus.OK);
   }

   @PutMapping("/updatecategory")
    public ResponseEntity <?> updateCategory (@RequestParam int id , @RequestBody CategoryRequest categoryRequest){
       ResponeDataRes data = new ResponeDataRes();
       data.setData(categoryServiceImp.updateCategory(id,categoryRequest) ? true : false);
       return new ResponseEntity<>(data,HttpStatus.OK);
   }

   // xoa cach
   @CacheEvict(value = "categoryhome",allEntries = true)
   @GetMapping("/cleancach")
    public String cleanCach (){

       return "Clean successfully";
   }



}
