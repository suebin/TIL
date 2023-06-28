import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> phoneBookSet = new TreeSet<>(Arrays.asList(phone_book));
        String prePhoneNumber = "init";
        for (String phoneNumber : phoneBookSet) {
            if (phoneNumber.startsWith(prePhoneNumber)) {
                answer = false;
                break;
            }
            prePhoneNumber = phoneNumber;
        }
        return answer;
    }
}