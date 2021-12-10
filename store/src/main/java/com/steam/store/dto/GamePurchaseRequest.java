package com.steam.store.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class GamePurchaseRequest {
    private List<GameVO> games;
}
