package com.cybersoft.osahaneat.repository;

import com.cybersoft.osahaneat.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

}
