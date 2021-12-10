package com.steam.store.service;

import com.steam.store.dto.GamePurchaseRequest;
import com.steam.store.dto.GameVO;
import com.steam.store.entity.User;
import com.steam.store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final UserRepository userRepository;
    private final KafkaProducer producer;

    public String purchaseGames(GamePurchaseRequest request) {
        User user = userRepository.findById(1)
                .orElseThrow();
        user.pay(request.getGames());
        addGames(request);

        return "test";
    }

    @Async
    public void addGames(GamePurchaseRequest request) {
        StringBuilder gameIds = new StringBuilder("[");
        for(GameVO game : request.getGames()) {
            gameIds.append(game.getId().toString()).append(',');
        }
        gameIds.setCharAt(gameIds.length() - 1, ']');
        producer.sendMessage(gameIds.toString());
    }
}
