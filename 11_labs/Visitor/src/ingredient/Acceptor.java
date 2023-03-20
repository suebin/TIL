package ingredient;

import recipe.Visitor;

public abstract class Acceptor {
    protected String name;
    protected int quantity;
    protected String unit;

    public Acceptor(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public abstract void accept(Visitor visit);
}