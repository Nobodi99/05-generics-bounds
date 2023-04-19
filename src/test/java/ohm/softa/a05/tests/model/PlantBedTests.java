package ohm.softa.a05.tests.model;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantBedTests {
    private PlantBed<Flower> flowerBed;
    private PlantBed<Shrub> shrubBed;

    @BeforeEach
    void setup(){
        flowerBed = new PlantBed<>();
        shrubBed = new PlantBed<>();

        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.35, PlantColor.ORANGE));
        flowerBed.add(new Flower("Tulip", "Curly Sue", 0.35, PlantColor.BLUE));

        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.5));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.1));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.2));
        shrubBed.add(new Shrub("Buxus", "Buxus sempervirens", 1.4));
    }

    @Test
    void testCreateEmptyPlantBed(){
        PlantBed<Flower> plantBed = new PlantBed<>();
        assertEquals(0, plantBed.size());
    }

    @Test
    void testGetSize(){
        assertEquals(4, shrubBed.size());
        assertEquals(7, flowerBed.size());
    }

    @Test
    void testGetPlantsByColorYellow(){
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.YELLOW);
        assertEquals(3, flowers.size());
        for (Flower f : flowers){
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorRed(){
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.RED);
        assertEquals(2, flowers.size());
        for (Flower f : flowers){
            assertEquals(PlantColor.RED, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorGreen(){
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(0, flowers.size());

        SimpleList<Shrub> shrubs = shrubBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(4, shrubs.size());
    }
}
