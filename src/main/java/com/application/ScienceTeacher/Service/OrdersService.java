package com.application.ScienceTeacher.Service;

import com.application.ScienceTeacher.Entity.Orders;
import com.application.ScienceTeacher.Repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public Orders addOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Orders findById(long id) {
        return ordersRepository.findById(id).get();
    }

    public void deleteById(long id) {
        ordersRepository.deleteById(id);
    }

    public void saveCLientOrder(Orders createOrders) {
        ordersRepository.save(createOrders);
    }
}
