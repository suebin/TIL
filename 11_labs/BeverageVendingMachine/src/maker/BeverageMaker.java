package maker;

import beverage.Beverage;

/**
 * 음료를 만들어주는 maker.
 */
public class BeverageMaker {
    private Beverage beverage;

    public BeverageMaker(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * maker를 시작하여 음료를 만든다.
     */
    public void start() throws InterruptedException {
        getCup(beverage.getCupType());
        makeBeverage();
        getBeverage();
        done(beverage.getMenu());
    }

    private static void getCup(String cupType) throws InterruptedException {
        System.out.println("# " + cupType + "을 받아주세요.");
        Thread.sleep(1000);
    }

    private static void getBeverage() throws InterruptedException {
        System.out.println("# 음료 추출대에서 음료를 받아주세요.");
        Thread.sleep(1000);
    }

    private void makeBeverage() throws InterruptedException  {
        System.out.println("# 물을 받습니다.");
        Thread.sleep(1000);

        if (beverage.isIce()) getIce();
        if (beverage.isCoffee()) getCoffee();
        if (beverage.hasChocolate()) getChocolate();
        if (beverage.hasMilk()) getMilk();
        if (beverage.isCoffee() == false  && beverage.hasChocolate() == false && beverage.hasMilk() == false) getPeachIceTea();
    }

    private void getIce() throws InterruptedException {
        System.out.println("# 얼음 추출대에서 얼음을 받습니다.");
        Thread.sleep(1000);
    }

    private void getCoffee() throws InterruptedException {
        System.out.println("# 에스프레소를 받습니다.");
        Thread.sleep(1000);
    }

    private void getChocolate() throws InterruptedException {
        System.out.println("# 초코를 받습니다.");
        Thread.sleep(1000);
    }

    private void getMilk() throws InterruptedException {
        System.out.println("# 우유를 받습니다.");
        Thread.sleep(1000);
    }

    private void getPeachIceTea() throws InterruptedException {
        System.out.println("# 복숭아 아이스티 액을 받습니다.");
        Thread.sleep(1000);
    }

    private static void done(String beverageName) {
        System.out.println("# 주문하신 " + beverageName + " 제조가 완료되었습니다. 맛있게 드세요. 감사합니다 :-)");
    }
}
