package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.CategoryDTO;
import com.cybersoft.osahaneat.dto.FoodDTO;
import com.cybersoft.osahaneat.entity.Category;
import com.cybersoft.osahaneat.entity.Food;
import com.cybersoft.osahaneat.imp.CategoryServiceImp;
import com.cybersoft.osahaneat.repository.CategoryRepository;
import com.cybersoft.osahaneat.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> listCategory() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Category> listCategories = categoryRepository.findAll(pageRequest);

        List<CategoryDTO> listCategoryDTO = new ArrayList<>();


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
            }catch (Exception e){
                return false;
            }

    }


}
