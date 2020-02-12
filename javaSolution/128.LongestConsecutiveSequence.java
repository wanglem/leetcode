import java.util.*;

class LongestConsecutiveSequence {
    private class Group {
        int start;
        int end;
        Group next = null;
        Group(int s, int e) {
            start = s;
            end = e;
        }
    }
    private class SeqGroup {
        // maintain sorted order
        Group head = new Group(Integer.MIN_VALUE, Integer.MIN_VALUE);

        void add(int i) {
            Group newG = new Group(i, i);
            insert(newG);
        }

        private void insert(Group g) {
            Group cur = head;
            if (cur.next == null) {
                cur.next = g;
                return;
            }
            while (cur.next != null) {
                if (g.start == cur.end + 1) {
                    cur.end = g.end;
                    consolidate(cur);
                } else if (g.end == cur.next.start - 1) {
                    cur.next.start = g.start;
                    consolidate(cur);
                } else if (g.start > cur.end + 1 && g.end < cur.next.start - 1) {
                    g.next = cur.next;
                    cur.next = g;
                }
                cur = cur.next;
            }
        }

        void consolidate(Group g) {
            while (g.next != null) {
                if (g.end == g.next.start) {
                    g.end = g.next.end;
                    g.next = g.next.next;
                    break;
                }
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        SeqGroup sg = new SeqGroup();
        for (int n: nums) {
            sg.add(n);
        }
        Group c = sg.head;
        int longest = 1;
        while (c != null) {
            longest = Math.max(c.end - c.start + 1, longest);
        }
        return longest;
    }


}