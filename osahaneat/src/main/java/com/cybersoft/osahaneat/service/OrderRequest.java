package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.entity.*;
import com.cybersoft.osahaneat.imp.OrderRepositoryImp;
import com.cybersoft.osahaneat.keys.KeyOrderItem;
import com.cybersoft.osahaneat.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderRequest implements OrderRepositoryImp {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean insertOrder(com.cybersoft.osahaneat.request.OrderRequest orderRequest) {

        try {
            // lấy các bảng liên quan để tạo order
            Users user = new Users();
            user.setId(orderRequest.getUserId());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getResId());

            Order order = new Order();
            order.setUsers(user);
            order.setRestaurant(restaurant);
            order.setOrderDate(orderRequest.getDateOrder());

            orderRepository.save(order);

            // khi có các thuộc tính được thêm vào Order thì mới thêm vào Order_Item
            List<OrderItem> items = new ArrayList<>();
            for (int foods: orderRequest.getFoodId()){
                Food food = new Food();
                food.setId(foods);

                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(order.getId(),foods);
                orderItem.setKeyOrderItem(keyOrderItem);

                items.add(orderItem);

            }
            return true;

        }catch (Exception e){
            System.out.println("Cannot insert Order !!!");
        }
        return false;
    }
}
