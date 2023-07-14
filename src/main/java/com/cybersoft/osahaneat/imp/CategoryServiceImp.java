package com.cybersoft.osahaneat.imp;

import com.cybersoft.osahaneat.dto.CategoryDTO;
import com.cybersoft.osahaneat.request.CategoryRequest;

import java.util.List;

public interface CategoryServiceImp {
    List<CategoryDTO> listCategory ();
    boolean insertCategory (CategoryRequest categoryRequest);

     boolean deteleCategory (int id);

     boolean updateCategory (int id , CategoryRequest categoryRequest );
}
