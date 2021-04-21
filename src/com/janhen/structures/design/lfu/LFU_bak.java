package com.janhen.structures.design.lfu;

// 根据 频度进行 elimination strategy
// 次数的双端链表,    链表元素也为一个双端链表,  进行
// 头处无元素, 进行大的链表中元素删除
// 选中某个大链表下的小链表的元素, 进行添加到大连表的的位置, 之后添加到小链表除对应位置
// 二维的双向链表

import java.util.HashMap;

public class LFU_bak {

    // 挂在大链表下的链表的节点
    public static class Node {
        public Integer key;
        public Integer value;
        public Integer times;
        public Node up;
        public Node down;

        public Node(int key, int value, int times) {
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public static class LFUCache {

        // headList
        //   1  <->  3  <->  4  <->  7
        //   F       G       H       I
        //   ^       ^       ^       ^
        //   |       |       |       |
        //   v       v       v       v
        //   A       D
        //   ^
        //   |
        //   v
        //   C
        //   ^
        //   |
        //   v
        //   E
        private final int capacity;
        private final HashMap<Integer, Node> records;   // key -- node   to map
        private final HashMap<Node, NodeList> heads;   // 多对一  (F,nodelist1),(A,nodelist1),(C,nodelist1),(E,
        private int size;
        // nodelist1),(G,
        // nodelist3),(D,nodelist3)
        private NodeList headList;     // 整个大链表的头部

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        // 添加元素,  存在跟新一个
        //           \
        //             不存在, 挂接在词频为 1 的大链表中
        public void set(int key, int value) {
            if (records.containsKey(key)) {
                Node node = records.get(key);
                node.value = value;
                node.times++;

                NodeList curNodeList = heads.get(node);  // 在 大链表中的位置
                move(node, curNodeList);    // 从选来的大链表中删除, 移动到对应的大链表节点下
            } else {
                // 添加节点 :
                // - 触发 elimination strategy to keep size
                // -
                if (size == capacity) {
                    Node node = headList.tail;     // 删除词频最低的尾节点
                    headList.deleteNode(node);    // 先删除 淘汰的节点, 可能进行头结点的调整
                    modifyHeadList(headList);     // 并处理可能的影响

                    records.remove(node.key);
                    heads.remove(node);
                    size--;
                }
                Node node = new Node(key, value, 1);
                if (headList == null) {
                    headList = new NodeList(node);
                } else {
                    if (headList.head.times.equals(node.times)) {  // 挂在已经有的大链表中, 直接加入
                        headList.addNodeFromHead(node);
                    } else {                                 // 创建新的大链表中的节点
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key, node);
                heads.put(node, headList);
                size++;
            }
        }

        // 3 <-> 4 <-> 6                    // 是最最高的词频
        // C           A
        private void move(Node node, NodeList oldNodeList) {
            oldNodeList.deleteNode(node);
            // 确定先添加的 nodelist 的前一个
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last
              : oldNodeList;
            NodeList nextList = oldNodeList.next;
            if (nextList == null) {
                NodeList newList = new NodeList(node);
                if (preList != null) {
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null) {
                    headList = newList;
                }
                heads.put(node, newList);
            } else {
                if (nextList.head.times.equals(node.times)) {
                    nextList.addNodeFromHead(node);
                    heads.put(node, nextList);
                } else {
                    NodeList newList = new NodeList(node);
                    if (preList != null) {
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if (headList == nextList) {
                        headList = newList;
                    }
                    heads.put(node, newList);
                }
            }
        }

        // 从选来的大链表中删除, 移动到对应的大链表节点下
        // 从 oldNodeList 中取出 node
        //  4 <-> 6
        //  A

        // 3 <-> 4 <-> 6        // 新加的词频在大链表中无对应
        // C     A

        // return whether delete this head
        // 删除, 是否需要将整个小链表去除
        private boolean modifyHeadList(NodeList nodeList) {
            if (nodeList.isEmpty()) {
                if (headList == nodeList) {       // 删除大链表的首节点
                    headList = nodeList.next;
                    if (headList != null) {
                        headList.last = null;
                    }
                } else {                        // 删除大链表的中间节点
                    nodeList.last.next = nodeList.next;
                    if (nodeList.next != null) {
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        public int get(int key) {
            if (!records.containsKey(key)) {
                return -1;
            }
            Node node = records.get(key);
            node.times++;
            NodeList curNodeList = heads.get(node);
            move(node, curNodeList);             // 调整在大链表中的位置
            return node.value;
        }

        // 每次添加一个元素
        // 第一次出现, 直接在大链表中次数为 1 的首部添加一个节点
        // 从小链表中删除该节点, 定位到大链表中, 向其中添加节点
        // 不包含出现的次数, 线面挂接的小链表出现的次数相同
        public static class NodeList {
            public Node head;
            public Node tail;
            public NodeList last;
            public NodeList next;

            public NodeList(Node node) {
                head = node;
                tail = node;
            }

            // 操作小链表中的节点    head must not null by definition
            public void addNodeFromHead(Node newHead) {
                newHead.down = head;      // 头插法
                head.up = newHead;
                head = newHead;
            }

            public boolean isEmpty() {
                return head == null;
            }

            // common method to delete node
            public void deleteNode(Node node) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    if (node == head) {   // remove head
                        head = node.down;
                        head.up = null;
                    } else if (node == tail) {  // remove tail
                        tail = node.up;
                        tail.down = null;
                    } else {           // remove mid node
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;  // eliminate unnecessary reference
            }
        }
    }
}