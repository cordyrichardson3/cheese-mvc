package com.richardson.cheesemvc.data;

import com.richardson.cheesemvc.models.Cheese;

import java.util.ArrayList;
import java.util.List;

public class CheeseData {
    private static ArrayList<Cheese> cheeses = new ArrayList<>();

    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    public static void add(Cheese newCheese) {
        cheeses.add(newCheese);
    }

    public static Cheese getById(int id) {
        Cheese aCheese = null;
        for(Cheese cheese: cheeses) {
            if(cheese.getCheeseId() == id)
                aCheese = cheese;
        }
        return aCheese;
    }

    public static void remove(int id){
        Cheese cheeseToRemove = getById(id);
        cheeses.remove(cheeseToRemove);
    }



}
