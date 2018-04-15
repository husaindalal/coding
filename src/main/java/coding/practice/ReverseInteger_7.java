package coding.practice;

public class ReverseInteger_7 {

    public static void main(String[] args) {
        Integer num = 123;
        System.out.println(run(num));
    }

    private static Integer run(Integer num) {
        Boolean isPositive = num > 0;

        num = Math.abs(num);

        Integer ret = 0;

        Integer pow = 1;
        while (num != 0) {
            Integer val = num % 10;

            ret = ret * pow + val;
            num /= 10;

            pow *= 10;
        }

        if (!isPositive) {
            ret *= -1;
        }

        return ret;
    }
}
