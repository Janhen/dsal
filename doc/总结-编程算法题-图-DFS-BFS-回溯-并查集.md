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

  


## 图论问题建模  
状态的转移，可以通过其他状态达到指定的状态  
波轮，求出最短的步数  

  


找出所找值的内在规律  

  







## 回溯算法

回溯算法的剪枝  

回溯算法就是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作

```
def backtrack(...):
    for 选择 in 选择列表:
        做选择
        backtrack(...)
        撤销选择
```




## 排列组合问题
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