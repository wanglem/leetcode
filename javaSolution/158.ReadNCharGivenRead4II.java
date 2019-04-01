import java.util.LinkedList;
import java.util.Queue;

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
class ReadNCharGivenRead4II {

    private Queue<Character> readBuf = new LinkedList<>();
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (!readBuf.isEmpty() && i < n) {
            buf[i++] = readBuf.poll();
        }

        char[] read4cache = new char[4];
        int read4returned;
        while (i < n) {
            read4returned = read4(read4cache);
            if (read4returned == 0) break;
            int j = 0;
            while (j < read4returned && i < n) {
                buf[i++] = read4cache[j++];
            }
            while (i == n && j < read4returned) {
                readBuf.offer(read4cache[j++]);
            }
        }

        return i;
    }

    private int read4(char[] buf) {
        return 0;
    }
}