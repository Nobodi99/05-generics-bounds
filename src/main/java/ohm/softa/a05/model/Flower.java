package ohm.softa.a05.model;

public class Flower extends Plant{

    public Flower(String family, String name, double height, PlantColor color) {
        super(family, name, height);

        // Flower can't be green
        if (color == PlantColor.GREEN) {
            throw new IllegalArgumentException("A Flower can't be green!");
        }

        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Flower)){
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
