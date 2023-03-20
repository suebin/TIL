package factory;

import beverage.Beverage;
import beverage.HotBeverage;

/**
 * 따뜻한 음료를 만드는 factory.
 */
public class HotBeverageFactory extends BeverageFactory {
    public HotBeverageFactory(String name, int price,
            boolean isCoffee, boolean hasChocolate, boolean hasMilk) {
        super(name, price, isCoffee, hasChocolate, hasMilk);
    }

    @Override
    protected Beverage createBeverage(String name, int price,
            boolean isCoffee, boolean hasChocolate, boolean hasMilk) {
        HotBeverage hotBeverage = new HotBeverage(name, price, isCoffee, hasChocolate, hasMilk);
        return hotBeverage;
    }
}
