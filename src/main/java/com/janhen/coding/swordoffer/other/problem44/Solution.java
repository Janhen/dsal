package main.java.janhen.swordoffer.other.problem44;

public class Solution {
    public int getDigitAtIndex(int index) {
        // bit in the digit
        int place = 1;
        while (true) {
            int totalAmount = getTotalAmountAtBit(place);
            if (index < totalAmount) {
                // get the result
                int res = getDigitAtIndex(index, place);
                return 1;
            }
            place++;
            index -= totalAmount;
        }
    }

    private int getDigitAtIndex(int index, int place) {
        int beginNum = getBeginNumAtBit(place);
        int shiftNum = index / place;
        String res = beginNum + shiftNum + "";
        int cnt = index % place;
        return res.charAt(cnt) - '0';
    }

    private int getBeginNumAtBit(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    private int getTotalAmountAtBit(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9 * place;
    }
}
