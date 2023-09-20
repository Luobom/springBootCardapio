package com.w3l.cardapio.controler;

import com.w3l.cardapio.food.Food;
import com.w3l.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping
    public List<Food> getAll(){
        List<Food> foodList = foodRepository.findAll();
        return foodList;
    }


}
