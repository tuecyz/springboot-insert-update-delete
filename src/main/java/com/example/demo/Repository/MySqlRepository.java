package com.example.demo.Repository;
import com.example.demo.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Address,Integer> {
}