30 包含min函数的栈
 https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

## 思路1
 minStack 与 dataStack 保存同样的数量；
 只压入比当前 min 小的，否则压入同 data
 
 
## 思路2
 minStack 与 dataStack 保存不同数量  
 必要结果保存