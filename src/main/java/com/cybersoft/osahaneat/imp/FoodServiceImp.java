package com.cybersoft.osahaneat.imp;

import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.entity.Food;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodServiceImp {
    boolean createFood (MultipartFile file, String title, String time_ship, boolean is_free_ship, double prirce,String des, int cate_id);
    boolean deleteFood (int id);

    List<FoodDTO> getAllFood ();



    boolean updateFood (String newFileUpdate, int id , FoodDTO food);
}
