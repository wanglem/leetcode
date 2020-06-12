import java.util.*;

class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int maxLen = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxWide = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxLen = Math.max(maxLen, horizontalCuts[i] - horizontalCuts[i-1]);
        }

        for (int i = 1; i < verticalCuts.length; i++) {
            maxWide = Math.max(maxWide, verticalCuts[i] - verticalCuts[i-1]);
        }

        return (int)(((long)maxLen * maxWide)% ((int)Math.pow(10, 9) + 7));
    }
}