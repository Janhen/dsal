[nowcoder](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
 
## 思路1
TreeMap.successor(entry)
① 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
② 否则，向上找第一个左链接指向的树包含该节点的祖先节点。



## 相关
二叉树的前驱节点