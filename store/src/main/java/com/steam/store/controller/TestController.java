package com.steam.store.controller;

import com.steam.store.dto.GamePurchaseRequest;
import com.steam.store.service.PaymentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class TestController {
    private final PaymentService paymentService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getTest() {
        return ResponseEntity.ok("Store Test");
    }

    @PostMapping("/payment")
    @ResponseBody
    public ResponseEntity<Object> payment(@RequestBody GamePurchaseRequest request) {
        return ResponseEntity.ok(
                paymentService.purchaseGames(request)
        );
    }
}
