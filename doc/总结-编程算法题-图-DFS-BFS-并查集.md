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
