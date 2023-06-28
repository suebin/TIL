import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeOfClothesMap = new HashMap<>();
        for (String[] clothesElement : clothes) {
            String typeOfClothes = clothesElement[1];
            typeOfClothesMap.put(typeOfClothes, typeOfClothesMap.getOrDefault(typeOfClothes, 0) + 1);
        }

        int answer = 1;
        for (int typeOfClothesCnt : typeOfClothesMap.values()) {
            answer *= (typeOfClothesCnt + 1);
        }
        answer -= 1; // 아무것도 입지 않는 경우를 제외

        return answer;
    }
}