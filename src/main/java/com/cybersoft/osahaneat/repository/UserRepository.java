package com.cybersoft.osahaneat.repository;

import com.cybersoft.osahaneat.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// đánh dấu Repository đưa lên container (IOC) dùng chung
// đánh dấu đây là class chuyên để query sql
@Repository
public interface UserRepository extends JpaRepository<Users , Integer> {

   // định nghĩa câu query

    public List<Users> findByUsernameAndPassword(String username , String password);
    Users findByUsername (String username);

}
