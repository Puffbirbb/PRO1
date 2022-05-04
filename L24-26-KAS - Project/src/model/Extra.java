package model;

public class Extra {

    private String name;
    private double price;

    /**
     * Pre: price must be positive.
     *      name must not be nullable or empty.
     */
    Extra(String name, double price){ // OBS: package visible
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
