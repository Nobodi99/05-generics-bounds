package ohm.softa.a05.utils;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.collections.SimpleListImpl;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;

import java.util.HashMap;
import java.util.Map;

public abstract class PlantUtility {
    private PlantUtility(){
        // empty constructor
    }

    public static <T extends Plant> Map<PlantColor, SimpleList<T>> splitBedByColor(PlantBed<T> plantBed){
        Map<PlantColor, SimpleList<T>> result = new HashMap<>();

        for (T plant : plantBed.getPlants()){
            if (!result.containsKey(plant.getColor())){
                // If color is not yet in list create a new entry for it
                // and attach an empty list to it for the corresponding plants
                result.put(plant.getColor(), new SimpleListImpl<>());
            }
            // Add plant to hash map
            result.get(plant.getColor()).add(plant);
        }
        return result;
    }

    // Shorter Version by using getPlantsByColor
    public static <T extends Plant> Map<PlantColor, SimpleList<? extends T>>
        splitBedByColor2(PlantBed<? extends T> plantBed){

        Map<PlantColor, SimpleList<? extends T>> result = new HashMap<>();

        // Iterate over all enum values
        for (PlantColor color : PlantColor.values()){
            // Use function of plantBed to get all plants of that color
            result.put(color, plantBed.getPlantsByColor(color));
        }

        return result;
    }

    public static <T extends Plant> void repot(PlantBed<T> input, PlantColor color, PlantBed<? super T> output){
        SimpleList<? extends T> extract = input.getPlantsByColor(color);

        for (T p : extract) {
            input.remove(p);
            output.add(p);
        }
    }
}
