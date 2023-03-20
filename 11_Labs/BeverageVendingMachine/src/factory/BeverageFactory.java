package factory;

import beverage.Beverage;
import java.io.IOException;
import maker.BeverageMaker;
import payment.Payment;

/**
 * 음료를 만드는 factory.
 */
public abstract class BeverageFactory {
    private String name;
    private int price;
    private boolean isCoffee;
    private boolean hasChocolate;
    private boolean hasMilk;

    /**
     * Constructor.
     *
     * @param name         음료명
     * @param price        가격
     * @param isCoffee     커피류이면 true를 반환
     * @param hasChocolate 초콜릿류면 true를 반환
     * @param hasMilk      우유가 들어가면 true를 반환
     */
    public BeverageFactory(String name, int price, boolean isCoffee,
            boolean hasChocolate, boolean hasMilk) {
        this.name = name;
        this.price = price;
        this.isCoffee = isCoffee;
        this.hasChocolate = hasChocolate;
        this.hasMilk = hasMilk;
    }

    /**
     * 음료를 만들어 만든 음료를 반환한다.
     *
     * @return 음료
     */
    public final Beverage create() throws IOException, InterruptedException {
        Beverage beverage = createBeverage(name, price, isCoffee, hasChocolate, hasMilk);
        Payment.makePayment(beverage.getMenu(), beverage.getPrice());
        makeBeverage(beverage);
        return beverage;
    }

    protected void makeBeverage(Beverage beverage) throws InterruptedException {
        BeverageMaker maker = new BeverageMaker(beverage);
        maker.start();
    }

    protected abstract Beverage createBeverage(String menuName, int price,
            boolean isCoffee, boolean hasChocolate, boolean hasMilk);
}