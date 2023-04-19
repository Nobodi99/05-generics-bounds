package ohm.softa.a05.model;

import java.util.Objects;

public abstract class Plant implements Comparable<Plant>{
    double height;
    String family;
    String name;
    PlantColor color;

    public Plant(String family, String name, double height){
        if(family == null || family.length() == 0) throw new IllegalArgumentException("Specify a family");
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Specify a name");
        if(height <= 0.0) throw new IllegalArgumentException("Height may not be less or equal zero");
        this.height = height;
        this.family = family;
        this.name = name;
    }

    public Plant(String family, String name, double height, PlantColor color){
        if(family == null || family.length() == 0) throw new IllegalArgumentException("Specify a family");
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Specify a name");
        if(height <= 0.0) throw new IllegalArgumentException("Height may not be less or equal zero");
        if (color == null) throw new IllegalArgumentException("A plant has to have a color");
        this.height = height;
        this.family = family;
        this.name = name;
        this.color = color;
    }

    public double getHeight(){
        return height;
    }

    public String getFamily(){
        return family;
    }

    public String getName(){
        return name;
    }

    public PlantColor getColor(){
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Double.compare(plant.height, height) == 0 &&
                Objects.equals(family, plant.family) &&
                Objects.equals(name, plant.name) &&
                color == plant.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, family, name, color);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "height=" + height +
                ", family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }

    public int compareTo(Plant plant){
        return Double.compare(this.height, plant.height);
    }
}
