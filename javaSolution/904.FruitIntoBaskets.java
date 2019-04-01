import java.util.HashMap;
import java.util.Map;

// Google
class FruitIntoBasket {
    public int totalFruit(int[] tree) {
        if (tree.length < 3) {
            return tree.length;
        }

        int i = 0, j = 1;
        int first = tree[0], firstCount = 1;
        int max = 1;
        while (j < tree.length && first == tree[j]) {
            max++;
            firstCount++;
            j++;
        }
        if (j == tree.length) return max;
        int second = tree[j], secondCount = 0;
        while (j < tree.length) {
            if (tree[j] != first && tree[j] != second) {
                while (firstCount != 0 && secondCount != 0) {
                    if (tree[i] == first) firstCount--;
                    else secondCount--;
                    i++;
                }
                first = firstCount == 0 ? second : first;
                firstCount = firstCount == 0 ? secondCount: firstCount;
                second = tree[j];
                secondCount = 1;
            } else if (tree[j] == first){
                firstCount++;
            } else {
                secondCount++;
            }
            max = Math.max(firstCount + secondCount, max);
            j++;
        }
        return max;
    }
}