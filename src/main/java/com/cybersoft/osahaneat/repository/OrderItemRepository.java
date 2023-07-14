package com.cybersoft.osahaneat.repository;

import com.cybersoft.osahaneat.entity.OrderItem;
import com.cybersoft.osahaneat.keys.KeyOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, KeyOrderItem> {
}
