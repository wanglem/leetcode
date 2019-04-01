/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
class ReadNCharGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] read4buf = new char[4];
        while (count < n) {
            int read4count = read4(read4buf);
            if (read4count == 0) break;
            int i = 0;
            while (i < read4count && count < n) {
                buf[count++] = read4buf[i++];
            }
        }
        return count;
    }


    private int read4(char[] buf) {
        return 0;
    }
}