# 动态规划
思路:  
找状态和选择  
穷举 + 备忘录  
状态转移方程  

搞清楚返回值、方法的递归语义

抽取出有效性的方法

```
boolean inArea(int m, int n, int r, int r);
boolean isValid(String str, int i, int j);
```

带有各种限定条件时候，注意问题的退化，简化问题


运筹学上最优方法  


**动态规划算法的时间复杂度就是子问题个数 × 函数本身的复杂度**。

子问题个数也就是不同状态组合的总数

  

丑树  
LCS(Longest Common Subsequence):  最长公共子序列  
股票问题  
0-1 背包问题  
抢房子问题    
动态规划处理正则 `.`, `*` 进行字符匹配    
博弈问题, 都找出最优的方案为前提  


子序列问题  

  

子数组问题、子序列、子串  




状态机(DP Table)  
状态转移图      



暴力的递归解法 -> 带备忘录的递归解法 -> 迭代的动态规划解法. 

思考过程:  找到状态和选择 -> 明确 dp 数组/函数的定义 -> 寻找状态之间的关系。  


`dp[i]` 的语义

以 `nums[i]` 为结尾的最大子数组和/最长递增子序列为 `dp[i]`」


判断:  

第一个与之后的多个进行相同的逻辑判断  


最直观的应该是随便假设一个输入，然后画递归树，肯定是可以发现相同节点的。这属于定量分析，其实不用这么麻烦，下面我来教你定性分析，一眼就能看出「重叠子问题」性质。


定义 dp 数组保存，对于边界 `-1`, `0` 基本的 case 进行额外的处理




**丑数II**

[264. Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)

```
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:
```

思路： 

```java
public int nthUglyNumber(int n) {

    int[] dp = new int[n];
    dp[0] = 1;
    int index2=0, index3=0, index5=0;     // index as index, not value
    for (int i = 1; i < n; i++) {
        // cur
        dp[i] = Math.min(dp[index2]*2, Math.min(dp[index3]*3, dp[index5]*5));
        while (dp[index2]*2 <=dp[i])
            index2 ++;
        while (dp[index3]*3 <= dp[i])
            index3 ++;
        while (dp[index5]*5 <= dp[i])
            index5 ++;
    }
    return dp[n-1];
}
```



**超级丑数**

[313. Super Ugly Number](https://leetcode.com/problems/super-ugly-number/)

```
Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.
```

```java
public int nthSuperUglyNumber(int n, int[] primes) {
    int[] idx = new int[primes.length];
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i ++) {            // from 1 begin
        dp[i] = Integer.MAX_VALUE;
        for (int j = 0; j < primes.length; j ++) {
            dp[i] = Math.min(dp[i], primes[j] * dp[idx[j]]);
        }
        for (int j = 0; j < primes.length; j ++) {
            while (dp[idx[j]] * primes[j] <= dp[i])
                idx[j] ++;
        }
    }
    return dp[n-1];
}
```



## 分割整数

// TODO


## 0-1 背包

完全背包：物品数量为无限个

多重背包：物品数量有限制

多维费用背包：物品不仅有重量，还有体积，同时考虑这两种限制

其它：物品之间相互约束或者依赖



## 正则表达式

关键是星号「*」的实现需要用到动态规划技巧




## 股票买卖问题

利用「状态」进行穷举



具体到每一天，看看总共有几种可能的「状态」，再找出每个「状态」对应的「选择」。

**这个问题的「状态」有三个**，第一个是天数，第二个是允许交易的最大次数，第三个是当前的持有状态（即之前说的 rest 的状态，我们不妨用 1 表示持有，0 表示没有持有）。然后我们用一个三维数组就可以装下这几种状态的全部组合：



```
dp[i][k][0 or 1]
0 <= i <= n-1, 1 <= k <= K
n 为天数，大 K 为最多交易数
此问题共 n × K × 2 种状态，全部穷举就能搞定。


for 0 <= i < n:
    for 1 <= k <= K:
        for s in {0, 1}:
            dp[i][k][s] = max(buy, sell, rest)
```

而且我们可以用自然语言描述出每一个状态的含义，比如说 `dp[3][2][1]` 的含义就是：今天是第三天，我现在手上持有着股票，至今最多进行 2 次交易。再比如 `dp[2][3][0]` 的含义：今天是第二天，我现在手上没有持有股票，至今最多进行 3 次交易。很容易理解，对吧？

我们想求的最终答案是 dp[n - 1][K][0]，即最后一天，最多允许 K 次交易，最多获得多少利润。读者可能问为什么不是 dp[n - 1][K][1]？因为 [1] 代表手上还持有股票，[0] 表示手上的股票已经卖出去了，很显然后者得到的利润一定大于前者。






# 搜索问题
二分图
拓扑排序
并查集

0. 参数准备
通过定义 `direction[]` 控制搜索查找的方向  
一般为四方向、八方向    
  
1. 搜索记录和去重  
一般有一个数组来表示下一步可能的搜索路径  
一个 index 记录从哪个索引开始是可能的或是除了当前 index 其他都是可能的搜索路径  

矩阵中的 dfs ，涉及到处理矩阵的边处理  
两次遍历  

```
// first row AND last row
for (int i = 0; i < m; i++) {              
    dfs(board, i, 0, m, n);
    dfs(board, i, n - 1, m, n);
}

// left col AND right col
for (int i = 0; i < n; i++) {               
    dfs(board, 0, i, m, n);
    dfs(board, m - 1, i, m, n);
}
```

四次边界遍历  
```
for (int i = 0; i != n - 1; i ++)                        // traverse four edges
    floodfill(board, 0, i, m, n, visited);
for (int i = 0; i != m-1; i ++)
    floodfill(board, i, n-1, m, n, visited);
for (int i = n-1; i != 0; i --)
    floodfill(board, m-1, i, m, n, visited);
for (int i = m-1; i != 0; i --)
    floodfill(board, i, 0, m, n, visited);
```





## 排列组合
找出全排列  
给定集合进行组合  


下一个大于当前的排列  

组合和问题:  
数据集无重复原始、可使用多次  

  

  

### 排列
不含有重复元素数组的全排列  

排列的终止条件: 对应的排列到数组的尾部    

  


通过交换数组或是集合中的元素来实现  

  

  

对重复元素的处理:  
进行收集数据前对数据排序  
使用 Set 判断加入的元素是否在当前的排列中存在  

  

### 集合问题
子集问题    





宏观语义
微观执行
选择 | 限制 | 结束
收集可能性问题

  

排列问题  
组合问题  
可能性问题  



可达性问题： 



查找 | 



一些常错的点：

自定义结构时，未定义比较器 | 未定义自然顺序

在使用自定义结构配合容器时，未与容器访问方法一致



拼写的变量名错误





kth 问题：

选出词频最高的 k 个元素

在排序



**跳游戏**

[55. Jump Game](https://leetcode.com/problems/jump-game/)

给定非负整数数组，值代表可以走的最大步数
判断是否可以走到头

```html
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```

```java
public boolean canJump(int[] nums) {
    if (nums.length < 2)
        return true;
    int maxReachable = 0;
    for (int i = 0; i < nums.length; i ++) {
        if (i > maxReachable)
            return false;
        maxReachable = Math.max(maxReachable, i + nums[i]);
    }
    return true;
}
```





排列组合

**下一个大于当前的排列**

[31. Next Permutation](https://leetcode.com/problems/next-permutation)

```html
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
```

```java
public void nextPermutation(int[] nums) {
    int N = nums.length;
    for (int i = N-1; i >=1; i --) {
        if (nums[i-1] < nums[i]) {  // head → tail    need replace [i-1] position value
            int minGreaterIndex = minGreaterIndex(nums, i, N - 1, nums[i - 1]);
            swap(nums, i - 1, minGreaterIndex);
            Arrays.sort(nums, i, N);
            return;
        }
    }
    reverse(nums);
}
private int minGreaterIndex(int[] nums, int lo, int hi, int key) {
    for (int i = hi; i >= lo; i --) {     // use [lo, hi] ↓ property
        if (nums[i] > key) {
            return i;
        }
    }
    return -1;
}
```





**无重复可使用多次组合和为给定数的所有组合**

[39. Combination Sum](https://leetcode.com/problems/combination-sum)

```html
Input: candidates = [2,3,6,7], target = 7,
A solution15 set is:
[
  [7],
  [2,2,3]
]

Input: candidates = [2,3,5], target = 8,
A solution15 set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    Arrays.sort(candidates);
    findCombinationSum(candidates, target, 0, new ArrayList<>(), combinations);
    return combinations;
}

private void findCombinationSum(int[] candidates, int target, int start, List<Integer> curCombination, List<List<Integer>> combinations) {
    if (target == 0) {
        combinations.add(new ArrayList<>(curCombination));
        return;
    }
    for (int i = start; i < candidates.length; i ++) {    // cur can select [start] ~ [N-1]
        if (candidates[i] > target ) continue;     // use for punning
        curCombination.add(candidates[i]);    // collection current selected result
        findCombinationSum(candidates, target - candidates[i], i, curCombination, combinations);
        curCombination.remove(curCombination.size() - 1);
    }
}
```





**带有重复元素组合和为给定数所有唯一总结果**

[40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)

```java
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    if (candidates == null || candidates.length == 0)
        return combinations;
    Arrays.sort(candidates);
    findCombinationSum(candidates, target, 0, new ArrayList<>(), combinations);
    return combinations;
}

private void findCombinationSum(int[] candidates, int target, int start, List<Integer> curCombination, List<List<Integer>> combinations) {
    if (target == 0) {
        combinations.add(new ArrayList<>(curCombination));
        return;
    }
    for (int i = start; i < candidates.length; i ++) {
        if (i != start && candidates[i] == candidates[i - 1]) continue;
        if (target - candidates[i] < 0) continue;
        curCombination.add(candidates[i]);
        findCombinationSum(candidates, target - candidates[i], i + 1, curCombination, combinations);
        curCombination.remove(curCombination.size() - 1);
    }
}
```





**不含有重复元素的数组的全排列**

[46. Permutations](https://leetcode.com/problems/permutations/description/)

```html
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```



```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    if (nums == null || nums.length == 0)
        return permutations;
    findAllPermutations(nums, new boolean[nums.length], new ArrayList<>(), permutations);
    return permutations;
}

private void findAllPermutations(int[] nums, boolean[] visited, List<Integer> curPermutation, List<List<Integer>> permutations) {
    if (curPermutation.size() == nums.length) {
        permutations.add(new ArrayList<>(curPermutation));
        return;
    }
    for (int i = 0; i < nums.length; i ++) {
        if (visited[i]) continue;
        curPermutation.add(nums[i]);
        visited[i] = true;
        findAllPermutations(nums, visited, curPermutation, permutations);
        curPermutation.remove(curPermutation.size() - 1);
        visited[i] = false;
    }
}
```







**含有重复元素的全排列**

[47. Permutations II](https://leetcode.com/problems/permutations-ii/)

```html
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```

```java
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>();
    Arrays.sort(nums);
    findPermutations(nums, 0, new boolean[nums.length], new ArrayList<>(), permutations);
    return permutations;
}

private void findPermutations(int[] nums, int curIndex, boolean[] visited, List<Integer> curPermutation, List<List<Integer>> permutations) {
    if (curIndex == nums.length) {
        permutations.add(new ArrayList<>(curPermutation));
        return;
    }
    for (int i = 0; i < nums.length; i ++) {
        if (visited[i]) continue;
        if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
        curPermutation.add(nums[i]);
        visited[i] = true;
        findPermutations(nums, curIndex + 1, visited, curPermutation, permutations);
        curPermutation.remove(curPermutation.size() - 1);
        visited[i] = false;
    }
}
```





**无重复集合中的子集**

[78. Subsets](https://leetcode.com/problems/subsets/)

```html
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
```

```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    for (int sz = 0; sz <= nums.length; sz ++) {
        findSubsetsInSize(nums, sz, 0, subset, subsets);
    }
    return subsets;
}

private void findSubsetsInSize(int[] nums, int k, int start, List<Integer> subset, List<List<Integer>> subsets) {
    if (k == 0) {
        subsets.add(new ArrayList<>(subset));
        return;
    }
    for (int i = start; i < nums.length; i ++) {
        subset.add(nums[i]);
        findSubsetsInSize(nums, k - 1, i + 1, subset, subsets);
        subset.remove(subset.size() - 1);
    }
}
```





**带有重复元素的不同子集**

[90. Subsets II](https://leetcode.com/problems/subsets-ii)

```html
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```

```java
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] visited = new boolean[nums.length];
    for (int sz = 0; sz <= nums.length; sz ++) {
        backtracking(nums, 0, sz, list, visited, res);
    }
    return res;
}

private void backtracking(int[] nums, int start, int size, List<Integer> list, boolean[] visited, List<List<Integer>> res) {
    if (size == list.size()) {
        res.add(new ArrayList<>(list));
        return;
    }
    for (int i = start; i < nums.length; i ++) {
        if (i > start && nums[i] == nums[i-1] && !visited[i-1])
            continue;                                   // no need to handle visited[i]
        list.add(nums[i]);
        visited[i] = true;
        backtracking(nums, i + 1, size, list, visited, res);
        list.remove(list.size() - 1);
        visited[i] = false;
    }
}
```







[216. Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)

```html
k 限定组合中元素的个数  
n 表示组合中的数字和为 n
Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
```

```java
public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(1, k, n, new ArrayList<>(), res);
    return res;
}

private void backtracking(int start, int k, int n, List<Integer> list, List<List<Integer>> res) {
    if (list.size() > k) return;
    if (list.size() == k && n == 0) {
        res.add(new ArrayList<>(list));
        return;
    }
    for (int i = start; i <= 9; i ++) {
        list.add(i);
        backtracking(i + 1, k, n - i, list, res);    // start is i+1, not start
        list.remove(list.size() - 1);
    }
}
```


## floodfill

洪水方式进行填充  
🦠 病毒方式进行感染，感染成一个临时性的标志状态  


Dfs 带有返回值  
返回值为扫描的面积  
返回值为boolean，用于判断比较，可快速退出    

  

  

无权图的最短路径，通过 BFS 寻找  

  


图论建模：  
状态表达  

打开转锁盘  

  


图的拓扑排序  



## BFS  
是四联通还是八联通  

无权图的最短路径问题  

  

图论问题建模  

状态的转移，可以通过其他状态达到指定的状态  
波轮，求出最短的步数  

找出所找值的内在规律  

  

## 回溯算法

回溯算法的剪枝  

回溯算法就是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作

```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```


**决一个回溯问题，实际上就是一个决策树的遍历过程**。你只需要思考 3 个问题：

1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。



