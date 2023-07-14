package com.cybersoft.osahaneat.imp;


import com.cybersoft.osahaneat.dto.RestaurantDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {
    public boolean insertRestaurant ( MultipartFile file,
                               String title,
                               String sub_title,
                               String description,
                               Boolean is_freeship,
                               String address,
                               String open_date);
    public List<RestaurantDTO> listRestaurant ();
    RestaurantDTO restaurantDto (int id);
}
