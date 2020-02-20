import java.util.HashMap;
import java.util.Map;

class ConfusingNumber {
    public int confusingNumberII(int N) {
        Map<Integer, Integer> rotate = new HashMap<>();
        rotate.put(0, 0);
        rotate.put(1, 1);
        rotate.put(6, 9);
        rotate.put(8, 8);
        rotate.put(9, 6);

        return count(N, 0, rotate);
    }

    private int count(int N, int cumu, Map<Integer, Integer> rotate) {
        if (cumu > N) return 0;
        int count = 0;
        if (isConfusing(cumu, rotate)) count++;
        for (int i: rotate.keySet()) {
            if ((Integer.MAX_VALUE - i)/10 < cumu) continue;
            int next = cumu * 10 +i;
            if (next != 0) {
                count += count(N, next, rotate);
            }
        }
        return count;
    }

    private boolean isConfusing(int N, Map<Integer, Integer> rotate) {
        int K = 0;
        int J = N;
        while (J > 0) {
            K *= 10;
            try {
                K += rotate.get(J%10);
            } catch (Exception e) {
                System.out.println(N);
                System.out.println(J);
                System.out.println(K);
            throw e;
            }
            J /= 10;
        }
        return K != N;
    }

}