package ohm.softa.a05.tests.model;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {
    @Test
    void testCreateGreenFlower(){
        assertThrows(IllegalArgumentException.class, () -> new Flower("Rosa", "Abracadabra", 0.5, PlantColor.GREEN));
    }

    @Test
    void testCreateFlowerWithEmptyName(){
        assertThrows(IllegalArgumentException.class, () -> new Flower("Rose", null, 0.5, PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithEmptyFamily(){
        assertThrows(IllegalArgumentException.class, () -> new Flower(null, "Abracadabra", 0.5, PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithNegativeHeight(){
        assertThrows(IllegalArgumentException.class, () -> new Flower("Rose", "Abracadabra", -0.5, PlantColor.RED));
    }

    @Test
    void testGetCorrectColor(){
        Flower f = new Flower("Rose", "Abracadabra", 0.5, PlantColor.RED);
        assertEquals(PlantColor.RED, f.getColor());
    }

    @Test
    void testGetCorrectHeight(){
        Flower f = new Flower("Rose", "Abracadabra", 0.5, PlantColor.RED);
        assertEquals(0.5, f.getHeight(), 0.0000001);
    }

    @Test
    void testGetCorrectName(){
        Flower f = new Flower("Rose", "Abracadabra", 0.5, PlantColor.RED);
        assertEquals("Abracadabra", f.getName());
    }

    @Test
    void testGetCorrectFamily(){
        Flower f = new Flower("Rose", "Abracadabra", 0.5, PlantColor.RED);
        assertEquals("Rose", f.getFamily());
    }

    @Test
    void testSortFlowers(){
        List<Plant> flowers = new LinkedList<>();

        flowers.add(new Shrub("Buxus", "Buxus sempervirens", 3.5));
        flowers.add(new Flower("Rosa", "Abracadabra", 1.1, PlantColor.RED));
        flowers.add(new Shrub("Buxus", "Buxus sempervirens", 5.5));
        flowers.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowers.add(new Shrub("Buxus", "Buxus sempervirens", 1.5));
        flowers.add(new Flower("Rosa", "Abracadabra", 0.75, PlantColor.RED));
        flowers.add(new Shrub("Buxus", "Buxus sempervirens", 4.5));
        flowers.add(new Flower("Rosa", "Abracadabra", 2.5, PlantColor.RED));

        flowers.sort(Plant::compareTo);

        double lastHeight = 0.0;
        for (Plant f : flowers){
            assertTrue(f.getHeight() > lastHeight);
            lastHeight = f.getHeight();
        }
    }
}
