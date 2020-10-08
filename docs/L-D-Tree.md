# 二叉树问题  
BST: 二分查找树  
BT:  二叉树  
CBT: 完全二叉树  

LCA(Lowest Common Ancestor): 最近的公共祖先  

序列化和反序列化  
clone    

二叉树的左叶子、右叶子、最后一层的叶子、所有叶子节点的性质    
二叉树中左下角的节点   
二叉树的路径问题，必须经过跟节点/可不经过根节点，路径距离，路径上节点的和  


可以算出来的属性:  
高度  
整棵树的节点数  
左边的节点数  
右边的节点数  
树的parent节点(Map迭代过程中记录收集)  


二分查找数问题  

树的基本性质问题:  
遍历问题    
深度问题    
平衡性问题  


判断性质类问题:  
判断给定树是否是 BST
判断一颗树是否对称


思路:  
分析可能性；
包含当前节点、不包含；
定义消息体；
可能性中需要什么数据来进行确定具体的；


问题的分类:  
性质类, 可作为结构的工具方法类:  
求解深度相关  
二分搜索树相关  
平衡二叉树相关  
树的迭代相关  
节点的祖先问题  


操作类，特殊操作，多个树的操作:  
与其他数据结构结合: 根据有序数组构造 BST，链表构造出平衡二叉树, 二叉树转变成链表    
与数字结合: 将路径表示为
与其他算法结合  
两个树  
子树  
子序列  
转化  
路径问题  
  
  
实现:  
模拟为每个节点增加高度、最长路径属性...


**反转二叉树**

[226. Invert Binary Tree(easy)](https://leetcode.com/problems/invert-binary-tree/description/)

```
Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

思路: 遍历更换左右子树

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null)
        return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
}
```



**判断一颗树是否是另一颗树的子树**
[572. Subtree of Another Tree(Easy)](https://leetcode.com/problems/subtree-of-another-tree/)

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
```

思路: 遍历大树，从其任意一个节点出发的子树与将要匹配的子树进行匹配  

```java
public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null || t == null)
        return false;
    if (s.val == t.val)
        if (isSame(s, t))
            return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);  
}

private boolean isSame(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
        return true;
    if (t1 == null || t2 == null)     
        return false;
    if (t1.val != t2.val)
        return false;
    return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
}
```



**归并两颗树**
[617. Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)

```
Input:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
Output:
Merged tree:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
```

```java
public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null)
        return t2;
    if (t2 == null)
        return t1;
    TreeNode root = new TreeNode(t1.val + t2.val);    
    root.left = mergeTrees(t1.left, t2.left);
    root.right = mergeTrees(t1.right, t2.right);
    return root;
}
```


## 遍历相关

**判断两棵树是否相同**
[100. Same Tree(Easy)](https://leetcode.com/problems/same-tree/description/)

```
Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
```

思路：遍历查找比较

```java
public boolean isSameTree(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null)
        return true;
    if (root1 == null || root2 == null)
        return false;
    if (root1.val != root2.val)
        return false;
    return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
}
```



**先序遍历**

[144. Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        res.add(node.val);
        if (node.right != null)  // R -> L
            stack.push(node.right);
        if (node.left != null)
            stack.push(node.left);
    }
    return res;
}
```



**后续遍历**

[145. Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)

```java
public static final boolean GO = false;
public static final boolean PRINT = true;
private class Command {
    boolean op;
    TreeNode node;
    Command(boolean s, TreeNode node) {
        this.op = s;
        this.node = node;
    }
}

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null)
        return res;
    Stack<Command> stack = new Stack<>();
    stack.push(new Command(GO, root));
    while (!stack.isEmpty()) {
        Command cmd = stack.pop();
        if (cmd.op == PRINT)
            res.add(cmd.node.val);
        else {
            stack.push(new Command(PRINT, cmd.node));
            if (cmd.node.right != null)
                stack.push(new Command(GO, cmd.node.right));
            if (cmd.node.left != null)
                stack.push(new Command(GO, cmd.node.left));
            // reverse : L --> R --> D
        }
    }
    return res;
}
```



==层序遍历问题



**之字形打印二叉树**

[103. Binary Tree Zigzag Level Order Traversal(medium)](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

```java
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> q  = new LinkedList<>();
    q.offer(root);
    boolean isRight = true;
    while (!q.isEmpty()) {
        int cnt = q.size();
        List<Integer> level = new ArrayList<>();
        while (cnt -- > 0) {
            TreeNode cur = q.poll();
            level.add(cur.val);
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        if (isRight) {
            res.add(level);
        } else {
            Collections.reverse(level);
            res.add(level);
        }
        isRight = !isRight;
    }
    return res;
}
```



**按层反向遍历二叉树**

[107. Binary Tree Level Order Traversal II(easy)](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

```java
public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int cnt = q.size();
        List<Integer> level = new ArrayList<>();
        while (cnt -- > 0) {
            TreeNode front = q.poll();
            level.add(front.val);
            if (front.left != null)
                q.offer(front.left);
            if (front.right != null)
                q.offer(front.right);
        }
        res.add(level);
    }
    Collections.reverse(res);
    return res;
}
```



**二叉树的向右视图**

[199. Binary Tree Right Side View(medium)](https://leetcode.com/problems/binary-tree-right-side-view/)

```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```

思路： 二叉树层序遍历中，在迭代访问该层最后一个节点的时候就是最右节点，直接将其放入。

```java
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int cnt = queue.size();
        while (cnt -- > 0) {
            TreeNode front = queue.poll();
            if (cnt == 0)
                res.add(front.val);          // right edge to collect result
            if (front.left != null)
                queue.offer(front.left);
            if (front.right != null)
                queue.offer(front.right);
        }
    }
    return res;
}
```



**得到左下角的节点**
[513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)

```
Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:
7
```
思路: 层序遍历, 从右到左遍历, 则最后保存的便为左下角的节点

```java
public int findBottomLeftValue(TreeNode root) {
    TreeNode cur = null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        cur = queue.poll();
        if (cur.right != null)  // R -> L
            queue.offer(cur.right);
        if (cur.left != null)
            queue.offer(cur.left);
    }
    return cur.val;
}
```



**二叉树每层的平均值**
[637. Average of Levels in Binary Tree(Easy)](https://leetcode.com/problems/average-of-levels-in-binary-tree/description/)

```
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
```

思路： 层序遍历

```java
public List<Double> averageOfLevels(TreeNode root) {
    List<Double> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int cnt = queue.size();
        double sum = 0.0;
        for (int i = 0; i < cnt; i ++) {         
            TreeNode node = queue.poll();
            sum += node.val;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        res.add(sum / cnt);
    }
    return res;
}
```





==BST 与 中序遍历

**判断给定树是否是 BST**
[98. Validate Binary Search Tree(Medium)](https://leetcode.com/problems/validate-binary-search-tree/)

```
    5
   / \
  1   4
     / \
    3   6
Output: false
```

思路一: 中序遍历看是否有序

```java
public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    TreeNode pre = null;      
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        if (pre != null && cur.val < pre.val) return false;   // compare
        pre = cur;
        cur = cur.right;
    }
    return true;
}
```

思路二： todo





**寻找二叉查找树的第 k 个元素**
[230. Kth Smallest Element in a BST(Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

```
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up: 经常更改，如何处理
```

思路一： 简单的中序遍历实现

```java
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        if (-- k == 0) return cur.val;
        cur = cur.right;
    }
    throw new IllegalArgumentException();
}
```

思路二： 通过遍历模拟为树中每个节点添加其左子树的秩来实现

在左子树数量正好为 k - 1 时，此时恰好为该节点；

在左子树数量大于 k - 1时，此时需要查找的元素在左子树上，转化成在左子树上寻找第 k 个元素；

在左子树数量小于 k - 1 时，此时需要查找的元素在右子树上，转化成在右子树上寻找第 k - leftSize + 1 个元素；

```java
public int kthSmallest(TreeNode root, int k) {
    int leftSize = count(root.left);
    if (leftSize == k-1)
        return root.val;
    else if (leftSize > k-1)
        return kthSmallest(root.left, k);   
    else
        return kthSmallest(root.right, k - leftSize - 1);  
}

private int count(TreeNode node) {
    if (node == null) return 0;
    return 1 + count(node.left) + count(node.right);
}
```





**二叉树左叶子的总和**
[404. Sum of Left Leaves(Easy)](https://leetcode.com/problems/sum-of-left-leaves/)

```
    3
   / \
  9  20
    /  \
   15   7
values 9 and 15 respectively. Return 24.
```

思路： 通过遍历寻找到左叶子，之后加上左叶子的值，同时加上对应右子树上所有的左叶子值

```java
public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
        return 0;
    if (isLeaf(root.left))  // meet
        return root.left.val + sumOfLeftLeaves(root.right);
    return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);  
}
private boolean isLeaf(TreeNode node) {
    if (node == null)
        return false;
    return node.left == null && node.right == null;
}
```



**在二叉查找树中查找两个节点之差的最小绝对值**
[530. Minimum Absolute Difference in BST(easy)](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

```
Input:

   1
    \
     3
    /
   2
Output:
1
```

思路: 通过中序遍历，在有序时求解两者的差值即可。

```java
private int minDiff = Integer.MAX_VALUE;
private TreeNode pre = null;

public int getMinimumDifference(TreeNode root) {
    inOrder(root);
    return minDiff;
}
private void inOrder(TreeNode node) {
    if (node == null) return;
    inOrder(node.left);
    if (pre != null)
        minDiff = Math.min(minDiff, node.val - pre.val);   
    pre = node;
    inOrder(node.right);
}
```



**二叉搜索树中是否有两个节点值等于给定的数**
[653. Two Sum IV - Input is a BST(easy)](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/)

```
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

思路一: 转换成数组求解，双指针处理

```java
public boolean findTarget(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    int i = 0, j = list.size() - 1;
    while (i < j) {
        int sum = list.get(i) + list.get(j);
        if (sum == k)
            return true;
        else if (sum < k)
            i ++;
        else
            j --;
    }
    return false;
}
private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) return;
    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
}
```



==间隔遍历

**小偷偷房子,不可偷连续的两个房子**
[337. House Robber III(Medium)](https://leetcode.com/problems/house-robber-iii/)

```
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
```

思路一： 两者可能的情况

放弃抢当前层，从而抢其下面的两个房子；

抢当前层，并抢其下两层的房子 LL, LR, RL, RR ；

徐泽两种情况的最大值作为结果

```java
public int rob(TreeNode root) {
    if (root == null)
        return 0;
    int val1 = root.val 
        + (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0)
            + (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);  
    int val2 = rob(root.left) + rob(root.right);
    return Math.max(val1, val2);
}
```

改进一: 通过记忆化搜索实现

借助 Map 来记录键为 TreeNode 的情况

```java
private Map<TreeNode, Integer> memo;

public int rob(TreeNode root) {
    memo = new HashMap<>();
    return tryRob(root);
}

private int tryRob(TreeNode root) {
    if (root == null)
        return 0;
    if (root.left == null && root.right == null)
        return root.val;
    if (memo.containsKey(root))
        return memo.get(root);
    int val1 = root.val + (root.left != null ? tryRob(root.left.left) + tryRob(root.left.right) : 0)
            + (root.right != null ? tryRob(root.right.left) + tryRob(root.right.right) : 0);
    int val2 = tryRob(root.left) + tryRob(root.right);
    int val =  Math.max(val1, val2);
    memo.put(root, val);
    return val;
}
```

改进二：通过 DP 记录实现


## 高度路径问题

**二叉树的最大深度**
[104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)

```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return 1 + Math.max(leftDepth, rightDepth);
}
```



**判断一个树是否是平衡树**
[110. Balanced Binary Tree(easy)](https://leetcode.com/problems/balanced-binary-tree/)

```
Given the following tree [1,2,2,3,3,null,null,4,4]:
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
```

思路： 每次在计算到节点高度时，只需要知道其左右孩子的高度即可，而函数的语义便是求解高度的；

```java
private boolean isBalanced = true;

public boolean isBalanced(TreeNode root) {
    height(root);
    return isBalanced;
}

private int height(TreeNode root) {
    if (root == null) return 0;
    int left = height(root.left);
    int right = height(root.right);
    if (Math.abs(left - right) > 1)  // find by node attribute
        isBalanced = false;
    return 1 + Math.max(left, right);
}
```



**计算完全二叉树的节点个数**
[222. Count Complete Tree Nodes(Medium)](https://leetcode.com/problems/count-complete-tree-nodes/)

```
Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
```

思路一： 完全二叉树的情况下若其右边界的长度与左边界的长度正好相等，此时便能够确定其为一颗满二叉树，直接根据边界长度返回最终的结果；若不是满二叉树则不断递归向下知道找到其为一颗满二叉树返回结果；空树为一颗满二叉树；

```java
public int countNodes(TreeNode root) {
    int leftDepth = leftDepth(root);
    int rightDepth = rightDepth(root);
    if (leftDepth == rightDepth)     // meet condition
        return (1 << leftDepth) - 1;
    return 1 + countNodes(root.left) + countNodes(root.right);
}

private int leftDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
        depth ++;
        node = node.left;
    }
    return depth;
}

private int rightDepth(TreeNode node) {
    int depth = 0;
    while (node != null) {
        depth ++;
        node = node.right;
    }
    return depth;
}
```

思路二： 每次求解最左路径

todo



**二叉树的维度_两个节点间最长的路径可不经过根节点**
[543. Diameter of Binary Tree(Easy)](https://leetcode.com/problems/diameter-of-binary-tree/)
```
找出二叉树最大的维度
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
```

思路一: 等价于为每个节点添加 "diameter" 属性: 子树中相距最远的两个节点之间边的个数
相距最远等价于高度，此是高度与边数的一定等价特性

```java
int max = 0;

public int diameterOfBinaryTree(TreeNode root) {
    height(root);
    return max;
}

private int height(TreeNode node) {
    if (node == null)
        return 0;
    int left = height(node.left);
    int right = height(node.right);
    max = Math.max(max, left + right);  // collect
    return 1 + Math.max(left, right);
}
```



**二叉树的最大路径和,路径为任意节点开始，任意节点结束**
[124. Binary Tree Maximum Path Sum(hard)](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

```
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
```

思路: 该路径路径即为左右子树节点最长的路径中加上当前节点形成的;

语义： 当前节点作为根节点**向下**的最大路径和；

```java
private int max = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
}

private int helper(TreeNode node) {
    if (node == null)
        return 0;
    int left = Math.max(0, helper(node.left));
    int right = Math.max(0, helper(node.right));

    max = Math.max(max, node.val + left + right);       
    return node.val + Math.max(left, right);            
}
```



**可不经过根节点的路径中最长的都是相同数的长度**
[687. Longest Univalue Path(Easy)](https://leetcode.com/problems/longest-univalue-path/)

```
Input:
              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2
```
语义： 以当前节点为根节点向下相同节点的最大个数
```java
int maxPathLen = 0;

public int longestUnivaluePath(TreeNode root) {
    if (root == null) return 0;
    getMaxDuplicationPathLength(root);
    return maxPathLen;

}

private int getMaxDuplicationPathLength(TreeNode node) {
    if (node == null)
        return 0;

    int leftLen = getMaxDuplicationPathLength(node.left);
    int rightLen = getMaxDuplicationPathLength(node.right);
    int left = (node.left != null && node.left.val == node.val ? leftLen + 1 : 0);
    int right = (node.right != null && node.right.val == node.val ? rightLen + 1: 0);
    maxPathLen = Math.max(maxPathLen, left + right);
    return Math.max(left, right);
}
```


## 结构**

**根据二叉树的前序和后续遍历构造出二叉树**

[105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

```html
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
```

```java
Map<Integer, Integer> inorderNumIndex = new HashMap<>();

public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) return null;

    for (int i = 0; i < inorder.length; i ++)
        inorderNumIndex.put(inorder[i], i);
    return buildTree(preorder, 0, preorder.length-1, 0);
}

private TreeNode buildTree(int[] preorder, int preL, int preR, int inL) {
    if (preL > preR) return null;

    TreeNode root = new TreeNode(preorder[preL]);
    int index = inorderNumIndex.get(root.val);
    int leftSize = index - inL;
    root.left = buildTree(preorder, preL + 1, preL + leftSize, inL);
    root.right = buildTree(preorder, preL+leftSize+1, preR, index + 1);
    return root;
}
```



**根据中序和后续遍历构造二叉树**

[106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

```html
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
```

```java
Map<Integer, Integer> inorderNumIndex = new HashMap<>();
public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i ++)
        inorderNumIndex.put(inorder[i], i);
    return buildTree(0, postorder, 0, postorder.length-1);
}

private TreeNode buildTree(int inL, int[] postorder, int postL, int postR) {
    if ( postL > postR) return null;

    TreeNode root = new TreeNode(postorder[postR]);
    int index = inorderNumIndex.get(root.val);
    int leftSize = index - inL;
    root.left = buildTree(inL, postorder, postL, postL+leftSize-1);
    root.right = buildTree(index+1, postorder, postL+leftSize, postR - 1);
    return root;
}
```


## 两颗树|子树

**判断一颗树是否对称**
[101. Symmetric Tree(Easy)](https://leetcode.com/problems/symmetric-tree/description/)

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
true
```

思路： {LL, RR}, {LR, RL}

```java
public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isSymmetric(root.left, root.right);
}

private boolean isSymmetric(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)
        return true;
    if (t1 == null || t2 == null)
        return false;
    if (t1.val != t2.val)
        return false;
    return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);   
}
```


## LCA

**二叉查找树的最近公共祖先**
[235. Lowest Common Ancestor of a Binary Search Tree(easy)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)

```
        _______6______
      /                \
  ___2__             ___8__
 /      \           /      \
0        4         7        9
        /  \
       3   5

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
Another example is LCA of nodes 2 and 4 is 2.
```

思路： BST 节点有序，可以很容易的判断两个节点是否都在某一颗树上；

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    if (p.val < root.val && q.val < root.val)
        return lowestCommonAncestor(root.left, p, q);
    if (p.val > root.val && q.val > root.val)
        return lowestCommonAncestor(root.right, p, q);
    return root;
}
```



**二叉树的最近公共祖先**
[236. Lowest Common Ancestor of a Binary Tree(Medium)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

```
       _______3______
      /              \
  ___5__           ___1__
 /      \         /      \
6        2       0        8
        /  \
       7    4
Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the binary tree.
```

思路一: 记录每个节点的父亲节点

```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    parent.put(root, null);

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {  
        root = stack.pop();
        if (root.right != null) {
            parent.put(root.right, root);                
            stack.push(root.right);
        }
        if (root.left != null) {
            parent.put(root.left, root);
            stack.push(root.left);
        }
    }

    Set<TreeNode> pAncestors = new HashSet<>();
    while (p != null) {
        pAncestors.add(p);
        p = parent.get(p);
    }
    while (!pAncestors.contains(q))
        q = parent.get(q);
    return q;
}
```

思路二: 递归性质??



思路三: 找到两条到达指定 p, q 节点的路径
转换成在 两条链表中求公共交点问题





**序列化和反序列化二叉树**
[297. Serialize and Deserialize Binary Tree(Hard)](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

```
    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
```

思路： 对于 NULL 也作为一个节点进行遍历添加进入到返回的序列化字符串中；反序列化执行相同的逻辑；

```java
private static final String SEPARATOR = " ";
private static final String NULL = "#";
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        TreeNode cur = q.poll();
        if (cur == null) {
            sb.append(NULL + SEPARATOR);
            continue;
        }
        sb.append(cur.val + SEPARATOR);
        q.offer(cur.left);
        q.offer(cur.right);
    }
    return sb.toString();
}

public TreeNode deserialize(String data) {
    String[] vals = data.split(SEPARATOR);
    int index = 0;
    TreeNode root = geneTreeNode(vals[index ++]);
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        TreeNode cur = q.poll();      
        if (cur == null) continue;
        cur.left = geneTreeNode(vals[index ++]);
        cur.right = geneTreeNode(vals[index ++]); // link
        q.offer(cur.left);
        q.offer(cur.right);
    }
    return root;
}

private TreeNode geneTreeNode(String val) {
    if (val.equals(NULL))                    
        return null;
    return new TreeNode(Integer.valueOf(val));
}
```

思路二： 通过 前序遍历来实现，效率更高??





**非负节点值只含有0或2个孩子节点,2个时其比孩子节点小的树中找出第二小的数**
[671. Second Minimum Node In a Binary Tree(Easy)](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/)

```
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Input:
    2
   / \
  2   2

Output: -1
```

思路： 

```java
public int findSecondMinimumValue(TreeNode root) {
    if (root == null)
        return -1;
    if (root.left == null && root.right == null)
        return -1;

    int leftVal = root.left.val;
    int rightVal = root.right.val;
    if (leftVal == root.val)
        leftVal = findSecondMinimumValue(root.left);     // skip duplication or leaf
    if (rightVal == root.val)
        rightVal = findSecondMinimumValue(root.right);

    if (leftVal != -1 && rightVal != -1) 
        return Math.min(leftVal, rightVal);    
    return leftVal != -1 ? leftVal : rightVal;   // one or all duplication with current node
}
```



**二叉树转变成特定线性的单链表**
[114. Flatten Binary Tree to Linked List(Medium)](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

```
    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

★☆☆

思路一:  这道题看了hint，说每个node的右节点都是相应先序遍历中它的下一个节点。
 所以我的思路是先把先序遍历的node顺序搞出来，然后对于这里面的每一个节点，只需要做两个操作：

  1. node.left = None
  2. node.right = 相应先序遍历中node的下一个节点

```java
public void flatten(TreeNode root) {
    if (root == null)
        return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode pre = new TreeNode(-1);
    while (!stack.isEmpty()) {
        TreeNode cur = stack.pop();
        pre.right = cur;
        pre.left = null;      // single list
        pre = cur;
        if (cur.right != null)
            stack.push(cur.right);
        if (cur.left != null)
            stack.push(cur.left);
    }
}
```



**把二叉查找树每个节点的值都加上比它大的节点的值**
[538. Convert BST to Greater Tree(Easy)](https://leetcode.com/problems/convert-bst-to-greater-tree/description/)

```
Input: 
              5
            /   \
           2     13
Output: 
             18
            /   \
          20     13
```

思路: 控制实现 BST 的逆序遍历，保存逆序遍历中之前的节点和，当前节点即为该路径和

LDR 正序 ⇒ RDL 逆序；

```java
int sum = 0;

public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;
    traverseRDL(root);
    return root;
}

private void traverseRDL(TreeNode node) {
    if (node == null)
        return;
    traverseRDL(node.right);
    sum += node.val;
    node.val = sum;
    traverseRDL(node.left);
}
```

## 其他

### BST 相关问题

**从有序数组中构造二叉查找树**
[108. Convert Sorted Array to Binary Search Tree(Easy)](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)


```
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
```

思路： 不断选择中间值作为根节点, 之后将数组对半划分不断重复即可

```java
public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;
    return buildBSTFromArray(nums, 0, nums.length - 1);
}

private TreeNode buildBSTFromArray(int[] nums, int l, int r) {
    if (l > r) return null;
    int mid = l + (r - l) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = buildBSTFromArray(nums, l, mid-1);
    root.right = buildBSTFromArray(nums, mid + 1, r);
    return root;
}
```



**从二叉搜索树中删除一个节点**
[450. Delete Node in a BST(Medium)](https://leetcode.com/problems/delete-node-in-a-bst/description/)

```
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
```

思路一: 找到删除节点的后继节点，使用其来代替当前节点，之后借助函数的语义来删除右子树上对应的后继节点  

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
        return null;
    if (key < root.val)
        root.left = deleteNode(root.left, key);
    else if (key > root.val)
        root.right = deleteNode(root.right, key);
    else {                   // truncate
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        TreeNode succ = minimum(root.right);
        root.val = succ.val;
        root.right = deleteNode(root.right, root.val);   
    }
    return root;
}

private TreeNode minimum(TreeNode node) {
    if (node.left == null)
        return node;
    return minimum(node.left);
}
```


思路二: 找到后继节点，使用后继节点来代替删除节点

```java
public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
        return null;
    if (key < root.val) {
        root.left = deleteNode(root.left, key);
        return root;
    }
    else if (key > root.val) {
        root.right = deleteNode(root.right, key);
        return root;
    }
    else {  
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;   
            return rightNode;
        }
        if (root.right == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }
         TreeNode succ = minimum(root.right);
         succ.right = deleteMin(root.right);
         succ.left = root.left;
         root.left = root.right = null; 
         return succ;
    }
}

private TreeNode deleteMin(TreeNode node) {
    if (node.left == null) { 
        TreeNode rightNode = node.right;
        node.right = null;
        return rightNode;
    }
    node.left = deleteMin(node.left);    
    return node;
}
```



**寻找二叉查找树中出现次数最多的值**
[501. Find Mode in Binary Search Tree(Easy)](https://leetcode.com/problems/find-mode-in-binary-search-tree/)

注: 答案可能不止一个，也就是有多个值出现的次数一样多。
```
Given BST [1,null,2,2],

   1
    \
     2
    /
   2

return [2].
```
思路: 通过一个 list 记录当前频次最大的节点中保存的值, 可能随着遍历的过程中不断的清空, 之后为其添加元素的操作。类似于转换成在有序数组中寻找词频最高的所有元素

```java
private int curCnt=1;
private int maxCnt=1;
private TreeNode pre;   
public int[] findMode(TreeNode root) {
    List<Integer> list = new ArrayList<>();   // record maxCnt val
    inOrder(root, list);
    return list.stream().mapToInt(p -> p.intValue()).toArray();
}

// inorder is ordered 1,1,1,2,2,3,4,5,5,5
private void inOrder(TreeNode node, List<Integer> list) {
    if (node == null) return;
    inOrder(node.left, list);
    if (pre != null)
        curCnt = (pre.val == node.val ? curCnt + 1 : 1);
    pre = node;
    if (maxCnt < curCnt) {
        list.clear();
        list.add(node.val);
        maxCnt = curCnt;
    } else if (curCnt == maxCnt) {   
        list.add(node.val);
    }
    inOrder(node.right, list);
}
```



**修剪二叉查找树，只保留值在 L ~ R 之间的节点**
[669. Trim a Binary Search Tree(Easy)](https://leetcode.com/problems/trim-a-binary-search-tree/)

```
Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1
```

思路： 类似删除的逻辑，进行对应的拼接

```java
public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null)
        return null;
    if (root.val < L)
        return trimBST(root.right, L, R); 
    if (root.val > R)
        return trimBST(root.left, L, R);
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
}
```







**给定 BST 的中序遍历可以构成多少不同的二叉树**
[96. Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)


思路一: 
 [衔接](https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i))

 首先明确n个不等的数它们能构成的二叉搜索树的种类都是相等的。

 而且1到n都可以作为二叉搜索树的根节点，当k是根节点时，它的左边有k-1个不等的数，它的右边有n-k个不等的数。

 以k为根节点的二叉搜索树的种类就是左右可能的种类的乘积。

 用递推式表示就是 h(n) = h(0)*h(n-1) + h(1)*h(n-2) + ... + h(n-1)h(0) (其中n>=2) ，其中h(0)=h(1)=1，因为0个或者1个数能组成的形状都只有一个。从1到n依次算出h(x)的值即可。


 G(n): 长度为n的序列的唯一BST数量
 F(i, n), 1 <= i <= n: 唯一BST的数量，其中数字i是BST的根，序列范围从1到n。

 G(n) = F(1, n) + F(2, n) + ... + F(n, n).

 F(i, n) = G(i-1) * G(n-i)	1 <= i <= n.
 表示以i作为根节点, 其左边在[1...i-1之间继续选择, 右边在 i,...n 之间选择, 左边从i-1个、右边从n-i个元素中选择作为根节点

 G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)

```java
int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <=n; i ++) {
        for (int j = 1; j <= i; j ++) {
            dp[i] = dp[i] + dp[j-1] * dp[i - j]; 
        }
    }
    return dp[n];
}
```

思路二:  此外这其实就是一个卡特兰数，可以直接用数学公式计算，不过上面的方法更加直观一些。

```java
int numTrees(int n) {
    long ans = 1;
    for (int i = n + 1; i <= 2 * n; i++) {
        ans = ans * i / (i - n);
    }
    return (int) (ans / (n + 1));
}
```



### 路径问题(dfs)

**从根节点到叶子节点的最小路径长度**
[111. Minimum Depth of Binary Tree(easy)](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

思路一: 通过递归实现,每进入一层便将层数加一,返回值即为当前的
得到左右子树的最小路径长度,在都存在的情况下选取最小的即可,存在一个的情况下选择一个

```java
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    if (left == 0 || right == 0)       
        return left + right + 1;
    return 1+ Math.min(left, right);     
}
```


思路二: 通过层序遍历实现

```java
public int minDepth(TreeNode root) {
    if (root == null)
        return 0;
    int depth = 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        int cnt = q.size();
        depth ++;
        while (cnt -- > 0) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null)
                return depth;
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
    }
    throw new RuntimeException();
}
```



**是否存在一条路径和是否等于一个数**
[112. Path Sum(Easy)](https://leetcode.com/problems/path-sum/description/)


```
 Given the below binary tree and sum = 22,
     5
    / \
   4   8
  /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
```

思路一: 前序遍历方式,每遍历到一个节点减小树的规模同时减少路径和的总值

```java
public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
        return false;
    if (root.left == null && root.right == null)
        return root.val == sum;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
}
```



**找出所有路径和为给定数的路径**
[113. Path Sum II(Medium)](https://leetcode.com/problems/path-sum-ii/)

```
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:
[
   [5,4,11,2],
   [5,8,4,5]
]
```
思路: 在遍历的过程中收集结果,不断缩小树的规模以及求解的目标和, 附带回溯功能;
在遍历到叶子节点时需要特殊处理控制,处理回退和结果加入判断;

```java
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;
    backtracking(root, sum, new ArrayList<>(), res);
    return res;
}

private void backtracking(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
    if (root.left == null && root.right == null) {    
        if (sum - root.val == 0) {
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        return ;
    }
    path.add(root.val);
    if (root.left != null)
        backtracking(root.left, sum - root.val, path, res);
    if (root.right != null)
        backtracking(root.right, sum - root.val, path, res);
    path.remove(path.size() - 1);
}
```



**二叉树路径表示数字，求解总和**
[129. Sum Root to Leaf Numbers(Medium)](https://leetcode.com/problems/sum-root-to-leaf-numbers/)


```
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Therefore, sum = 12 + 13 = 25.
```

思路: DFS, 收集所有拼接的字符结果,之后进行累加

```java
public int sumNumbers(TreeNode root) {
    if (root == null) return 0;

    List<String> paths = new ArrayList<>();
    dfs(root, "", paths);
    return paths.stream().mapToInt(p -> Integer.parseInt(p)).sum();
}

private void dfs(TreeNode root, String path, List<String> paths) {
    if (root.left == null && root.right == null) {
        paths.add(path + root.val);
        return;
    }
    if (root.left != null)
        dfs(root.left, path + root.val, paths);
    if (root.right != null)
        dfs(root.right, path + root.val, paths);
}
```



**求出二叉树的所有路径**
[257. Binary Tree Paths(easy)](https://leetcode.com/problems/binary-tree-paths/description/)

```
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]
```

```java
public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if (root == null) return paths;

    dfs(root, "", paths);
    return paths;
}

void dfs (TreeNode root, String path, List<String> paths) {
    if  (root.left == null && root.right == null) {
        paths.add(path + root.val);    
        return;
    }
    if (root.left != null)
        dfs(root.left, path + root.val + "->", paths);
    if (root.right != null)
        dfs(root.right, path + root.val + "->", paths);
}
```



**任意节点开始向下节点结束路径和为给定数的可能数**
[437. Path Sum III(easy)](https://leetcode.com/problems/path-sum-iii/description/)

```
      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

思路: 最后结果为从根节点作为开始节点向下寻找+不使用根节点而加上左右子树相同逻辑的总可能数量

注: 在求解某个节点向下时因为负数问题可能在达到要求后仍然有符合要求的

```java
public int pathSum(TreeNode root, int sum) {
    if (root == null) return 0;

    int res = 0;
    res += getPathCountFromNode(root, sum);
    res += pathSum(root.left, sum);
    res += pathSum(root.right, sum);
    return res;
}

private int getPathCountFromNode(TreeNode node, int target) {
    if (node == null)
        return 0;
    int res = 0;
    if (node.val == target)  // can continue
        res += 1;
    res += getPathCountFromNode(node.left, target - node.val);
    res += getPathCountFromNode(node.right, target - node.val);
    return res;
}
```
