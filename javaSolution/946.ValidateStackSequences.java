class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) return true;
        if (pushed.length != popped.length) return false;
        int firstPoppedIdx = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[0]) {
                firstPoppedIdx = i;
                break;
            }
        }
        int right = pushed.length-1;
        int left = firstPoppedIdx;
        for (int i = 0; i < popped.length; i++) {
            if (left >= 0 && popped[i] == pushed[left]) {
                left--;
            } else if (right > firstPoppedIdx && popped[i] == pushed[right]) {
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}