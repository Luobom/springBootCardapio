package com.w3l.cardapio.controler;

import com.w3l.cardapio.food.Food;
import com.w3l.cardapio.food.FoodRequestDTO;
import com.w3l.cardapio.food.FoodResponseDTO;
import com.w3l.cardapio.repository.FoodRepository;
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
