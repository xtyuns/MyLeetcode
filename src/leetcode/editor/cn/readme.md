# 剑指 offer

## 03. 数组中重复的数字

> 一、ArrayList.contains() 方法遍历nums，超时
> 二、HashSet 返回添加失败的元素，ok
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

