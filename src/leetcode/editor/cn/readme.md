# 剑指 offer

## 03. 数组中重复的数字

> 一、ArrayList.contains() 方法遍历nums，超时
>
> 二、HashSet 返回添加失败的元素，ok
>
> 三、原地索引交换，perfect

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        for(int i=0, len=nums.length; i<len; i++) {
            // 自己在家
            if (nums[i] == i) {
                continue;
            }
            // 家里有别人
            if (nums[i] == nums[nums[i]]) {
                repeat = nums[i];
                break;
            }

            // 回家
            nums[i] = nums[i] ^ nums[nums[i]];
            nums[nums[i]] = nums[i] ^ nums[nums[i]];
            nums[i] = nums[i] ^ nums[nums[i]];
            i--;
            // 自己回家了, 被迫回家的数字还没处理
        }

        return repeat;
    }
}
```





## 04. 二维数组中的查找[mid]

> 二维数组查找内容的路线规划问题

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean flag = false;
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
```





## 05. 替换空格

> 一、使用 String 的 replace() 方法实现，ok
>
> 二、使用遍历字符串中的所有字符并使用 StringBuilder 拼接新字符串，ok

```java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            } 
        }
        return sb.toString();
    }
}
```





## 06. 从尾到头打印链表

> 一、使用辅助栈空间，ok
>
> 二、两次遍历链表，倒序数组赋值，perfect

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] ints = new int[size];
        for (int i = size; i > 0; i--) {
            ints[i - 1] = head.val;
            head = head.next;
        }

        return ints;
    }
}
```





## 07. 重建二叉树

> 递归: 先根据前序遍历构建根节点，然后递归构造左右子树，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[0]);
        int left_length = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                left_length = i;
                break;
            }
        }

        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + left_length), Arrays.copyOfRange(inorder, 0, left_length));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + left_length, preorder.length), Arrays.copyOfRange(inorder, left_length + 1, inorder.length));
        return treeNode;
    }
}
```





## 09. 用两个栈实现队列

> 一、数组 + 双指针(容量为10000)，ok
>
> 二、双栈，仅在出栈时维护队列顺序即可，ok

```java
class CQueue {

    Stack<Integer> stack = null;
    Stack<Integer> queue = null;
    public CQueue() {
        this.stack = new Stack<>();
        this.queue = new Stack<>();
    }

    public void appendTail(int value) {
        this.stack.push(value);
    }

    public int deleteHead() {
        if (!this.queue.empty()) {
            return this.queue.pop();
        } else if (this.stack.empty()) {
            return -1;
        } else {
            while (!this.stack.empty()) {
                this.queue.push(this.stack.pop());
            }
            return deleteHead();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```





## 10- I. 斐波那契数列

> 一、递归，超时
>
> 二、动态规划，状态转移方程: f(n) =  f(n-1) + f(n-2)  {n>0}，f(n) = n  {n<2}

```java
class Solution {
    public int fib(int n) {
        // cur 为 f(n) 的前一个值
        int pre = 0, cur = 1, next = n;
        for (int i = 1; i < n; i++) {
            next = (pre + cur) % 1000000007;
            pre = cur;
            cur = next;
        }

        return next;
    }
}
```





## 10- II. 青蛙跳台阶问题

> 与上题同理，状态转移方程: f(n) =  f(n-1) + f(n-2)  {n>0}，f(n) = 1  {n<2}

```java
class Solution {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }
        }

        return dp[n];
    }
}
```





## 11. 旋转数组的最小数字

> 一、暴力之美，遍历数组，共有两种情况: ，ok
>
> 	1. 数组本来就是有序的，那么第一个数字即为最小
> 	2. 数组非有序，则最小数组一定在第一个数字之后，当 numbers[i-1] > numbers[i] 时，number[i] 即为最小数字
>
> 二、递归，栈溢出
>
> 三、二分法，指针移动的思路较难，ok

```java
class Solution {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]) {  // mid 大于 high, 说明最小值在右侧且 mid 位置必定不可能为最小值
                low = mid + 1;
            } else if (numbers[mid] < numbers[high]) {  // mid 小于 high, 说明最小值一定在左侧(数组递增)
                high = mid;
            } else {  // mid 等于 high, 无法确定最小值的位置, 进一步缩小问题 ([2,2,2,1,2] 和 [1,2,2,2,2])
                high--;
            }
        }

        return numbers[low];
    }
}
```





## 12. 矩阵中的路径

> 回溯法，向当前坐标四周遍历结果集，ok

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows == 0) return word.length() == 0;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int k) {
        if (k == word.length()) return true;
        int rows = board.length;
        int cols = board[0].length;
        if (x < 0 || x >= rows || y < 0 || y >= cols || board[x][y] != word.charAt(k)) {
            return false;
        }
        board[x][y] = '\0';
        boolean flag = dfs(board, word, x - 1, y, k + 1) || dfs(board, word, x + 1, y, k + 1)
                || dfs(board, word, x, y - 1, k + 1) || dfs(board, word, x, y + 1, k + 1);
        board[x][y] = word.charAt(k);

        return flag;
    }
}
```





## 13. 机器人的运动范围

> dfs + 剪枝, ok

```java
class Solution {
    // 已访问坐标的标记数组
    boolean[][] visited = null;
    // 可到达的坐标数量
    int count = 0;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        // dfs 从左上角开始, 搜索所有坐标
        dfs(m, n, k, 0, 0);
        return this.count;
    }

    private void dfs(int m, int n, int k, int x, int y) {
        int sum = getBitSum(x) + getBitSum(y);
        // 不满足题意、坐标越界、已访问坐标, 都不再向下遍历
        if (sum > k || x >= m || y >= n || visited[x][y]) return;
        // 当前坐标符合题意
        this.count++;
        // 记录为已访问坐标
        visited[x][y] = true;
        // 向右搜索
        dfs(m, n, k, x, y + 1);
        // 向下搜索
        dfs(m, n, k, x + 1, y);
    }

    /**
     * 计算某数字的各数位之和
     */
    private int getBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
```





## 14- I. 剪绳子

> 动态规划，ok
>
> ​	关键信息: 当 n < 3 时 dp[2] = 1{因为必须要切一刀}，但是当 n > 3 时 dp[2] = 2{此时一定至少切过一刀了, 因此 dp[2] = 2}，同理 dp[3] 也不同

```java
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) return n-1;
        int[] dp = new int[n + 1];
        for (int i = 1; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }
}
```





## 14- II. 剪绳子 II

> 贪心，每次都剪为长度为 3 的绳子(最后一段除外)，ok

```java
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int r = (int) (1e9+7);

        // 1. (a * b) % r = (a % r) * (b % r) % r
        // 2. ans 取余前可能大于 Integer.MAX_VALUE，所以要使用 long 防止溢出
        long ans = 1;
        // 每段都剪为长度为 3 的绳子, 当最后一段的长度为 4 时就不再剪断了
        while (n > 4) {
            ans = ans * 3 % r;
            n -= 3;
        }
        return (int) (ans * n % r);
    }
}
```





## 15. 二进制中1的个数

> 一、暴力，先转换为二进制字符串再进行字符遍历，ok
>
> 二、位运算，n & 1 = 1则 ans++，然后 n>>>1，ok
>
> ​	高位等于1时为负数，所以while 循环条件不能为 n > 0，只可以是 n != 0

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1) == 1 ? 1 : 0;
            n = n >>> 1;
        }

        return ans;
    }
}
```





## 16. 数值的整数次方

```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1 || x == 1) return x;
        if (n < 0) {
            // Integer.MAX_VALUE = 2147483647, MIN_VALUE = -2147483648，所以当 n<0 时先计算一次，使数值 + 1，防止转换为正数时出现溢出
            return 1 / (x * myPow(x, -1 * (n + 1)));
        } else {
            return myPow(x, n % 2) * myPow(x * x, n >> 1);
        }
    }
}
```





## 17. 打印从1到最大的n位数

> 一、暴力循环，ok
>
> 二、dfs 全排列，未验证

```java
class Solution {
    public int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] nums = new int[len];
        for (int i = 0; i < len;) {
            nums[i] = ++i;
        }

        return nums;
    }
}
```





## 18. 删除链表的节点

> 一、链表指针移动，ok
>
> 二、递归，ok

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) return null;
        if (head.val == val) return head.next;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        
        return head;
    }
}
```

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) return null;
        if (head.val == val) return head.next;
        else head.next = deleteNode(head.next, val);

        return head;
    }
}
```





## 20. 表示数值的字符串

> 暴力破解，ok
>
> 自动机，不会写

```java
class Solution {
    public boolean isNumber(String s) {
        if (null == s) return false;
        s = s.trim();
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return false;
        }

        char last = s.charAt(s.length() - 1);
        return last >= '0' && last <= '9' || last == '.';
    }
}
```





## 21. 调整数组顺序使奇数位于偶数前面

> 一、快排思想，双指针交换数据，perfect
>
> 二、快慢指针，快指针查找奇数并与慢指针交换数据，ok

```java
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            while (l < r) {
                if (nums[l] % 2 == 1) l++;
                else break;
            }
            while (l < r) {
                if (nums[r] % 2 == 0) r--;
                else break;
            }

            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }

        return nums;
    }
}
```





## 22. 链表中倒数第k个节点

> 指定长度的快慢指针，ok

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        ListNode fast = cur;
        for (int i = 0; i < k; i++) {
            if (null == fast) return null;
            fast = fast.next;
        }

        while (fast != null) {
            cur = cur.next;
            fast = fast.next;
        }

        return cur;
    }
}
```





## 24. 反转链表

> 一、使用辅助栈，浪费空间，ok
>
> 二、递归，头节点置尾的操作较难理解，ok
>
> 三、操作链表上的指针来实现链表反转，ok

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode reverse = new ListNode(-1);
        ListNode cur = reverse;
        while (!stack.empty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }

        return reverse.next;
    }
}
```

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode reverse = reverseList(head.next);

        // head.next 进行反转之后, head.next 节点就变为了反转链表的最后一个节点
        // 此时将未参与反转操作的 head 节点放置到反转链表的末尾
        head.next.next = head;
        // head 变为最后一个节点, 将 head.next 置为 null, 消除环形链表
        head.next = null;

        return reverse;
    }
}
```

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
```





## 25. 合并两个排序的链表

> 一、使用两个指针在两个链表上移动，使最终排序链表的指针始终指向较小的值，并移动其链表上的指针，ok
>
> 二、递归逐渐缩小问题实现合并，ok

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(-1);
        ListNode cur = merge;

        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (null != l1) cur.next = l1;
        if (null != l2) cur.next = l2;

        return merge.next;
    }
}
```

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```





## 26. 树的子结构

> 递归，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) return false;
        if (A.val == B.val && isEq(A.left, B.left) && isEq(A.right, B.right)) {
            return true;
        }

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isEq(TreeNode tree1, TreeNode tree2) {
        // 子树的所有节点递归判断相等了, 则返回真, 否则返回假
        if (null == tree1 || null == tree2) return null == tree2;
        // 先序遍历
        return tree1.val == tree2.val && isEq(tree1.left, tree2.left) && isEq(tree1.right, tree2.right);
    }
}
```





## 27. 二叉树的镜像

> 递归，dfs，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }
}
```





## 28. 对称的二叉树

> 递归，dfs，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return isImg(root.left, root.right);
    }

    private boolean isImg(TreeNode left, TreeNode right) {
        if (null == left || null == right) return left == right;
        return left.val == right.val && isImg(left.left, right.right) && isImg(left.right, right.left);
    }
}
```





## 29. 顺时针打印矩阵

> 正常解题，顺时针遍历，ok

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int size = (right + 1) * (bottom + 1);
        int[] ans = new int[size];
        int point = 0;
        while (point < size) {
            for (int i = left; i <= right; i++) {
                ans[point++] = matrix[top][i];
            }
            if (top++ == bottom) break;
            for (int i = top; i <= bottom; i++) {
                ans[point++] = matrix[i][right];
            }
            if (right-- == left) break;
            for (int i = right; i >= left; i--) {
                ans[point++] = matrix[bottom][i];
            }
            if (bottom-- == top) break;
            for (int i = bottom; i >= top; i--) {
                ans[point++] = matrix[i][left];
            }
            left++;
        }

        return ans;
    }
}
```





## 30. 包含min函数的栈

> 使用非严格降序的辅助栈保存 min 值，来实现 O(1) 的访问，ok

![Picture1.png](readme.assets/f31f4b7f5e91d46ea610b6685c593e12bf798a9b8336b0560b6b520956dd5272-Picture1.png)

```java
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public MinStack() {
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || min.peek() >= x) min.push(x);
    }

    public void pop() {
        if (data.pop().equals(min.peek())) min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```





## 31. 栈的压入、弹出序列

> 使用栈去模拟操作，ok

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int cursor = 0, popLength = popped.length;

        for (int i : pushed) {
            stack.push(i);
            while (!stack.empty() && cursor < popLength && popped[cursor] == stack.peek()) {
                stack.pop();
                cursor++;
            }
        }

        return cursor == popLength;
    }
}
```





## 32 - I. 从上到下打印二叉树

> bfs，树的层序遍历，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        // 实际测试案例中: 节点总数 <= 1009
        int[] ans = new int[1009];
        int cursor = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (null == remove) continue;
            queue.add(remove.left);
            queue.add(remove.right);
            ans[cursor++] = remove.val;
        }

        return Arrays.copyOfRange(ans, 0, cursor);
    }
}
```





## 32 - II. 从上到下打印二叉树 II

> 一、bfs基础之上添加统计第 n 层的计数操作，ok
>
> 二、递归，perfect

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> integers = new ArrayList<>();
            // 当前队列中的所有元素为同一层
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.remove();
                integers.add(poll.val);
                if (null != poll.left) queue.add(poll.left);
                if (null != poll.right) queue.add(poll.right);
            }
            ans.add(integers);
        }

        return ans;
    }
}
```

```java
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 递归实现二叉树的二维数组格式层序遍历
        // i 代表目前正在遍历的层数(从0开始)
        recur(root, 0);
        return ans;
    }

    private void recur(TreeNode root, int i) {
        if (null == root) return;
        // 初始化第 i 层的列表
        if (i == ans.size()) ans.add(new ArrayList<>());
        // 放置到对应的二维数组中
        ans.get(i).add(root.val);
        // 左右分别递归执行 i+1 层
        recur(root.left, i + 1);
        recur(root.right, i + 1);
    }
}
```





## 32 - III. 从上到下打印二叉树 III

> 一、层序遍历，当偶数层时反转二级列表中的数据，ok
>
> 二、使用双端列表作为二级列表，当偶数层时向头部插入数据从而实现顺序反转，ok
>
> 三、从左到右、从右到左为一组，每次 while 循环打印两层，关键是使用双端队列保证下一层的序列为从左到右的顺序，perfect(较难理解)

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> integers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                integers.add(treeNode.val);

                if (null != treeNode.left) queue.add(treeNode.left);
                if (null != treeNode.right) queue.add(treeNode.right);
            }

            if (ans.size() % 2 == 1) Collections.reverse(integers);
            ans.add(integers);
        }

        return ans;
    }
}
```

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> integers = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                if (ans.size() % 2 == 0) integers.addLast(treeNode.val);
                else integers.addFirst(treeNode.val);

                if (null != treeNode.left) queue.add(treeNode.left);
                if (null != treeNode.right) queue.add(treeNode.right);
            }

            ans.add(integers);
        }

        return ans;
    }
}
```

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int size = queue.size();

            // 从左到右打印
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                integers.add(treeNode.val);

                if (null != treeNode.left) queue.addLast(treeNode.left);
                if (null != treeNode.right) queue.addLast(treeNode.right);
            }
            ans.add(integers);

            // 从右到左打印
            size = queue.size();
            if (size == 0) break;
            integers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeLast();
                integers.add(treeNode.val);

                if (null != treeNode.right) queue.addFirst(treeNode.right);
                if (null != treeNode.left) queue.addFirst(treeNode.left);
            }
            ans.add(integers);
        }

        return ans;
    }
}
```





## 33. 二叉搜索树的后序遍历序列

> 一、递归（ok）:
> 1. 先以第一个大于根节点的节点为分界点，左侧作为左子树，右侧作为右子树(后序遍历)
> 2. 再判断右子树中的所有节点是否都大于根节点
> 3. 最后递归判断左右子树是否符合BST
>
> 二、迭代，还原二叉树的思路，使用辅助栈，倒叙遍历 postorder 数组，(较难理解)perfect

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if (null == postorder) return false;
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int m = i;
        // 左子树的所有节点都小于根节点
        while (postorder[m] < postorder[j]) m++;
        // 判断右子树是否都大于根节点
        int n = m;
        while (postorder[n] > postorder[j]) n++;
        return n == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
```

```java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        // 将原二叉树作为 root 的左子树
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
            	root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}
```





## 34. 二叉树中和为某一值的路径

> dfs + 回溯，需要特别注意的是列表的引用问题

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return ans;
    }

    private void recur(TreeNode root, int target) {
        // 因为节点中存在负数, 所以需要一直dfs遍历到叶子节点, 无法通过 target < 0 进行剪枝
        if (null == root) return;

        path.add(root.val);
        target -= root.val;

        // 是否为满足条件的路径, 从根 -> 叶子
        if (target == 0 && null == root.left && null == root.right)
            // 拷贝到新列表, 消除 path 列表因引用传递对 ans 中二级列表的影响
            ans.add(new ArrayList<>(path));

        // dfs递归左右子树
        recur(root.left, target);
        recur(root.right, target);

        // 回溯
        path.removeLast();
    }
}
```





## 35. 复杂链表的复制

> 第一次循环后，map 类似于一个缓存池，此时里面存放未初始化完成的 Node 节点；
> 第二次循环后，map 中的所有节点都已经初始化完成了。

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    // 深拷贝
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        // 先拷贝一份 Node 的 val 的 map
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node tmp = map.get(cur);
            tmp.next = map.get(cur.next);
            tmp.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
```





## 36. 二叉搜索树与双向链表

> 一、中序遍历获取节点顺序，再循环遍历调整前后指针，ok
>
> 二、通过中序遍历直接调整节点的左右指针，perfect

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        inOrder(root);
        
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                list.get(i).left = list.get(size - 1);
            } else {
                list.get(i).left = list.get(i - 1);
            }

            if (i == size - 1) {
                list.get(i).right = list.get(0);
            } else {
                list.get(i).right = list.get(i + 1);
            }
        }

        return list.get(0);
    }

    private void inOrder(Node root) {
        if (null == root) return;
        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }
}
```

```java
class Solution {
    // 解题的关键: head 节点的初始化以及使用 pre 变量保存前一个节点
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        dfs(root);

        // 调整第一个节点的前序指针以及最后一个节点的后序指针
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node root) {
        if (null == root) return;
        dfs(root.left);

        // 第一个节点时进行 head 变量的初始化(同时 pre 变量也会进行更新)
        if (null == head) {
            head = root;
        } else {  // 调整当前节点的前序指针以及 pre 节点的后序指针
            root.left = pre;
            pre.right = root;
        }
        pre = root;

        dfs(root.right);
    }
}
```





## 37. 序列化二叉树

> 通过层序遍历bfs编码二叉树，并通过该规则解码还原二叉树(关键是：二叉树的还原)，ok

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (null == remove) {
                sb.append("null,");
            } else {
                sb.append(remove.val).append(",");
                queue.add(remove.left);
                queue.add(remove.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] split = data.split(",");
        int len = split.length;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);

        for (int i = 1; i < len; i++) {
            TreeNode remove = queue.remove();
            if (!"null".equals(split[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                remove.left = node;
                queue.add(node);
            }
            i++;
            if (!"null".equals(split[i])) {
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                remove.right = node;
                queue.add(node);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```





## 38. 字符串的排列

> 使用回溯法实现元素的全排列, 同时剪掉重复结果集的情况，ok

```java
class Solution {
    List<String> list = new ArrayList<>();
    char[] cs = null;
    int len = 0;
    public String[] permutation(String s) {
        cs = s.toCharArray();
        len = cs.length;
        // 0 表示已经确定了全排列中的前 0 个元素, 即: 在搜索树上已经遍历了 0 层
        backtrace(0);
        return list.toArray(new String[0]);
    }

    private void backtrace(int i) {
        if (len - i <= 1) {
            list.add(new String(cs));
            return;
        }

        // 去重: "aab", 例如: 当确定全排列的第一个元素时, 如果循环到第二个 a, 那么它必定和第一个 a 与其他元素的交换做第一个元素的情况完全重复, 因此进行剪枝
        Set<Character> set = new HashSet<>();
        for (int j = i; j < len; j++) {
            if (set.contains(cs[j])) continue;
            set.add(cs[j]);

            // 使用回溯法实现全排列
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;

            backtrace(i + 1);

            cs[j] = cs[i];
            cs[i] = tmp;
        }
    }
}
```

