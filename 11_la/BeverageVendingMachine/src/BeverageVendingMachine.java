import factory.HotBeverageFactory;
import factory.IceBeverageFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 음료 자판기.
 */
public class BeverageVendingMachine {
    private HashMap<String, HotBeverageFactory> hotBeverages;
    private HashMap<String, IceBeverageFactory> iceBeverages;

    /**
     * Constructor.
     */
    public BeverageVendingMachine() {
        hotBeverages = new HashMap<>();
        iceBeverages = new HashMap<>();

        hotBeverages.put("아메리카노", new HotBeverageFactory("아메리카노", 1200, true, false, false));
        hotBeverages.put("카페라떼", new HotBeverageFactory("카페라떼", 1700, true, false, true));
        hotBeverages.put("모카치노", new HotBeverageFactory("모카치노", 1700, true, true, true));
        hotBeverages.put("핫 초코", new HotBeverageFactory("핫 초코", 1700, false, true, false));

        iceBeverages.put("아이스 아메리카노", new IceBeverageFactory("아이스 아메리카노", 2000, true, false, false));
        iceBeverages.put("아이스 초코", new IceBeverageFactory("아이스 초코", 2300, false, true, false));
        iceBeverages.put("아이스 카페라떼", new IceBeverageFactory("아이스 카페라떼", 2300, true, false, true));
        iceBeverages.put("복숭아 아이스티", new IceBeverageFactory("복숭아 아이스티", 2000, false, false, false));
    }

    /**
     * 음료 자판기 실행을 시작한다.
     *
     */
    public void start() throws Exception {
        StringBuilder notice = new StringBuilder();
        notice.append("\n==== 안녕하세요! 아래에서 원하는 음료를 선택하여 입력해주시길 바랍니다. (ex) 아메리카노) ====\n\n");

        for (String hotMenu : hotBeverages.keySet()) {
            notice.append("> " + hotMenu + "\n");
        }

        for (String iceMenu : iceBeverages.keySet()) {
            notice.append("> " + iceMenu + "\n");
        }

        System.out.println(notice);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String beverage = reader.readLine();

        if (hotBeverages.containsKey(beverage)) {
            hotBeverages.get(beverage).create();
        } else if (iceBeverages.containsKey(beverage)) {
            iceBeverages.get(beverage).create();
        } else {
            System.out.println("> 음료를 잘못 입력하셨습니다. 원하는 음료를 한글로 정확하게 입력해주세요. 자판기 프로그램을 다시 실행합니다.");
            start();
        }

        reader.close();
    }
}
