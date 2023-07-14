package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.CategoryDTO;
import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.dto.RestaurantDTO;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.entity.MenuRestaurant;
import com.cybersoft.osahaneat.entity.RatingRestaurant;
import com.cybersoft.osahaneat.entity.Restaurant;
import com.cybersoft.osahaneat.imp.FileServiceImp;
import com.cybersoft.osahaneat.imp.RestaurantServiceImp;
import com.cybersoft.osahaneat.mapper.RestaurantMapping;
import com.cybersoft.osahaneat.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String sub_title, String description, Boolean is_freeship, String address, String open_date) {
        boolean isSuccess = false;
        try {
            boolean isSuccessSaveResToFile = fileServiceImp.saveFile(file);

            if (isSuccessSaveResToFile) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubTile(sub_title);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeShip(is_freeship);
                restaurant.setAddress(address);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date openDate = simpleDateFormat.parse(open_date);
                restaurant.setOpenDate(openDate);

                restaurantRepository.save(restaurant);
                isSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Can not insert restaurant to file !!");
        }
        return isSuccess;
    }

    @Override
    public List<RestaurantDTO> listRestaurant() {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0, 6);

        Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageRequest);

        for (Restaurant data : restaurantPage) {
            RestaurantDTO res = new RestaurantDTO();
            res.setId(data.getId());
            res.setTitle(data.getTitle());
            res.setDescription(data.getDescription());
            res.setImage(data.getImage());
            res.setSubTile(data.getSubTile());
            res.setOpenDate(data.getOpenDate());
            res.setAddress(data.getAddress());
            res.setFreeShip(data.isFreeShip());
            res.setRating(calculatorRating(data.getRatingRestaurantList()));

            restaurantDTOList.add(res);
        }
        return restaurantDTOList;
    }

    public double calculatorRating(List<RatingRestaurant> listRating) {
        double totalRating = 0;
        for (RatingRestaurant data : listRating) {
            totalRating += data.getRatePoint();
        }
        return totalRating / listRating.size();
    }

    @Override
    public RestaurantDTO restaurantDto(int id) {
        RestaurantDTO resDTO = new RestaurantDTO();

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if (restaurant.isPresent()) {
            List<CategoryDTO> listCategoryDto = new ArrayList<>();

            Restaurant data = restaurant.get();
            resDTO.setId(data.getId());
            resDTO.setTitle(data.getTitle());
            resDTO.setImage(data.getImage());
            resDTO.setSubTile(data.getSubTile());
            resDTO.setRating(calculatorRating(data.getRatingRestaurantList()));
            resDTO.setDescription(data.getDescription());
            resDTO.setOpenDate(data.getOpenDate());
            resDTO.setAddress(data.getAddress());
            resDTO.setFreeShip(data.isFreeShip());

            for (MenuRestaurant menuRestaurant : data.getRestaurantList()) {

                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(menuRestaurant.getRestaurant().getId());
                categoryDTO.setName(menuRestaurant.getCategory().getNameCate());

                List<FoodDTO> foodDTOList = new ArrayList<>();

                // lấy danh sách food list thuộc category đó
                for ( Food food: menuRestaurant.getCategory().getFoodList()) {

                    FoodDTO foodDTO = new FoodDTO();
                    foodDTO.setId(food.getId());


                    foodDTO.setImage(food.getImage());
                    foodDTO.setFreeShip(food.isFreeShip());
                    foodDTO.setTitle(food.getTitle());
                    foodDTO.setDescription(food.getDescription());
                    foodDTO.setPrice(food.getPrice());
                    foodDTO.setTimeShip(food.getTimeShip());
                    foodDTO.setCateID(food.getCategory().getId());
                    // add foodDTO
                    foodDTOList.add(foodDTO);

                    System.out.println("123");
                }
                // add foodDTOList thuộc category đó
                categoryDTO.setFootList(foodDTOList);
                listCategoryDto.add(categoryDTO);


            }
            resDTO.setListCategoryDTO(listCategoryDto);
        }

        return resDTO;
    }
}
