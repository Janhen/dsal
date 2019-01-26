常见数据结构的代码实现  
以 [《玩转数据结构 从入门到进阶》](https://coding.imooc.com/class/207.html) 课程为基础进行增加和修改


```
# 基本结构
array
--- dynamic              // 动态数组
linkedList
--- dummyHead            // 带虚拟结点的链表
queue
--- baseArray             
--- baseLinkedList
--- baseLoopArray        // 基于循环数组实现的队列
--- twoStackImpl
stack
--- baseArray
--- baseLinkedList
--- withMin
--- twoQueueImpl

# 顺序性结构
BST
--- base                   // 普通节点的BST
--- withParent             // 含 parent 的节点的BST
AVL
--- AVLTree                 // 平衡树
redBlack
--- RBTree                  // 红黑树
skipList
--- SkipList                // 跳表

# 特殊的树形结构
heapAndpriotiryQueue
--- base                     // 堆
--- indexHeap                // 索引堆
------ reverseIndex          // 相反索引数组优化查找
trie
--- Trie                      // 字典树
------withPathAndEnd          // 带有节点个数, 截止节点单词个数的节点
unionFind
--- quickFind                 // 快速搜索
--- quickUnion                
--- sizeOptimize              // 记录节点个数优化
--- rankOptimize              // 记录节点 rank 优化
--- pathCompression           // 路径压缩优化
--- pathCompressionRecursion  
segmentTree
--- SegmentTree               // 线段树

# 其他结构
hashTable
--- base                       
--- dynamic                    // 倍率动态调整容量
--- resizeOptimize             // 经验表映射调整容量
```
