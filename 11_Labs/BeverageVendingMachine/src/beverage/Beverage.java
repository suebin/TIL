package beverage;

/**
 * 음료 타입.
 */
public interface Beverage {
    String getMenu();

    void setMenu(String menuName);

    int getPrice();

    void setPrice(int price);

    String getCupType();

    boolean isIce();

    boolean isCoffee();

    boolean hasChocolate();

    boolean hasMilk();
}

