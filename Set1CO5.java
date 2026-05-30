import java.util.*;

public class Set1CO5 {

    static class Delivery {

        int over, ball;
        int batsmanId, bowlerId, runs;

        Delivery(int over, int ball) {
            this.over = over;
            this.ball = ball;
        }
    }

    static Delivery[] countingSortByOver(Delivery[] in) {

        final int K = 50;

        int[] count = new int[K + 1];

        // Count frequency
        for (Delivery d : in)
            count[d.over]++;

        // Prefix sums
        for (int i = 1; i <= K; i++)
            count[i] += count[i - 1];

        Delivery[] out =
                new Delivery[in.length];

        // Reverse traversal
        for (int i = in.length - 1; i >= 0; i--) {

            Delivery d = in[i];

            out[--count[d.over]] = d;
        }

        return out;
    }

    public static void main(String[] args) {

        Delivery[] deliveries = {
                new Delivery(2,4),
                new Delivery(1,1),
                new Delivery(3,6),
                new Delivery(1,5)
        };

        Delivery[] result =
                countingSortByOver(deliveries);

        for (Delivery d : result)
            System.out.println(
                    "(" + d.over +
                            "," + d.ball + ")");
    }
}
