[leetcode](https://leetcode.com/problems/lru-cache/)

```
LRUCache cache = new LRUCache( 2 );
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

思路一: 通过 LinkedHashMap 实现



思路二: 通过双向链表 + 哈希表实现  

