package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.CategoryDTO;
import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.entity.Category;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.imp.CategoryServiceImp;
import com.cybersoft.osahaneat.repository.CategoryRepository;
import com.cybersoft.osahaneat.request.CategoryRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RedisTemplate redisTemplate;

    private Gson gson = new Gson();


//    @Cacheable("categoryhome")
    @Override
    public List<CategoryDTO> listCategory() {
        String dataRedis = (String) redisTemplate.opsForValue().get("category");
        List<CategoryDTO> listCategoryDTO = new ArrayList<>();

        if (dataRedis == null){
            System.out.println("chua co data");
            PageRequest pageRequest = PageRequest.of(0, 3);
            Page<Category> listCategories = categoryRepository.findAll(pageRequest);

            for (Category data : listCategories) {

                CategoryDTO cateDTO = new CategoryDTO();
                cateDTO.setId(data.getId());
                cateDTO.setName(data.getNameCate());
                List<FoodDTO> listFoodDTO = new ArrayList<>();

                for (Food dataFood : data.getFoodList()) {

                    FoodDTO foodDTO = new FoodDTO();
                    foodDTO.setId(dataFood.getId());
                    foodDTO.setTitle(dataFood.getTitle());
                    foodDTO.setPrice(dataFood.getPrice());
                    foodDTO.setDescription(dataFood.getDescription());
                    foodDTO.setFreeShip(dataFood.isFreeShip());
                    foodDTO.setImage(dataFood.getImage());
                    listFoodDTO.add(foodDTO);
                }
                cateDTO.setFootList(listFoodDTO);

                listCategoryDTO.add(cateDTO);
            }
            String dataJson = gson.toJson(listCategoryDTO);
            redisTemplate.opsForValue().set("category",dataJson);
        }else{
            System.out.println("da co data");
            Type listType =  new TypeToken<List<CategoryDTO>>(){}.getType();
            listCategoryDTO = gson.fromJson(dataRedis,listType);
        }

        return listCategoryDTO;
    }

    @Override
    public boolean insertCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setNameCate(categoryRequest.getNameCate());
        category.setCreateDate(categoryRequest.getCreateDate());

        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean deteleCategory(int id) {
        if (id > 0) {
            Category category = categoryRepository.getById(id);
            if (category != null) {
                categoryRepository.delete(category);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateCategory(int id, CategoryRequest categoryRequest) {
        if (categoryRequest != null) {
            Category category = categoryRepository.getById(id);
            if (category != null) {
                category.setNameCate(categoryRequest.getNameCate());
                categoryRepository.save(category);
                return true;
            }
        }
        return false;
    }
}
