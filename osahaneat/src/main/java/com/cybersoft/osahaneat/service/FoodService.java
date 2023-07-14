package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.entity.Category;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.imp.FoodServiceImp;
import com.cybersoft.osahaneat.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements FoodServiceImp {
    @Autowired
    FileServiceImp fileServiceImp;

    @Autowired
    FoodRepository foodRepository;

    @Override
    public boolean createFood(MultipartFile file, String title, String time_ship, boolean is_free_ship, double prirce,String des, int cate_id) {
        boolean isFoodSuccec = false;
        try {

            boolean isSuccess = fileServiceImp.saveFile(file);
            if (isSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(time_ship);
                food.setFreeShip(is_free_ship);
                food.setPrice(prirce);
                food.setDescription(des);


                Category category = new Category();
                category.setId(cate_id);

                food.setCategory(category);
                foodRepository.save(food);
                isFoodSuccec = true;
            }
        } catch (Exception e) {
            System.out.println("Can not create food !!!");
        }
        return isFoodSuccec;
    }

    @Override
    public boolean deleteFood(int id){
        if(id > 0){
            Food food = foodRepository.getById(id);
             if(food != null){
                 foodRepository.delete(food);
                 return true;
             }
        }
        return false;
    }

    @Override
    public List<FoodDTO> getAllFood() {
         List<FoodDTO> listFoodDTO = new ArrayList<>();
         List<Food> foodList = foodRepository.findAll();
        for (Food data : foodList) {

            Category category = new Category();
            category.setId(data.getCategory().getId());

            FoodDTO foodDTO = new FoodDTO();
            foodDTO.setId(data.getId());
            foodDTO.setTitle(data.getTitle());
            foodDTO.setImage(data.getImage());
            foodDTO.setTimeShip(data.getTimeShip());
            foodDTO.setPrice(data.getPrice());
            foodDTO.setFreeShip(data.isFreeShip());
            foodDTO.setDescription(data.getDescription());



            foodDTO.setCateID(category.getId());

            listFoodDTO.add(foodDTO);

        }
        return listFoodDTO;
    }

    @Override
    public boolean updateFood(MultipartFile file , int  id , FoodDTO foodDTO){
        if(foodDTO != null){
            Food food = foodRepository.getById(id);
            if(food != null){

                food.setTitle(foodDTO.getTitle());



                food.setTitle(foodDTO.getTitle());
                food.setTitle(foodDTO.getTitle());
                food.setTitle(foodDTO.getTitle());
            }
        }

        return false;



    }
}
