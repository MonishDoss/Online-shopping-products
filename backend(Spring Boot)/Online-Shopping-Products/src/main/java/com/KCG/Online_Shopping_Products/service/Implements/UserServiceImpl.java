package com.KCG.Online_Shopping_Products.service.Implements;

import com.KCG.Online_Shopping_Products.dto.response.UserOrderSummary;
import com.KCG.Online_Shopping_Products.dto.response.OrderSummary;
import com.KCG.Online_Shopping_Products.entity.User;
import com.KCG.Online_Shopping_Products.repository.UserRepository;
import com.KCG.Online_Shopping_Products.service.Interface.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserOrderSummary> getUsersWithOrderSummaries() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> {
            UserOrderSummary summary = new UserOrderSummary();
            summary.setUserId(user.getId());
            summary.setUsername(user.getEmail());

            List<OrderSummary> orders = user.getOrders().stream().map(order -> {
                OrderSummary os = new OrderSummary();
                os.setOrderId(order.getId());
                os.setStatus(order.getStatus().name());
                os.setOrderDate(order.getDate());
                return os;
            }).collect(Collectors.toList());

            summary.setOrders(orders);
            return summary;
        }).collect(Collectors.toList());
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}