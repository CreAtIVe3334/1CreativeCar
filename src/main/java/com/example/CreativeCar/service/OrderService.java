package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.Order.CreateOderDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Order;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.mapper.order.OrderCreateMapper;
import com.example.CreativeCar.repository.CarRepository;
import com.example.CreativeCar.repository.OrderRepository;
import com.example.CreativeCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByUserId(Long id) {
        return orderRepository.findAllByUserIdAndStatus(id,"A");
    }

    public Order create(Long userId, Long carId, CreateOderDTO createOderDTO) {
        Optional<Users> user = Optional.ofNullable(userService.getUserById(userId));
        Optional<Car> car = Optional.ofNullable(carService.getCarById(carId));
        Order order = OrderCreateMapper.dtoToEntity(createOderDTO,car,user);
        return orderRepository.save(order);
    }
}
