package com.steam.library.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/library")
public class TestController {
    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Object> addGames() {
        return ResponseEntity.ok(
                "libraryService.purchaseGames(request)"
        );
    }
}
