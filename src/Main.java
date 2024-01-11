import java.util.Scanner;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    static BigDecimal TEN = BigDecimal.valueOf(10);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println("Hello and welcome!");
        double x; int k;

        do { // x belongs to (-1; 1)
            System.out.println("x принадлежит интервалу (-1; 1)");
            x = in.nextDouble();
        } while(x <= -1 || x >= 1);

        k = in.nextInt();
        BigDecimal limit = limitCount(k);

        BigDecimal Value = BigDecimal.valueOf(1); //Answer
        BigDecimal I;
        BigDecimal IterationValue = BigDecimal.valueOf(1); // x^n
        BigInteger UpperValue; // n(n+1)/2
        int cur = 2;
        int sign = 1;

        int res = 1;
        while(res > 0)
        {
            IterationValue = IterationValue.multiply(BigDecimal.valueOf(x));
            IterationValue = IterationValue.multiply(BigDecimal.valueOf(-1));

            //System.out.print(IterationValue);
            if(x >= 0)
                sign++;

            UpperValue = Arg(cur);
            cur++;

            I = IterationValue;
            I = I.multiply(new BigDecimal(UpperValue));
            Value = Value.add(I);
            //System.out.print(" " + I + " ");
            if (sign % 2 == 1) {
                //System.out.println("This");
                res = I.compareTo(limit);
            }
            else {
                //System.out.print("That");
                I = I.multiply(BigDecimal.valueOf(-1));
                res = I.compareTo(limit);
            }
        }

        System.out.println(Value);

        System.out.println(1/((1 + x)*(1 + x)*(1 + x)));
    }

    @SuppressWarnings("BigDecimalMethodWithoutRoundingCalled")
    static BigDecimal limitCount(int k) {
        BigDecimal Ans = BigDecimal.valueOf(1);
        for (int i = 0; i < k; i++) {
            Ans = Ans.divide(TEN);
        }
        return Ans;
    }
    static BigInteger Arg(int x)
    {
        BigInteger Answer, Num, Num2;
        Num = BigInteger.valueOf(x);
        Num2 = BigInteger.valueOf(x + 1);

        Answer = Num.multiply(Num2);
        Answer = Answer.divide(BigInteger.valueOf(2));
        return Answer;
    }
}