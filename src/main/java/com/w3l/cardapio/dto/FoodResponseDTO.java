package com.w3l.cardapio.dto;

import com.w3l.cardapio.entities.Food;

public record FoodResponseDTO(Long id, String title, String image, double price) {
    public FoodResponseDTO(Food entity){
        this(entity.getId(), entity.getTitle(), entity.getImage(), entity.getPrice());
    }
}
