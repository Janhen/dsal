常见数据结构的代码实现    

```
│  FileUtils.java
│  Main.java
│  TestUtil.java
│
├─design                         // 一些数据结构设计
│  ├─arrayAsQueueAndStack
│  │  │  IQueue.java
│  │  │  IStack.java
│  │  │  Queue.java
│  │  │  Stack.java
│  │  │
│  │  └─loopArray
│  │          Queue.java
│  │
│  ├─firstNotDuplicationInStream
│  │      Solution.java
│  │
│  ├─lru
│  │      LRUBaseLinkedHashMap.java
│  │      LRUCache.java
│  │      LRUCache1.java
│  │
│  ├─medianInStream
│  │      Solution.java
│  │
│  ├─queueByTwoQueue
│  │      Queue.java
│  │
│  ├─queueStoreCatDog
│  │      Cat.java
│  │      CatDogQueue.java
│  │      Dog.java
│  │      Main.java
│  │      Pet.java
│  │
│  ├─queueWithMax
│  │      Main.java
│  │      MaxQueue.java
│  │      MaxQueue2.java
│  │      MaxQueue3.java
│  │
│  ├─stackByTwoQueue
│  │      Main.java
│  │      Stack.java
│  │
│  └─stackWithMin
│          GetMinStack.java
│          GetMinStack2.java
│          Main.java
│
└─structures
    ├─array
    │      Array.java
    │      Main.java
    │
    ├─AVL                       // 平衡树
    │  │  AVLTree.java
    │  │  AVLTreeTest.java
    │  │  Main.java
    │  │
    │  └─other
    │          AVLMap.java
    │          AVLSet.java
    │          AVLTree2.java
    │
    ├─BST                       // 二叉树
    │  │  BST.java
    │  │  IBST.java
    │  │  IBSTMap.java
    │  │  Main.java
    │  │
    │  ├─base
    │  │      BST.java
    │  │      BST2.java
    │  │      Main.java
    │  │
    │  ├─order
    │  │      BinarySearchOrderedST.java
    │  │      BST.java
    │  │      OrderedST.java
    │  │      OrderedSTTest.java
    │  │      RedBlackBST.java
    │  │
    │  └─withParent
    │          AbstractBinarySearchTree.java
    │          BinarySearchTree.java
    │
    ├─hashtable                 // 哈希表
    │  │  Main.java
    │  │  Student.java
    │  │
    │  ├─base
    │  │      HashTable.java
    │  │      Main.java
    │  │
    │  ├─dynamic
    │  │      HashTable.java
    │  │      Main.java
    │  │
    │  └─resizeOptimize
    │          HashTable.java
    │          Main.java
    │
    ├─heap_priorityQueue            // 堆|优先队列
    │  │  HeapSort.java
    │  │  IHeap.java
    │  │  IIndexHeap.java
    │  │  MaxHeap.java
    │  │
    │  ├─base
    │  │      HeapSort.java
    │  │      HeapSort2.java
    │  │      Main.java
    │  │      MaxHeap.java
    │  │      PrintableMaxHeap.java
    │  │
    │  ├─compositeArray
    │  │      Main.java
    │  │      MaxHeap.java
    │  │      PriorityQueue.java
    │  │
    │  └─indexHeap
    │      │  IndexMaxHeap.java
    │      │
    │      └─reverseIndex
    │              IndexMaxHeap.java
    │
    ├─linkedList                        // 链表
    │      LinkedList.java
    │      Main.java
    │
    ├─queue                             // 队列
    │  │  IQueue.java
    │  │  Main.java
    │  │
    │  ├─baseLinkedList
    │  │      Main.java
    │  │      Queue.java
    │  │
    │  └─baseLoopArray
    │          Main.java
    │          Queue.java
    │          Queue2.java
    │
    ├─redBlack                          // 红黑树
    │      Main.java
    │      RBTree.java
    │
    ├─segmentTree
    │      ISegmentTree.java
    │      Main.java
    │      Merger.java
    │      SegmentTree.java
    │
    ├─set_map                           // 集合和映射
    │  ├─map
    │  │      BSTMap.java
    │  │      LinkedListMap.java
    │  │      Main.java
    │  │      Map.java
    │  │
    │  └─set
    │          BST.java
    │          BSTSet.java
    │          LinkedListSet.java
    │          Main.java
    │          Set.java
    │
    ├─skipList                          // 跳表
    │      SkipList.java
    │
    ├─stack                             // 栈
    │  │  IStack.java
    │  │  Main.java
    │  │
    │  ├─baseArray
    │  │      Main.java
    │  │      Stack.java
    │  │
    │  └─baseNode
    │          Main.java
    │          Stack.java
    │
    ├─trie                              // 字典树
    │  │  ITrie.java
    │  │  Main.java
    │  │  Trie.java
    │  │
    │  └─withPathAndEnd
    │          Trie.java
    │          Trie2.java
    │
    └─unionFind                         // 并查集
        │  Main.java
        │  UF.java
        │  UnionFind.java
        │
        ├─baseNode
        │      UnionFind.java
        │
        ├─pathCompression
        │      UnionFind.java
        │
        ├─pathCompressionRecursion
        │      UnionFind.java
        │
        ├─quickFind
        │      UnionFind.java
        │
        ├─quickUnion
        │      UnionFind.java
        │
        ├─rankOptimize
        │      UnionFind.java
        │
        └─sizeOptimize
                UnionFind.java