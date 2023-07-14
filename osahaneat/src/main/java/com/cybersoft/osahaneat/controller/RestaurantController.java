package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.imp.RestaurantServiceImp;
import com.cybersoft.osahaneat.payload.ResponeDataRes;
import com.cybersoft.osahaneat.payload.ResponseDateFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping("")
    public ResponseEntity<?> saveFile(@RequestParam MultipartFile file) {
        ResponseDateFile responseDateFile = new ResponseDateFile();
        boolean isSuccess = fileServiceImp.saveFile(file);
        responseDateFile.setData(isSuccess);

        return new ResponseEntity<>(responseDateFile, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> uploadFile(@PathVariable String filename) {
        Resource resource = fileServiceImp.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @DeleteMapping("/file/{filename:.+}")
    public ResponseEntity<?> deleteFile(@PathVariable String filename) {
        ResponseDateFile responseDateFile = new ResponseDateFile();
        boolean isSuccess = fileServiceImp.deleteFile(filename);
        responseDateFile.setData(isSuccess);

        return new ResponseEntity<>(responseDateFile, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAllFile() {
        ResponseDateFile responseDateFile = new ResponseDateFile();
        boolean isSuccess = fileServiceImp.deleteAllFile();
        if (isSuccess) {
            responseDateFile.setDes("Oke");
            responseDateFile.setData(true);
        } else {
            responseDateFile.setDes("Not Oke");
            responseDateFile.setData(false);
        }
        return new ResponseEntity<>(responseDateFile, HttpStatus.OK);
    }

    @PostMapping("/saverestofile")
    public ResponseEntity<?> saveResToFile(@RequestParam MultipartFile file,
                                           @RequestParam String title,
                                           @RequestParam String sub_title,
                                           @RequestParam String description,
                                           @RequestParam boolean is_freeship,
                                           @RequestParam String address,
                                           @RequestParam String open_date) {
        ResponseDateFile responseDateFile = new ResponseDateFile();
        boolean isSucces = restaurantServiceImp.insertRestaurant(file, title, sub_title, description, is_freeship, address, open_date);
        responseDateFile.setData(isSucces);

        return new ResponseEntity<>(responseDateFile, HttpStatus.OK);
    }


    @PostMapping("/allrestaurant")
    public ResponseEntity<?> getAllRestaurant() {
        ResponeDataRes responeDataRes = new ResponeDataRes();

        responeDataRes.setData(restaurantServiceImp.listRestaurant());

        return new ResponseEntity<>(responeDataRes, HttpStatus.OK);
    }

    @GetMapping("/detailres")
    public ResponseEntity <?> getDetailRestaurant (@RequestParam int id){
        ResponeDataRes data = new ResponeDataRes();
        data.setData(restaurantServiceImp.restaurantDto(id));
        return new ResponseEntity<>(data , HttpStatus.OK );
    }
}

