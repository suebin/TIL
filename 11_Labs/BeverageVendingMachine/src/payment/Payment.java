package payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결제.
 */
public class Payment {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 결제를 한다.
     *
     * @param name  음료명
     * @param price 가격
     */
    public static void makePayment(String name, int price) throws IOException {

        System.out.println("\n==== 선택하신 " + name + " 결제를 시작합니다. 가격은 " + price + "입니다. ====\n\n"
                + "아래에서 원하는 결제 수단을 선택하여 입력해주세요. (ex) 신용카드)\n\n"
                + "> 현금\n"
                + "> 신용카드\n"
                + "> 온라인 페이\n");

        String paymentMethod = reader.readLine();

        switch (paymentMethod) {
            case "현금":
                payByCash(price);
                break;
            case "신용카드":
                payByCard();
                break;
            case "온라인 페이":
                payByOnlinePay();
                break;
            default:
                retry();
                makePayment(name, price);
                break;
        }

        reader.close();
    }

    private static void payByCash(int price) throws IOException {
        System.out.println("\n> 현금 결제를 선택하셨습니다. 지불할 현금 금액을 입력해주세요. (ex) 3000)\n");

        int cash = Integer.parseInt(reader.readLine());
        int change = cash - price;

        if (change < 0) {
            System.out.println("\n현금이 부족합니다! 결제를 실패하였습니다. 자판기 프로그램을 종료합니다.\n");
            System.exit(1);
        }

        int[] coins = { 500, 100, 50, 10, 5, 1 };

        StringBuilder coinLog = new StringBuilder();

        for (int coin : coins) {
            if (coin > change) {
                continue;
            }

            int count = 0; // 동전의 개수

            count += (change / coin);
            change -= (coin * (change / coin));

            coinLog.append(coin + "원 ( " + count + "개) ");
        }

        System.out.println("현금 결제가 정상적으로 완료되었습니다. 거스름돈을 확인해주세요.\n"
                + "거스름돈 : " + coinLog + "\n");

    }

    private static void payByCard() {
        System.out.println("\n> 신용카드 연결 성공하였습니다. 결제가 정상적으로 완료되었습니다.\n");
    }

    private static void payByOnlinePay() {
        System.out.println("\n> 온라인 페이 연결 성공하였습니다. 결제가 정상적으로 완료되었습니다.\n");
    }

    private static void retry() {
        System.out.println("\n> 현금, 신용카드, 온라인 페이 중 하나만 선택하여 한글로 입력해야 결제 진행이 가능합니다!"
                + "다시 결제 수단을 입력해주세요.\n\n");
    }

}
