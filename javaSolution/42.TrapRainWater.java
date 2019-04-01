// the key idea is to calculate water for each bar instead of range of bars.
class TrapRainWater {
    public int trap(int[] height) {
        return trapTwoPointer(height);
    }

    /*
        For each bar, find left and right bar higher than it to get water.
        If either left/right not found, then no water trapped there.
     */
    private int trapBruteForce(int[] height) {
        if (height.length < 3) return 0;
        int length = height.length;
        int trapped = 0;
        for (int i = 1; i < length; i++) {
            int h = height[i];
            int left = i-1, right = i+1;
            while (left >= 0 && height[left] < h) {
                left--;
            }
            while (right < length && height[right] < h) {
                right++;
            }
            if (left >= 0 && right < length) {
                trapped += height[Math.min(left, right)] - h;
            }
        }
        return trapped;
    }

    /*
        Note: we only need to know if there's a higher bar at left/right side of bar `i`.
            1. highestFromLeft[i] has highest bar from [0, i]
            2. highestFromRight[i] has highest bar from [i, height.length]
            3. water at bar i is: Math.min(highestFromLeft[i], highestFromRight[i]) - height[i]
     */
    private int trapDP(int[] height) {
        int length = height.length;
        if (length < 3) return 0;
        int[] highestFromLeft = new int[length];
        int[] highestFromRight = new int[length];
        highestFromLeft[0] = height[0];
        highestFromRight[length-1] = height[length-1];
        for (int i = 1; i < length; i++) {
            highestFromLeft[i] = Math.max(highestFromLeft[i-1], height[i]);
        }
        for (int j = length-2; j >= 0; j--) {
           highestFromRight[j] = Math.max(highestFromRight[j+1], height[j]);
        }

        int trapped = 0;
        for (int i = 1; i < length - 1; i++) {
            trapped += Math.min(highestFromLeft[i], highestFromRight[i]) - height[i];
        }
        return trapped;
    }

    /*
        Not very intuitive.

        1. two pointer - left, right. only move the shorter bar of left/right index.
        2. keep leftHighest, rightHighest as highest bars on left and right while moving.
        3. if height[left] < height[right]:
            3a. if (height[left] < height[leftHighest]): (can trap water at left index) `water = min(leftHighest, rightHighest) - height[i]
            3b. else: (cannot trap water) `left++`
            3c. update leftHighest
        4. same 3a, 3b, 3c logic for left >= right for right index.
     */
    private int trapTwoPointer(int[] height) {
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        int length = height.length;
        if (length < 3) return 0;
        int left = 0, right = length - 1;
        int leftHighest = 0, rightHighest = length - 1;
        int trapped = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < height[leftHighest]) {
                    trapped += Math.min(height[leftHighest], height[rightHighest]) - height[left];
                }
                left++;
                leftHighest = height[left] > height[leftHighest] ? left: leftHighest;
            } else {
                if (height[right] < height[rightHighest]) {
                    trapped += Math.min(height[leftHighest], height[rightHighest]) - height[right];
                }
                right--;
                rightHighest = height[right] > height[rightHighest] ? right: rightHighest;

            }
        }
        return trapped;
    }
}