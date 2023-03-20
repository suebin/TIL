package beverage;

/**
 * 따뜻한 음료.
 */
public class HotBeverage implements Beverage {
    private String name;
    private int price;
    private String cupType;
    private boolean isIce;
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
    public HotBeverage(String name, int price, boolean isCoffee,
            boolean hasChocolate, boolean hasMilk) {
        this.name = name;
        this.price = price;
        this.isCoffee = isCoffee;
        this.hasChocolate = hasChocolate;
        this.hasMilk = hasMilk;
        this.cupType = "종이컵";
        this.isIce = false;
    }

    public String getMenu() {
        return this.name;
    }

    public void setMenu(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCupType() {
        return this.cupType;
    }

    public boolean isIce() {
        return this.isIce;
    }

    @Override
    public boolean isCoffee() {
        return this.isCoffee;
    }

    @Override
    public boolean hasChocolate() {
        return this.hasChocolate;
    }

    @Override
    public boolean hasMilk() {
        return this.hasMilk;
    }
}
