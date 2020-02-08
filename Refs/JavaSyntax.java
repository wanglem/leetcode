/*********   Array      ***********/
int[] arr = new int[10];
Arrays.sort(arr);
Arrays.sort(arr, Collections.reveseOrder());
Arrays.sort(intervals, (x, y) -> x.start - y.start);

new String[]{"blah", "hey", "yo"}
String[] strs = {"blah", "hey", "yo"};

List<Integer> arr = Arrays.asList(1,2,3);

/*********   TreeSet      ***********/

// an ordered Set
TreeSet<Integer> ts = new TreeSet<>(arr);
ts.celing(12); // return least element >= 12
ts.floor(12); //return greatest element <= 12
// ts.higher(), ts.lower() for > or < value

ts.headSet(12, inclusiveBoolean) // all elements lower than 12
ts.tailSet(12, inclusiveBoolean) // all elements greater than 12

ts.subSet(12, 15) // all elements between 12 and 15

/************   List      ***********/

// array sort by key
intervals.sort(Comparator.comparing((Interval i) -> i.start));
intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start)));

// reverse a list
Collections.reverse(List<?>>) 

/************   Queue      ***********/
Deque<Integer> q = new ArrayDeque<>();
Deque<Integer> q2 = new LinkedList<>();
q.offer(1); q.offerFirst(1); q.offerLast(1);
q.poll(); q.pollFirst(); q.pollLast();
q.peek(); q.peekLast(); q.peekFirst();
q.size(); q.isEmpty()

PriorityQueue<Integer> p = new PriorityQueue<>();
p.offer(1);
p.poll();
p.peek();
p.size();
p.isEmpty()

/************   Stack      ***********/
Stack<Integer> s = new Stack<>();
s.push(1);
s.pop();
s.peek();
s.isEmpty();

/************   BinaryTree      ***********/
// Iterative BFS
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root)
while (!queue.isEmpty()) {
    int levelSize = queue.size();
    for (int i = 0; i < levelSize; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
    }
}


/************   BinaryTree      ***********/
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x,y) -> y-x);
PriorityQueue< Integer > minHeap = new PriorityQueue <> ();