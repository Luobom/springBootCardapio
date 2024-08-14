package com.w3l.cardapio.controller;

import com.w3l.cardapio.entities.Food;
import com.w3l.cardapio.dto.FoodRequestDTO;
import com.w3l.cardapio.dto.FoodResponseDTO;
import com.w3l.cardapio.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*") // permitir conexões de todas origens e de todos headers que vier do cliente
    @PostMapping()
    public void saveFood(@RequestBody FoodRequestDTO data){

        Food foodData = new Food(data);
        foodRepository.save(foodData);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*") // permitir conexões de todas origens e de todos headers que vier do cliente
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }


}
