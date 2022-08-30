import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PlusMinus {

    public static void main(String [] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(-1);
        arr.add(-1);
        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int totalElements = arr.size();
        double plusElements = 0;
        double minusElements = 0;
        double zeroElements = 0;

        for(Integer a : arr) {
            if (a > 0) {
                plusElements += 1;
            } else if (a < 0) {
                minusElements += 1;
            } else {
                zeroElements += 1;
            }
        }

        double positive;
        double negative;
        double zero;

        positive = plusElements / totalElements;
        System.out.println(new BigDecimal(positive).setScale(4, RoundingMode.HALF_UP));


        negative = minusElements / totalElements;
        System.out.println(new BigDecimal(negative).setScale(4, RoundingMode.HALF_UP));


        zero = zeroElements / totalElements;
        System.out.println(new BigDecimal(zero).setScale(4, RoundingMode.HALF_UP));

    }
}
