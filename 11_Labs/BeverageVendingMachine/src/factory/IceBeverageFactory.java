package factory;

import beverage.Beverage;
import beverage.IceBeverage;

/**
 * 시원한 음료를 만드는 factory.
 */
public class IceBeverageFactory extends BeverageFactory {
    public IceBeverageFactory(String menuName, int price,
            boolean isCoffee, boolean hasChocolate, boolean hasMilk) {
        super(menuName, price, isCoffee, hasChocolate, hasMilk);
    }

    @Override
    protected Beverage createBeverage(String menuName, int price,
            boolean isCoffee, boolean hasChocolate, boolean hasMilk) {
        IceBeverage iceBeverage = new IceBeverage(menuName, price, isCoffee, hasChocolate, hasMilk);
        return iceBeverage;
    }
}
