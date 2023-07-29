package com.application.ScienceTeacher.Repository;

import com.application.ScienceTeacher.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository <Orders, Long> {

}
