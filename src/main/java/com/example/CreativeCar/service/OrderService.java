package com.example.CreativeCar.service;

import com.example.CreativeCar.dto.Order.CreateOrderDTO;
import com.example.CreativeCar.dto.Order.GetOrderInformationDTO;
import com.example.CreativeCar.entity.Car;
import com.example.CreativeCar.entity.Order;
import com.example.CreativeCar.entity.Users;
import com.example.CreativeCar.enums.CarOrder;
import com.example.CreativeCar.enums.ExceptionMessage;
import com.example.CreativeCar.exception.NotFoundException;
import com.example.CreativeCar.mapper.car.CarUpdateMapper;
import com.example.CreativeCar.mapper.order.OrderCreateMapper;
import com.example.CreativeCar.mapper.order.OrderGetMapper;
import com.example.CreativeCar.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<GetOrderInformationDTO> findByUserId(Long id) {
        List<Order> orders = orderRepository.findAllByUserIdAndStatus(id,"A");
        List<GetOrderInformationDTO> getOrderInformationDTOS = orders.stream()
                .map(OrderGetMapper::entityToDto)
                .toList();
        return getOrderInformationDTOS;
    }

    public void create(Long userId, Long carId, CreateOrderDTO createOrderDTO) {
        Optional<Users> user = Optional.ofNullable(userService.getUserById(userId));
        Optional<Car> car = Optional.ofNullable(carService.getCarById(carId));
        Order order = OrderCreateMapper.dtoToEntity(createOrderDTO,car,user);
        Long day = ChronoUnit.DAYS.between(createOrderDTO.getStartTime(),createOrderDTO.getEndTime()) + 1;
        Double calculatedPrice = car.get().getPrice() * day;
        if(calculatedPrice.compareTo(user.get().getBalance())<=0){
        order.setOrderAmount(calculatedPrice);
        carService.updateCarOrder(carId,CarOrder.ORDERED);
        orderRepository.save(order);}
        else throw new NotFoundException(
                String.format(ExceptionMessage.UNAUTHORIZED.getMessage())
        );

    }
}
