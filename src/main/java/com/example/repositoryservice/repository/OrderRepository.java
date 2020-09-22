package com.example.repositoryservice.repository;

import com.example.repositoryservice.domain.WarehouseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<WarehouseOrder, Integer> {

    List<WarehouseOrder> findByUserId(int id);
}
