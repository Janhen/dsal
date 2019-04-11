# 总览

## Iterator 模式

从 JDK 1.5 之后可以使用 foreach 方法来遍历实现了 Iterable 接口的聚合对象。



**&& 失败模式**

（1） 快速失败 ：尽最大努力抛出 ConcurrentModificationException。

仅用于检测 bug，是一种错误检测机制，发生在多个线程对集合进行机构上的改变时。

通过容器内持有 modCount，在迭代中比较迭代前的 exceptedModCount 实现。

 

（2） 安全失败 ：是通过新建一个对应的集合后，再在其上面修改实现的。

J.U.C 下的容器大多采用这种设计。



 **&& 迭代方式**

几种遍历方式： 

- forEach 进行修改
- iterator 进行修改
- for 进行根据索引比较元素内容，同时根据索引删除



先遍历根据约束获得要删除的位置，之后进行统一的删除。



**&& 迭代器类型**

是工厂方法的体现?

（1） 普通迭代器

一般基于数组的通过 cursor 记录当前访问位置；

链表的记录 Node 表示当前访问到的节点；

```java
interface Iterator<E> {
    boolean hasNext();
    E next();
    default void remove()
    default void forEachRemaining
}
```



（2）双向迭代器： ListIterator 实现，可向两个方向进行遍历操作。

ArrayList、LinkedList、Vector等 List 接口实现都实现该迭代器；

基于链表时用于二分搜索等操作加快速度；

 ```java
interface ListIterator<E> extends Iterator<E> {
    boolean hasPrevious();
    E previous();
    int nextIndex();
    int previousIndex();
    void set(E e);
    void add(E e);
}
 ```



（3） 安全失败的迭代器

CopyOnWriteArrayList 中用于安全迭代使用的，持有当前底层容器的一个快照；

```java
class COWIterator<E> implements ListIterator<E> {
    final Object[] snapshot;
    int cursor;
}
```



（4） Enumeration

较为原始的迭代方式，HashTable 使用该种迭代器；

速度是 Iterator 的 2 倍，占用更少的内存；

Iterator 比 Enumeration 安全，线程不会修改正在被 iterator 遍历的集合里面的对象；

Iterator 允许调用者删除底层数据集合里面的对象，Enumeration 不可以；

```java
interface Enumeration<E> {
    boolean hasMoreElements();
    E nextElement();
}
```

HashMap 中的迭代访问

```java
class Enumerator<T> implements Enumeration<T>, Iterator<T> {
    Entry<?,?>[] table = Hashtable.this.table;
    int index = table.length;
    Entry<?,?> entry;
    Entry<?,?> lastReturned;
    int type;
    boolean iterator;
    int expectedModCount = modCount;
}
```



（5） “特殊" 的迭代器

PriorityQueue 中的迭代器，通过 ArrayDeque 来实现

```java
final class Itr implements Iterator<E> {
    int cursor = 0;
    int lastRet = -1;
    ArrayDeque<E> forgetMeNot = null;  
    E lastRetElt = null;
    int expectedModCount = modCount;
}
```



## 适配器模式

将数组转换成 List 类型

```java
public static <T> List<T> asList(T... a)
```



## 组合模式

如 ArrayList 可以将 PriorityQueue 的元素组合到自身中来，但 ArrayList 内部不持有 Collection 接口的引用；

忽略彼此底层结构，基于数组和链表的都可以进行组合；

```java
// --- Collection ---
void addAll(Collection coll);
```



## 序列化

对于底层基于动态数组实现的容器，在序列化时都是只序列化存放容器的那个部分。

需要通过 writeObject() 和 readObject 来实现定制的序列化。

（1） 原理

ObjectOutputStream 的 writeObject() 实现 Object ⇒ byte[] 。

writeObject() 方法在传入的对象存在 writeObject() 的时候会去反射调用该对象的 writeObject() 来实现序列化。反序列化使用的是 ObjectInputStream 的 readObject() 方法，原理类似。



（2） 用处

保存对象当前信息和状态并持久化的一种方式，类似 JSON、xml；

用户远程对象传输，实现进程之间的通信；



（3） 精简使用

通常情况下使用 JSON、xml 相关的工具将 Object 转换存储需要保留大量不必要的信息；

如 Student 进行 JSON 序列化时，会携带字段名称，用于通信或持久化的数据量大，是不必要的网络开销；

可以通过自定义序列化，使用分割符来进行分割字段；

```java
class Student{
    int age;
    String name;
    boolean sex;
    Date birthday;
}
```

Json 传输： 默认情况下
```json
{
    "student": {
        "age": 23, 
        "name": "张三",
        "sex": false,
        "birthday": "2000-12-12"
    }
}
```

自定义序列化传输： 

直接存储为 String，不需要字段名

```
23//张三//false//2000-12-12
```



自定义序列化 Java 代码实现： 

抽取成工具类

```java
private static final String separator = "/////";
public static String writeStudentObject(Student student) {
    StringBuilder s = new StringBuilder();
    s.append(student.getAge()).append(separator);
    s.append(student.getName()).append(separator);
    s.append(student.isSex()).append(separator);
    s.append(DateUtil.date2Str(student.getBirthday())).append(separator);
    return s.toString();
}
public static Student readStudentObject(String s) {
    Student student = new Student();
    String[] vals = s.split(separator);
    student.setAge(Integer.valueOf(vals[0]));
    student.setName(vals[1]);
    student.setSex(vals[2]);
    if(vals.length > 3) {
        student.setBirthday(DateUtil.parseDate(vals[3]));
    }
    return student;
}
```



# List

## ArrayList

底层基于数组保存，增删慢、随机查询快；

线程不安全；



**&& 1、底层 | INIT**

（1） 结构

```java
transient Object[] elementData; 
int size;
transient int modCount = 0;
```



（2） 加载和初始化

懒加载形式；

在 add() 时进行对应的初始化；

三种初始化方式： 

① 无参；

② 给定容量；

③ 通过放入 Collection 接口进行初始化；

```java
static final int DEFAULT_CAPACITY = 10;
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}
```



**&& 2、一些操作**

**&&& 操作-扩容**

扩容为 `oldN*1.5+1`

通过 `Arrays.copyOf()` 复制到新数组中，开销大；

一般可以通过初始指定容量的方式，来减少扩容的次数；

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}

private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); /* init capacity */
    }
    ensureExplicitCapacity(minCapacity);
}

private void ensureExplicitCapacity(int minCapacity) {
    modCount++;
    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}

private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    /* copy to impl. */
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```



**&&& 操作-删除元素**

需要调用 System.arraycopy() 将 index+1 后面的元素都复制到 index 位置上，该操作的时间复杂度为 O(N)，开销大。

```java
public E remove(int index) {
    rangeCheck(index);
    modCount++;
    E oldValue = elementData(index);
    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index, numMoved);
    elementData[--size] = null; // clear to let GC do its work
    return oldValue;
}
```



**&&& 操作-迭代访问**

采用快速失败模式实现；

通过成员变量 `modCount` 与 expectedModCount 比较实现；

主要用在 序列化 获得迭代操作时进行判断，对应抛出 ConcurrentModificationException；



modCount 用来记录 ArrayList 结构发生变化的次数。结构发生变化是指添加或者删除至少一个元素的所有操作，或者是调整内部数组的大小，仅仅只是设置元素的值不算结构发生变化。

在进行序列化或者迭代等操作时，需要比较操作前后 modCount 是否改变，如果改变了需要抛出 ConcurrentModificationException。



**&& 3、序列化**

只序列化数组中存放值的这些部分;

ArrayList 基于数组实现，并且具有动态扩容特性，因此保存元素的数组不一定都会被使用，那么就没必要全部进行序列化。

```java
transient Object[] elementData;     // not serialize
```



ArrayList 实现了 writeObject() 和 readObject() 来控制只序列化数组中有元素填充那部分内容。

```java
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException{
    int expectedModCount = modCount;   /* keep to compare */
    s.defaultWriteObject();             /* only have space */

    s.writeInt(size);

    for (int i=0; i<size; i++) {        /* only write have element */
        s.writeObject(elementData[i]);
    }

    if (modCount != expectedModCount) {    /* use for fail-fast */
        throw new ConcurrentModificationException();
    }
}
```

```java
private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException {
    elementData = EMPTY_ELEMENTDATA;

    s.defaultReadObject();

    s.readInt(); // ignored

    if (size > 0) {
        // be like clone(), allocate array based upon size not capacity
        ensureCapacityInternal(size);

        Object[] a = elementData;
        // Read in all elements in the proper order.
        for (int i=0; i<size; i++) {
            a[i] = s.readObject();
        }
    }
}
```



序列化时需要使用 ObjectOutputStream 的 writeObject() 将对象转换为字节流并输出。而 writeObject() 方法在传入的对象存在 writeObject() 的时候会去反射调用该对象的 writeObject() 来实现序列化。反序列化使用的是 ObjectInputStream 的 readObject() 方法，原理类似。

```java
ArrayList list = new ArrayList();
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
oos.writeObject(list);
```



**&& 一些区别**

（1） 与 Array 的比较

① 存储类型： Array 可以存放基本和对象类型， ArrayList 只能包含对象类型；

② 大小： 动态可变;

③ 其他方法和特性： addAll()，removeAll()，iterator()等等;
对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。



**（2）与 LinkedList 的比较**

都是线程不安全的容器，都实现了 List 接口具备 List 的特性；

① 底层实现： ArrayList 基于索引的数据接口，底层是动态数组实现，LinkedList 以元素列表的形式存储数据，是双向链表实现；

② 一些操作的性质： 

- ArrayList 支持随机访问，LinkedList 不支持；
- LinkedList 在任意位置添加删除元素更快；

③ 内存占用上： LinkedList 存放两个指针，相同数据量下占用更多的空间；

④ 插入和删除是否受元素位置影响： ArrayList 插入和删除受元素位置影响，add(e) 默认追加到末尾，在指定位置 i 插入和删除时复杂度为 O(n-i)，而 LinkedList 链表存储，插入和删除不受位置影响；



**（3） 与 Vector 的比较**

- 同步性： Vector 是同步的，因此开销就比 ArrayList 要大，访问速度更慢。最好使用 ArrayList 而不是 Vector，因为同步操作完全可以由程序员自己来控制；
- 数据增长： Vector 每次扩容请求其大小的 2 倍空间，而 ArrayList 是 1.5 倍。且 Vector 可以设置增长空间的大小。



## LinkedList

基本性质：

基于双向链表实现，只能顺序访问，但是可以快速地在链表中间插入和删除元素。不仅如此，LinkedList 还可以用作栈、队列和双向队列。

底层基于链表；

增删快，随机访问慢；

线程不安全；



**&& 1、底层 | INIT**

（1） 通过记录 first, last, size 便于边界操作（注：用于队列、栈、双端队列）

队列中每个节点都存放元素，存在初始化情况；

```java
transient int size = 0;
transient Node<E> first;
transient Node<E> last;
```

```java
class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
}
```

（2） 初始化

不支持初始情况下给定对应的容量；

基于链表都为无界队列；
```java
public LinkedList() {
}
public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
```


**&& 2、操作**

**&&& 操作-add**

```java
void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;
    if (l == null)
        first = newNode;               
    else
        l.next = newNode;
    size++;
    modCount++;
}
```



## Vector

基本性质： 

底层基于数组保存元素；

随机查询快，增删慢；

线程不安全；



注： Java 中的 Stack 通过继承 Vector 实现的



**&& 1、底层 | INIT**

初始容量为 10

```java
Object[] elementData;
int elementCount;
int capacityIncrement;
public Vector() {
    this(10);
}
```



**&& 2、同步**

对修改底层结构的函数进行加锁同步访问

```java
public synchronized boolean add(E e) {
    modCount++;
    ensureCapacityHelper(elementCount + 1);
    elementData[elementCount++] = e;
    return true;
}

public synchronized E get(int index) {
    if (index >= elementCount)
        throw new ArrayIndexOutOfBoundsException(index);

    return elementData(index);
}
```



**&& 3、扩容机制**

扩容为 `oldN*2`；

```java
void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + ((capacityIncrement > 0) ?                 /* 默认扩容 1 倍 */
                                     capacityIncrement : oldCapacity);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```



**&& 4、替代方案**

（1） 获得对应线程不安全容器的同步容器

```java
List<String> list = new ArrayList<>();
List<String> synList = Collections.synchronizedList(list);
```

（2） 使用并发容器，如 CopyOnWriteArrayList

```java
List<String> list = new CopyOnWriteArrayList<>();
```





## CopyOnWriteArrayList

基本性质： 

- 易引起 YongGC, FullGC              写操作复制防止并发修改不一致
- 不可用于实时的数据
- 适合读多写少的情景
- 读操作无需加锁，写操作加锁      



三个思想：

- 读写分离
- 最终一致性
- 新开辟空间，解决并发冲突



**&& 1、底层结构 | INIT**

（1） 底层结构

① ReentrantLock： 通过此来实现并发访问

```java
final transient ReentrantLock lock = new ReentrantLock();
transient volatile Object[] array;
static final long lockOffset;
static final sun.misc.Unsafe UNSAFE;
```



（2） 初始化

三种初始化方式：

① 无参

② Collection

③ 泛型数组初始化

```java
public CopyOnWriteArrayList(E[] toCopyIn) {
    setArray(Arrays.copyOf(toCopyIn, toCopyIn.length, Object[].class));
}
```



**&& 2、操作**

**&&& add**

需要处理并发访问问题、处理复制问题



包含 lock 加锁获取与释放：

① 获取原数组

② 复制出 len+1 的数组

③ 为新数组末尾复制

④ 修改内部数组指向

```java
boolean add(E e) {
    final ReentrantLock lock = this.lock;           
    lock.lock();
    try {
        Object[] elements = getArray();             /* 获取原数组 */
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);   /* 复制数组 */
        newElements[len] = e;
        setArray(newElements);
        return true;
    } finally {
        lock.unlock();
    }
}

final void setArray(Object[] a) {
    array = a;
}
```



**&&& 操作-get**

无需加锁直接访问, 在add操作的同时可访问旧有的数据 ⇒ 实时性得不到保证 

```java
 E get(int index) {         
     return get(getArray(), index);
 }
E get(Object[] a, int index) {
	return (E) a[index];
}	
```



**&&& 操作-迭代方式**

通过安全失败实现

将当前数组放入到 Iterator 实现类中，并传递迭代的开始位置

```java
public Iterator<E> iterator() {
    return new COWIterator<E>(getArray(), 0);
}
```



迭代器中保存某个时间点下底层数组的快照，通过 cursor 来进行向前迭代访问。

```java
final Object[] snapshot;
int cursor;
COWIterator(Object[] elements, int initialCursor) {
    cursor = initialCursor;
    snapshot = elements;
}
E next() {
    if (! hasNext())
        throw new NoSuchElementException();
    return (E) snapshot[cursor++];
}
```



**&& 3、特性-读写分离**

写操作在一个复制的数组上进行，读操作还是在原始数组中进行，读写分离，互不影响。

写操作需要加锁，防止并发写入时导致写入数据丢失。

写操作结束之后需要把原始数组指向新的复制数组。



**&& 4、适用场景**

CopyOnWriteArrayList 在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。

但是 CopyOnWriteArrayList 有其缺陷：

- 内存占用：在写操作时需要复制一个新的数组，使得内存占用为原来的两倍左右；
- 数据不一致：读操作不能读取实时性的数据，因为部分写操作的数据还未同步到读数组中。

所以 CopyOnWriteArrayList 不适合内存敏感以及对实时性要求很高的场景。



# Set

## HashSet



## LinkedHashSet





## TreeSet







**&& 与 HashSet 的区别**

① 底层结构：HashSet 基于 hash 表实现，元素无序， 一些方法 add(), remove(), contains() 复杂度为 O(1)；

② 有序性： TreeSet 基于红黑树实现，元素有序， add(), remove(), contains() 复杂度为 O(logN)；





# Queue

## PriorityQueue

基本性质： 

有序的优先队列；

不可以存放 NULL，NULL 无自然顺序；

非线程安全，入队和出队为 O(logN)；

默认情况下为最小堆；



**&& 1、底层结构 | INIT**

（1） 底层结构

数组保存的完全二叉树，首元素存放元素值；

堆顶元素有序，默认情况下为最小堆；



comparator： 默认自定义比较器优先于存入对象的自然排序进行比较

```java
transient Object[] queue; 
int size = 0;
final Comparator<? super E> comparator;
transient int modCount = 0;
```



（2） 初始

```java
static final int DEFAULT_INITIAL_CAPACITY = 11;
PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }
PriorityQueue(int initialCapacity, Comparator<? super E> comparator);
```



**&& 2、操作**

**&&& offer| shiftUp**

（1） offer

先将元素放到完全二叉树的尾节点

之后不断上浮调整结构使其符合堆特性



（2） shiftUp

上浮函数，用于维护整个堆结构，实现的是最小堆；

赋值替换交换优化；

找出正确位置并放入；

```java
 void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
```


**&&& poll | siftDown**

（1） poll

保存堆顶元素；

将堆顶与最末叶子节点交换，之后通过堆顶下沉实现结构的维护；



（2） siftDown

下沉函数，维护堆结构

通过赋值来替换掉交换操作；

找到元素应该放入的正确位置放入；

```java
void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = key;
}
```



**&&& remove**

remove(o) 删除一个对象，需要先进行向下调整后进行向上调整；


代码逻辑： 

最末叶子节点赋值到当前删除的位置；
让原来的最末叶子节点向下调整；
结构不合法向上调整；

```java
E removeAt(int i) {
    // assert i >= 0 && i < size;
    modCount++;
    int s = --size;
    if (s == i) // removed last element
        queue[i] = null;
    else {
        E moved = (E) queue[s];       /* 最末叶子节点赋值到当前删除的位置 */
        queue[s] = null;
        siftDown(i, moved);             /* 让原来的最末叶子节点向下调整 */
        if (queue[i] == moved) {      /* 结构不合法向上调整 */
            siftUp(i, moved);
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}
```



**&&& heapify**

初始传入为 Collection 进行  堆化  处理，借助原始结构，从中间处向上不断下城处理，相比较每次插入到最末叶子节点进行向上调整效率更高；

完全二叉树中间节点位置 size/2-1

```java
void initFromCollection(Collection<? extends E> c) {
    initElementsFromCollection(c);
    heapify();
}
void heapify() {
    for (int i = (size >>> 1) - 1; i >= 0; i--)  /* 完全二叉树从上层节点不断向下调整实习 */
        siftDown(i, (E) queue[i]);
}
```





**&& 3、扩容**

小数据量快速 2 倍增容，

一定大容量下 50% 增容；

```java
void grow(int minCapacity) {
    int oldCapacity = queue.length;
    // Double size if small; else grow by 50%
    int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                     (oldCapacity + 2) :
                                     (oldCapacity >> 1));
    // overflow-conscious code
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    queue = Arrays.copyOf(queue, newCapacity);
}
```


**&& 4、迭代**

// todo

```java
class Itr implements Iterator<E> {
    int cursor = 0;
    int lastRet = -1;
    ArrayDeque<E> forgetMeNot = null;
    E lastRetElt = null;
    int expectedModCount = modCount;
}
```



**&& 5、使用场景**

贪心算法选择最优；

图论中使用进行优化；

实现 哈夫曼树等结构；



## ArrayDeque

基于数组实现的双向队列；

// todo





# Map

Map 总览： 

- HashMap: 
- TreeMap:  有序的 Map；

- LinkedHashMap：使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。

- HashTable:

## HashMap(7)

Hash 表结构几个重要的通用操作， hash 函数、hash 冲突、rehash 及扩容；

**&& 1、存储结构 | init**

（1） 结构

底层结构中为每一个 Node 添加指向 prev, next 的引用

```java
transient Entry[] table;
```

Entry 存储着键值对。它包含了四个字段，从 next 字段我们可以看出 Entry 是一个链表。即数组中的每个位置被当成一个桶，一个桶存放一个链表。HashMap 使用拉链法来解决冲突，同一个链表中存放哈希值相同的 Entry。

```java
class Entry<K,V> implements Map.Entry<K,V> {
    final K key;
    V value;
    Entry<K,V> next;
    int hash;
}
```

（2） 初始化

① 无参初始化

② Map 传入初始化

③ 指定初始化容量，使用的较多；

④ 执行初始化容量和负载因子

```java
Map<Obejct, Object> map = new HashMap<>(x * 4/3);    // loadFactor to prevent grow
```



**&& 2、操作**

**&&& hash 函数 | 元素定位** 

（1） 整体的定位

```java
int hash = hash(key);
int i = indexFor(hash, table.length);
```



（2） 具体的 hash 确定

通过多次移位和异或进行 hash 扰动，使其尽量不依赖于传入的 hashCode 的不均匀性；

"hash 扰动"

```java
final int hash(Object k) {
    int h = hashSeed;
    if (0 != h && k instanceof String) {
        return sun.misc.Hashing.stringHash32((String) k);
    }
    h ^= k.hashCode();
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}
final int hashCode() {
    return Objects.hashCode(key) ^ Objects.hashCode(value);
}
```



（3）根据 hash 确定桶下标

```java
static int indexFor(int h, int length) {
    return h & (length-1);
}
```



**&&& hash 冲突**

通过拉链法处理，头插法放到头部处

查找需要分成两步进行：

- 计算键值对所在的桶；
- 在链表上顺序查找，时间复杂度和链表的长度成正比




**&&& put 操作**

(1) 总体实现流程

1.判断初始化，对应的初始化

2.Null 值特殊处理，Null 无法调用 hashCode()，防止 NullPointerException

3.确定桶下标

4.遍历链表，若重复直接覆盖并返回

5.为新加入元素，插入 <K,V> 

6.根据情况看是否需要扩容处理

```java
public V put(K key, V value) {
    if (table == EMPTY_TABLE) {
        inflateTable(threshold);
    }
    // 键为 null 单独处理
    if (key == null)
        return putForNullKey(value);
    int hash = hash(key);
    // 确定桶下标
    int i = indexFor(hash, table.length);
    // 先找出是否已经存在键为 key 的键值对，如果存在的话就更新这个键值对的值为 value
    for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        Object k;
        if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }

    modCount++;
    // 插入新键值对
    addEntry(hash, key, value, i);
    return null;
}
```



（2） 对于 NULL 的插入处理

无法调用 null 的 hashCode() 方法，也就无法确定该键值对的桶下标，只能通过强制指定一个桶下标来存放。HashMap 使用第 0 个桶存放键为 null 的键值对。

```java
private V putForNullKey(V value) {
    for (Entry<K,V> e = table[0]; e != null; e = e.next) { /*0 bucket*/
        if (e.key == null) {
            V oldValue = e.value;
            e.value = value;
            e.recordAccess(this);
            return oldValue;
        }
    }
    modCount++;
    addEntry(0, null, value, 0);
    return null;
}
```



（3） 键冲突下的插入

头插法插入；

在容量阈值达到时，进行 2 倍扩容操作；

是一种添加之后，再进行扩容的行为，依赖的是上次添加完毕的情况；

```java
void addEntry(int hash, K key, V value, int bucketIndex) {
    if ((size >= threshold) && (null != table[bucketIndex])) {
        resize(2 * table.length);
        hash = (null != key) ? hash(key) : 0;
        bucketIndex = indexFor(hash, table.length);
    }

    createEntry(hash, key, value, bucketIndex);
}

void createEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K,V> e = table[bucketIndex];
    // 头插法，链表头部指向新的键值对
    table[bucketIndex] = new Entry<>(hash, key, value, e);
    size++;
}
```



**&&3、扩容 | rehash**

（1） 对应变量

① loadFactor：  负载因子时间上和空间上的一种平衡:

  - ↑ 查找性能差, 空间利用率高；
  - ↓ 查找性能高, 空间利用率低；

② size | threshold： size/capacity 达到负载因子时进行对应的扩容

③ modCount：用来处理扩容时出现并发访问造成数据不一致，从而 fail-fast

```java
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
static final int MAXIMUM_CAPACITY = 1 << 30;
static final float DEFAULT_LOAD_FACTOR = 0.75f;
transient int size;
int threshold;
final float loadFactor;
transient int modCount;
```

（2） 扩容总览

在负载因子达到给定值的情况下进行扩容；

扩容为原来数组的两倍；

```java
void addEntry(int hash, K key, V value, int bucketIndex) {
    Entry<K,V> e = table[bucketIndex];
    table[bucketIndex] = new Entry<>(hash, key, value, e);
    if (size++ >= threshold)
        resize(2 * table.length);
    ...
}
```

（3） 扩容与 rehash 的实现

扩容使用 resize() 实现，扩容操作同样需要把 oldTable 的所有键值对重新插入 newTable 中，因此这一步是很费时的。



（4） rehash | 计算桶下标

在进行扩容时，需要把键值对重新放到对应的桶上。HashMap 使用了一个特殊的机制，可以降低重新计算桶下标的操作。



根据 hash 值在当前的高位上是否为 0，进行不同的处理。

- 为0： 不需要移动
- 为 1： 移动偏移 原来容量对应的桶上；

```java
void resize(int newCapacity) {
    Entry[] oldTable = table;
    int oldCapacity = oldTable.length;
    if (oldCapacity == MAXIMUM_CAPACITY) {
        threshold = Integer.MAX_VALUE;
        return;
    }
    Entry[] newTable = new Entry[newCapacity];
    transfer(newTable);
    table = newTable;
    threshold = (int)(newCapacity * loadFactor);
}

void transfer(Entry[] newTable) {
    Entry[] src = table;
    int newCapacity = newTable.length;
    for (int j = 0; j < src.length; j++) {
        Entry<K,V> e = src[j];
        if (e != null) {
            src[j] = null;
            do {
                Entry<K,V> next = e.next;
                int i = indexFor(e.hash, newCapacity);
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            } while (e != null);
        }
    }
}
```



**&& 4、其他性质**

（1） JDK7 与 JDK8的比较

① 底层结构上：

- JDK8 采用 数组 + 链表 + 红黑树实现，长度过长转换成红黑树有效防范了 Hash 碰撞攻击；
- 将原来的 Entry 改为 Node，表示红黑树节点、链表节点；

② hash 函数： JDK8 只需要一次移位和异或即可，同时处理冲突上还有保证；

③ 处理 hash 冲突上： 在为链表时，通过尾插法进行处理，避免出现逆序且链表死循环问题；



（2） 不安全体现

扩容时因为头插法而形成环形引用，造成无限循环；

put 操作可能造成丢失修改；





## HashMap(8)

**&& 1、底层结构 | INIT**

（1） 整体结构

① table： 存储节点类型，用于多态扩展

② loadFactor： 控制扩容

③ modCount： 控制迭代访问， fail-fast

```java
transient Node<K,V>[] table; 
transient int size;
transient int modCount;
int threshold;
final float loadFactor;
```



（2） 节点与树化

① 控制树化的时机：

```java
static final int TREEIFY_THRESHOLD = 8;
static final int UNTREEIFY_THRESHOLD = 6;    /* prevent complexity oscillation */
static final int MIN_TREEIFY_CAPACITY = 64;  /* prevent resize and treeify conflict */
```

② 链表节点结构：

```java
class Node<K,V> implements Map.Entry<K,V> {
    final int hash;                  
    final K key;                      
    V value;
    Node<K,V> next;
}
```

③ 红黑树节点结构： 
继承 LinkedHashMap.Entry，便于从 tree 回退到 listNode

```java
static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
    TreeNode<K,V> parent;  // red-black tree links
    TreeNode<K,V> left;
    TreeNode<K,V> right;
    TreeNode<K,V> prev;    // needed to unlink next upon deletion
    boolean red;
}
```



**&& 2、操作**

**&&& hash 函数 | 元素定位** 

一次异或一次移位进行 hash 扰动，避免依赖于原来 hashCode 处理键冲突，提高 hash 值的扩散性；

对于 null 的 KEY，直接使其 hash 值为 0，从而避免 NullPointerException；

```java
int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);    
}
```



**&&& hash 冲突**

对于链表的 hash 冲突

部分 putVal() 方法：

为了实现树化，需要统计链表中的个数，直接遍历到链表尾部，进行插入；

```java
for (int binCount = 0; ; ++binCount) {                // binCount 记录链表中的个数
    if ((e = p.next) == null) {                            /* 迭代到链表尾部 */
        p.next = newNode(hash, key, value, null);
        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
            treeifyBin(tab, hash);                      /* 树化 */                       
        break;
    }
    if (e.hash == hash &&
        ((k = e.key) == key || (key != null && key.equals(k))))         
        break;
    p = e;
}
```


**&&& put 操作**

（1） 执行流程：
 1、如果 HashMap 未被初始化过，则初始化
 2、对 Key 求 Hash 值，然后再计算下标
 3、如果没有碰撞直接放入桶中
 4、如果碰撞了，以链表的方式链接到后面
 5、如果链表长度超过阀值，就把链表转成红黑树
 6、如果链表长度低于 6，就把红黑树转回链表
 7、如果节点已经存在就替换旧值
 8、如果桶满了（容量 16 *加载因子 0.75 ），就需要 resize（扩容 2 倍后重排）



（2） 额外： 

对于 NULL 值的处理，直接通过 hash(key) 给 NULL KEY 为 0 的值；

- onlyIfAbsent： 实现 `putIfAbsent()` 方法逻辑，保留旧的值；
- afterNodeAccess，afterNodeInsertion： hook 钩子函数进行特殊处理，可用于 LinkedHashMap 实现 LRU；

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    if ((tab = table) == null || (n = tab.length) == 0)   /*  初始情况 */
        n = (tab = resize()).length;
    if ((p = tab[i = (n - 1) & hash]) == null)        /* 插入的桶无元素 */
        tab[i] = newNode(hash, key, value, null);
    else {                                                                        
        Node<K,V> e; K k;
        if (p.hash == hash &&                        /* 第一个位置与插入的重复 */
            ((k = p.key) == key || (key != null && key.equals(k))))  
            e = p;
        else if (p instanceof TreeNode)              /* 是否树化 */       
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            for (int binCount = 0; ; ++binCount) {                                   
                if ((e = p.next) == null) {                                         
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);     /* 树化 */                            
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))             
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)  /* 总体的容量扩容 */
        resize();                                                                       
    afterNodeInsertion(evict);
    return null;
}
```

**&&& get()**

定位到对应的桶看是否有该 KEY

首个节点为该 KEY

若为 TreeNode ，进行红黑树的查找逻辑

若为 listNode 进行链表的迭代遍历查找





**&&3、 扩容 | rehash**

两种可能情况： 

- 仍然在原来的位置
- 在原来的位置上偏移原来的容量

（1） 链表拆分

将原来的一条链表拆成两条链表，低位链表的数据将会到新数组的当前下标位置（原来下标多少，新下标就是多少），高位链表的数据将会到新数组的当前下标+当前数组长度的位置（原来下标多少，新下标就是多少+当前数组长度）；

```java
Node<K,V> loHead = null, loTail = null;
Node<K,V> hiHead = null, hiTail = null;   
Node<K,V> next;
do {
    next = e.next;
    if ((e.hash & oldCap) == 0) {
        if (loTail == null)
            loHead = e;
        else
            loTail.next = e;
        loTail = e;
    }
    else {
        if (hiTail == null)
            hiHead = e;
        else
            hiTail.next = e;
        hiTail = e;
    }
} while ((e = next) != null);
if (loTail != null) {
    loTail.next = null;
    newTab[j] = loHead;
}
if (hiTail != null) {
    hiTail.next = null;
    newTab[j + oldCap] = hiHead;
}
```



（2） todo





**&&4、 树化**

（1） 链表转为红黑树

在挂接的链表大于   TREEIFY_THRESHOLD 时进行树化逻辑；

容器整体大于 MIN_TREEIFY_CAPACITY 时才允许树化，否则进行 resize；

```java
void treeifyBin(Node<K,V>[] tab, int hash) {                 
    int n, index; Node<K,V> e;
    if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY) 
        resize();   /* 当前容量太小，直接扩容，防 resize 和 treeify 频繁性能损耗 */
    else if ((e = tab[index = (n - 1) & hash]) != null) {
        TreeNode<K,V> hd = null, tl = null;
        do {
            TreeNode<K,V> p = replacementTreeNode(e, null);
            if (tl == null)
                hd = p;
            else {
                p.prev = tl;
                tl.next = p;
            }
            tl = p;
        } while ((e = e.next) != null);
        if ((tab[index] = hd) != null)
            hd.treeify(tab);
    }
}
```



（2） 红黑树转变成链表

在红黑树节点数少于 UNTREEIFY_THRESHOLD 时，进行结构转变；

```java
// TreeNode.split
if (loHead != null) {
    if (lc <= UNTREEIFY_THRESHOLD)
        tab[index] = loHead.untreeify(map);
    else {
        tab[index] = loHead;
        if (hiHead != null) // (else is already treeified)
            loHead.treeify(tab);
    }
}
if (hiHead != null) {
    if (hc <= UNTREEIFY_THRESHOLD)
        tab[index + bit] = hiHead.untreeify(map);
    else {
        tab[index + bit] = hiHead;
        if (loHead != null)
            hiHead.treeify(tab);
    }
}
```







## HashTable

与 JDK7 的 HashMap 基本一致；

线程安全的同步容器；

**&& 1、底层结构 | 初始化**

（1） 底层结构

```java
class Entry<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Entry<K,V> next;
}
```

（2） 初始化容量为 11

```java
 public Hashtable() {
 	this(11, 0.75f);
 }
```

**&& 2、操作**

**&&& hash | 定位**

直接通过取模实现；

效率较 HashMap 低；

```java
int hash = key.hashCode();
int index = (hash & 0x7FFFFFFF) % tab.length;
```



**&&& hash 冲突处理**

与 JDK7 中 HashMap 相同



**&&3、 扩容 | rehash**

容量为 `2*oldCapacity+1`；

初始容量和扩容机制都与 HashMap 不同；

```java
int newCapacity = (oldCapacity << 1) + 1;
```



**&&4、 迭代方式**

通过 `Enumerator` 实现

```java
<T> Iterator<T> getIterator(int type) {
    if (count == 0) {
        return Collections.emptyIterator();
    } else {
        return new Enumerator<>(type, true);
    }
}
```



**&& 5、其他**

（1） 与 HashMap的区别

① HashTable 设计上基于 Dictionary 实现，线程安全，执行效率低下，而 HashMap 基于 AbstractMap 实现，线程不安全，执行效率比 HashTable 高；

② NULL 值： HashMap 允许 NULL 值， HashTable 不允许；

③ init 及 hash 定位： HashTable 初始容量为 11，通过 % 的方式进行定位；

④ 迭代访问上： 两者实现的迭代不同，一个基于 Iterator，一个基于 Enumerator；





## LinkedHashMap

有序的 Map；

可先通过  HashMap 来进行统计一些必要的数据，之后通过对 HashMap 的 KEY, VALUE 进行一些排序，将其变为有序的，使用 LinkedHashMap 来将这些顺序串联起来，之后进行对应的逻辑处理；



**&& 1、底层结构**

（1） 全局属性

① accessOrder： 控制开启访问作为次序；

② head|tail： 控制按照插入 | 访问顺序迭代；

```java
transient LinkedHashMap.Entry<K,V> head;
transient LinkedHashMap.Entry<K,V> tail;
final boolean accessOrder;
```

（2） 节点

before | after 用于将节点连接起来方便遍历；

HashMap.TreeNode 扩展此节点；

```java
static class Entry<K,V> extends HashMap.Node<K,V> {       
    Entry<K,V> before, after;
    Entry(int hash, K key, V value, Node<K,V> next) {
    	super(hash, key, value, next);
    }
}
```



**&& 2、一些应用**

（1）  LRU Cache

通过 HashMap 的 putVal() 中提供的两个 hook 钩子函数实现特有的功能

根据 assessOrder 值不同，迭代出不同的结果。为 true，执行 LRU 顺序，访问过后移到链表尾部，头部为最近最久未使用节点； 为 false，执行插入顺序，与 List 语义相同；

```java
void afterNodeAccess(Node<K,V> e) { // move node to last
    LinkedHashMap.Entry<K,V> last;
    if (accessOrder && (last = tail) != e) {
        LinkedHashMap.Entry<K,V> p =
            (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
        p.after = null;
        if (b == null)
            head = a;
        else
            b.after = a;
        if (a != null)
            a.before = b;
        else
            last = b;
        if (last == null)
            head = p;
        else {
            p.before = last;
            last.after = p;
        }
        tail = p;
        ++modCount;
    }
}
```



在 put 等操作之后执行，当 removeEldestEntry() 方法返回 true 时会移除最晚的节点，也就是链表首部节点 first。

evict 只有在构建 Map 的时候才为 false，在这里为 true。

```java
void afterNodeInsertion(boolean evict) {     // possibly remove eldest
    LinkedHashMap.Entry<K,V> first;
    if (evict && (first = head) != null && removeEldestEntry(first)) {
        K key = first.key;
        removeNode(hash(key), key, null, false, true);
    }
}
```

removeEldestEntry() 默认为 false，如果需要让它为 true，需要继承 LinkedHashMap 并且覆盖这个方法的实现，这在实现 LRU 的缓存中特别有用，通过移除最近最久未使用的节点，从而保证缓存空间足够，并且缓存的数据都是热点数据。

```java
protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
    return false;
}
```



（1-2） LinkedHashMap 实现的线程安全的 LRUCache

```java
private static final float DEFAULT_LOAD_FACTOR = 0.75f;

private int capacity;
private LinkedHashMap<K,V> cache;

public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new LinkedHashMap((int) Math.ceil(capacity/DEFAULT_LOAD_FACTOR) + 1, DEFAULT_LOAD_FACTOR, true){
        private static final long serialVersionUID = 223232L;
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return cache.size() >= capacity;
        }
    };
}

public synchronized V get(K key) {
    return cache.get(key);
}

public synchronized V put(K key, V val) {
    return cache.put(key, val);
}
```





（2） 借助多态将 HashMap 中的数据按照一定的规则进行排序

如 HashMap 存放的是词频，可以根据词频进行排序，之后迭代访问时就是词频从高到低的序列；





**&& 3、其他**

（1） 与 HashMap 的区别

① 设计层面上： LinkedHashMap 是  HashMap 的子类；

② 底层结构及功能扩展上： LinkedHashMap 节点中添加了 before, after 用于保证顺序；

③ put 操作： LinkedHashMap 在继承的基础上重写 HashMap 中的 hook 方法，在 LinkedHashMap 中向哈希表中插入新 Entry的同时，还会通过 Entry 的 addBefore 方法将其链入到双向链表中。

⑤ get 操作，LinkedHashMap 中重写了 HashMap 中的 get 方法，通过 HashMap中的 getEntry 方法获取 Entry 对象。 在此基础上，进一步获取指定键对应的值。

④ 在扩容操作上，虽然 LinkedHashMap 完全继承了 HashMap 的 resize 操作，但是鉴于性能和 LinkedHashMap 自身特点的考量，  LinkedHashMap 对其中的重哈希过程(transfer 方法)进行了重写。





## TreeMap

红黑树的实现

// todo 





**&& 与 HashMap 的区别**

① 顺序性

② 存取效率上： O(1) VS O(logN)





## ConcurrentHashMap(7)

ConcurrentHashMap 和 HashMap 实现上类似，最主要的差别是 ConcurrentHashMap 采用了分段锁（Segment），每个分段锁维护着几个桶（HashEntry），多个线程可以同时访问不同分段锁上的桶，从而使其并发度更高（并发度就是 Segment 的个数）。



锁的优化： 减少锁粒度进行锁的优化，借助分段锁实现，段的个数为并发度。



**&& 1、底层结构 | init**

（1） 全局结构

segmentShift | segmentMask： 用于快速定位到 Segment 的位置

```java
final int segmentShift;
final int segmentMask;
final Segment<K,V>[] segments;     // keep object
static final int DEFAULT_CONCURRENCY_LEVEL = 16;
```

（2） Segment 结构

相当于一个带有锁的 HashMap(7)

① 继承自 `ReentrantLock` 从而实现并发加分段锁访问；

② 保存了 count 用于整个容器的统计，以及作为扩容的参考值；

默认情况下并发级别为 16；

```java
static final class Segment<K,V> extends ReentrantLock implements Serializable {
    static final int MAX_SCAN_RETRIES =
        Runtime.getRuntime().availableProcessors() > 1 ? 64 : 1;
    transient volatile HashEntry<K,V>[] table;
    transient int count;     // use for size()
    transient int modCount;
    transient int threshold;
    final float loadFactor;
}
```

（3） HashEntry 结构

```java
static final class HashEntry<K,V> {
    final int hash;
    final K key;
    volatile V value;
    volatile HashEntry<K,V> next;
}
```



**&& 2、操作**

**&&& hash & 定位**

先整体进行了多次异或操作，进行 hash 扰动，将每位都用上。

通过  hash 借助 sementShift 和 segmentMask 来定位到对应的段上。

```java
final Segment<K,V> segmentFor(int hash) {
	return segments[(hash >>> segmentShift) & segmentMask];
}
```

定位到 Entry，定位Segment使用的是元素的
hashcode通过再散列后得到的值的高位，而定位HashEntry直接使用的是再散列后的值。其目的是避免两次散列后的值一样，虽然元素在Segment里散列开了，但是却没有 HashEntry里散列开。

```java
hash >>> segmentShift) & segmentMask　　 // 定位Segment所使用的hash算法
int index = hash & (tab.length - 1);　　 // 定位HashEntry所使用的hash算法
```



**&&& get()**

无锁实现： 

基于 volatile 来替代锁实现，由 JMM 提供的 happen before 原则保证可见性；

通过 hash 得出对应的散列值，之后通过 hash 定位到对应的段；

在桶中再进行 hash 得到对应的桶，只有在读取到 NULL 值时才进行加锁；

```java
public V get(Object key) {
    int hash = hash(key.hashCode());
    return segmentFor(hash).get(key, hash);
}
// Segment 中的总数
transient volatile int count;
// HashEntry 中的值
volatile V value;
```



**&&& put()**

判断是否需要扩容，不是添加之后进行判断的，避免无效的扩容。

扩容，仅仅是对当前的 Segment 进行扩容，无需对整个容器扩容。

并发下协助扩容？？



**&&& size()**

在执行 size 操作时，需要遍历所有 Segment 然后把 count 累计起来。

可能的两步操作： 

① 先尝试通过 `RETRIES_BEFORE_LOCK` 次借助 segment 中 volatile 保存的 count 相加，基于 `modCount`  来实现的；

② 若无法则对整个容器进行加锁统计所有 Segment 的大小；

```java
static final int RETRIES_BEFORE_LOCK = 2;
public int size() {
    final Segment<K,V>[] segments = this.segments;
    int size;
    boolean overflow; // true if size overflows 32 bits
    long sum;         // sum of modCounts
        long last = 0L;   // previous sum
    int retries = -1; // first iteration isn't retry
    try {
        for (;;) {
            // 过多 CAS 转换成对所有 Segment 加锁获取
            if (retries++ == RETRIES_BEFORE_LOCK) {
                for (int j = 0; j < segments.length; ++j)
                    ensureSegment(j).lock(); // force creation
            }
            sum = 0L;
            size = 0;
            overflow = false;
            for (int j = 0; j < segments.length; ++j) {
                Segment<K,V> seg = segmentAt(segments, j);
                if (seg != null) {
                    sum += seg.modCount;
                    int c = seg.count;
                    if (c < 0 || (size += c) < 0)
                        overflow = true;
                }
            }
            // 连续两次得到的结果一致，则认为这个结果是正确的
            if (sum == last)
                break;
            last = sum;
        }
    } finally {
        if (retries > RETRIES_BEFORE_LOCK) {
            for (int j = 0; j < segments.length; ++j)
                segmentAt(segments, j).unlock();
        }
    }
    return overflow ? Integer.MAX_VALUE : size;
}
```



**&& 3、其他**

（1） JDK7 与 JDK8 中的比较*

① 底层结构： 链表过长转换成红黑树

② 同步机制： JDK7  采用分段锁实现，而 JDK8 可以有两种方案

- 尝试通过 CAS 来支持更高的并发度；
- 在 CAS 失败时通过内置锁 `synchronized` 锁住链表 | 红黑树的头结点；



## ConcurrentHashMap(8)



**&& 1、底层结构 | INIT**

（1） 底层结构

```java
transient volatile Node<K,V>[] table;
transient volatile Node<K,V>[] nextTable;
transient volatile long baseCount;
transient volatile int sizeCtl;
transient volatile int transferIndex;
transient volatile int cellsBusy;
transient volatile CounterCell[] counterCells;
```

（2） INIT 

五种初始化方式：

前四种同 HashMap 初始化方式；

⑤ 初始容量、负载因子、并发级别： 含有并发级别控制；

并发级别基本无用，初始化用于与 initialCapacity 进行比较取最大值；

与 JDK7 进行兼容的处理逻辑；



**&& 2、操作**

**&&& put()**

1、判断 Node[] 数组是否初始化，没有则进行初始化操作
2、通过 hash 定位数组的索引坐标，是否有 Node 节点，如果没有则使用 CAS 进行添加（链表的头节点），添加失败则进入下次循环。
3、检查到内部正在扩容，就帮助它一块扩容。
4、如果 f != null 则使用 synchronized 锁住 f 元素（链表/红黑二叉树的头元素）
  4.1如果是Node（链表结构）则执行链表的添加操作。
  4.2如果是TreeNode（树型结构）则执行树添加操作。
5、 判断链表长度已经达到临界值 8 (default)节点数超过这个值就需要将链表转换为树结构。

```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
    if (key == null || value == null) throw new NullPointerException();
    int hash = spread(key.hashCode());
    int binCount = 0;
    for (Node<K,V>[] tab = table;;) {          // may enter this loop many times
        Node<K,V> f; int n, i, fh;
        if (tab == null || (n = tab.length) == 0)         /* P1. not init */
            tab = initTable();
        else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {      /* P2. 第一个桶位置为空, CAS添加 */
            if (casTabAt(tab, i, null,
                         new Node<K,V>(hash, key, value, null)))
                break;                   // no lock when adding to empty bin
        }
        else if ((fh = f.hash) == MOVED)                      /* P3. 其他线程正在扩容 */
            tab = helpTransfer(tab, f);
        else {                         /* 发生hash 碰撞, 处理list OR tree, 只有此时才加锁, 其他情况都CAS循环尝试  */
            V oldVal = null;
            synchronized (f) {       /* 使用第一个元素作为锁, 粒度比 Segment 分段锁更加细 */
                if (tabAt(tab, i) == f) {
                    if (fh >= 0) {
                        binCount = 1;   /* 链表的计数器 */
                        for (Node<K,V> e = f;; ++binCount) {
                            K ek;
                            if (e.hash == hash &&
                                ((ek = e.key) == key ||
                                 (ek != null && key.equals(ek)))) {
                                oldVal = e.val;
                                if (!onlyIfAbsent)
                                    e.val = value;
                                break;
                            }
                            Node<K,V> pred = e;
                            if ((e = e.next) == null) {                       /* 遍历到链表的结尾，在链表尾部添加节点 */
                                pred.next = new Node<K,V>(hash, key,
                                                          value, null);
                                break;
                            }
                        }
                    }
                    else if (f instanceof TreeBin) {                       /* 为树形结构 */
                        Node<K,V> p;
                        binCount = 2;
                        if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                       value)) != null) {
                            oldVal = p.val;
                            if (!onlyIfAbsent)
                                p.val = value;
                        }
                    }
                }
            }
            if (binCount != 0) {
                if (binCount >= TREEIFY_THRESHOLD)           /* 判断是否需要树化, 在方法中还需处理当前是否到达树化的最小容量，否则进行扩容操作 */
                    treeifyBin(tab, i);
                if (oldVal != null)
                    return oldVal;
                break;
            }
        }
}
addCount(1L, binCount);
    return null;
}
```



// todo







## ThreadLocalMap

对于 ThreadLocal： 

当使用 ThreadLocal 维护变量时，ThreadLocal 为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本；

是一种无锁同步方案；

是一种用空间换取时间的方案；



**&& 1、底层结构** 

（1） 全局结构

```java
static final int INITIAL_CAPACITY = 16;
Entry[] table;
int size = 0;
int threshold;
```

（2） Entry

继承自 WeakReference ，在无活跃线程或栈中持有时，在 GC 时就会被回收；

节点只保存值，可看出 ThreadLocalMap 不是使用链地址法来解决冲突；

多个线程，只设置一个 ThreadLocal 变量，在这个线程中的ThreadLocal变量的值始终是只有一个的，即以前的值被覆盖了的！这里是因为Entry对象是以该ThreadLocal变量的引用为key的，所以多次赋值以前的值会被覆盖，特此注意！

```java
static class Entry extends WeakReference<ThreadLocal<?>> {
    Object value;
    Entry(ThreadLocal<?> k, Object v) {     /* ThreadLocal as key */
        super(k);
        value = v;
    }
}
```

（3） 定位

通过此来进行 hash 桶的定位；

```java
final int threadLocalHashCode = nextHashCode();
```

（4） 负载因子

> 0.66

空间利用率相较于 HashMap 的 0.75 较低，但加快查询；

同时配合开放地址法来快速定位到空闲的桶；

```java
private void setThreshold(int len) {
    threshold = len * 2 / 3;
}
```



**&& 2、操作**

**&&& hash**()

没有扰动函数，使用 AtomicInteger 自增实现??  todo

```java
// ThreadLocalMap.set 部分代码
for (Entry e = tab[i];
e != null;
e = tab[i = nextIndex(i, len)])
    
// ThreadLocal
private static int nextHashCode() {
	return nextHashCode.getAndAdd(HASH_INCREMENT);
}
private static AtomicInteger nextHashCode = new AtomicInteger();
```



**&&& hash 冲突**

通过开放地址法实现，线性探测





**&&& set()**

先获取到 ThreadLocal 键的 thresholdLocalHashCode ，以此来确定对应的桶下标；

如果在该位置正好与当前进行重合，直接覆盖；

如果该位置无元素，则将其放入该位置；

上面两个都不满足的情况下，使用线性探测法不断寻找到对应的满足上述两个条件的位置；

上述都不满足，创建一个节点，并清理一些桶位，之后进行重新 hash ；

```java
private void set(ThreadLocal<?> key, Object value) {

    // We don't use a fast path as with get() because it is at
    // least as common to use set() to create new entries as
    // it is to replace existing ones, in which case, a fast
    // path would fail  more often than not.

    Entry[] tab = table;
    int len = tab.length;
    int i = key.threadLocalHashCode & (len-1);

    for (Entry e = tab[i];          // bucket position
         e != null;
         e = tab[i = nextIndex(i, len)]) {
        ThreadLocal<?> k = e.get();

        if (k == key) {
            e.value = value;
            return;
        }

        if (k == null) {
            replaceStaleEntry(key, value, i);
            return;
        }
    }

    tab[i] = new Entry(key, value);
    int sz = ++size;
    if (!cleanSomeSlots(i, sz) && sz >= threshold)   // add node need to clean some object
        rehash();
}
```



**&& 3、扩容 | rehash**

（1） rehash

```java
void rehash() {
    expungeStaleEntries();
    // Use lower threshold for doubling to avoid hysteresis
    if (size >= threshold - threshold / 4)
        resize();
}
```

（2） resize

扩容为原来的两倍

```java
void resize() {
    Entry[] oldTab = table;
    int oldLen = oldTab.length;
    int newLen = oldLen * 2;
    Entry[] newTab = new Entry[newLen];
    int count = 0;

    for (int j = 0; j < oldLen; ++j) {
        Entry e = oldTab[j];
        if (e != null) {
            ThreadLocal<?> k = e.get();
            if (k == null) {
                e.value = null; // Help the GC
            } else {
                int h = k.threadLocalHashCode & (newLen - 1);
                while (newTab[h] != null)
                    h = nextIndex(h, newLen);
                newTab[h] = e;
                count++;
            }
        }
    }

    setThreshold(newLen);
    size = count;
    table = newTab;
}
```







**&& 其他**

（1）与 HashMap 的比较

① 底层结构： 

- ThreadLocalMap 只有数组，HashMap 通过数据 + 链表方式

- 节点为 弱引用，下一次 GC 被回收

② hash ： 并发下通过 AtomicInteger 实现??

③ hash 冲突处理： ThreadLocalMap 通过线性探测法实现的，HashMap 通过线性探测法实现的；





## WeakHashMap

**&& 1、底层结构**

（1）节点

与 Entry 继承 WeakReference，当前 Entry 需要引用队列来进行处理；

```java
// 成员
ReferenceQueue<Object> queue = new ReferenceQueue<>();
// 单独的 Entry
private static class Entry<K,V> extends WeakReference<Object> implements Map.Entry<K,V> {
        V value;
        final int hash;
        Entry<K,V> next;

        Entry(Object key, V value,
              ReferenceQueue<Object> queue,
              int hash, Entry<K,V> next) {    /* must use reference queue */
            super(key, queue);
            this.value = value;
            this.hash  = hash;
            this.next  = next;
        }
}
```



**&&操作**

**&&& hash | 定位**

通过四次异或来进行 hash 扰动，使其少依赖于原始的 hashCode()

```java
final int hash(Object k) {
    int h = k.hashCode();
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
}
int indexFor(int h, int length) {
    return h & (length-1);
}
```



**NULL**

对 NULL 的 KEY 处理机制，将 NULL 作为指向一个对象进行存储

```java
static final Object NULL_KEY = new Object();
private static Object maskNull(Object key) {
    return (key == null) ? NULL_KEY : key;
}
```





# Util

## Arrays

**&& sort**

算法的执行逻辑： 

- 小数据量使用 INSERT 排序

- 一定规模数据量使用 QUICK 排序

- 大数据量使用 MERGE 排序

- 并非所有大数据量都是 Merge Sort，在不具备结构性时转换成 Quick Sort；



（1） 归并排序

① 小数据量转快速排序

② 通过分配当前大小进行 merge

③ 判断排序数组的结构，不具有时使用快速排序

```java
static void sort(int[] a, int left, int right,
                     int[] work, int workBase, int workLen) {
    // Use Quicksort on small arrays
    if (right - left < QUICKSORT_THRESHOLD) {
        sort(a, left, right, true);
        return;
    }
    int[] run = new int[MAX_RUN_COUNT + 1];   /* aux space to merge */
    int count = 0; run[0] = left;
	// Check if the array is nearly sorted
    for (int k = left; k < right; run[count] = k) {
        // ...
       /*
        * The array is not highly structured,
        * use Quicksort instead of merge sort.
        */
        if (++count == MAX_RUN_COUNT) {
            sort(a, left, right, true);
            return;
        }
    }
	// ...
}
```



（2） 快速排序

① 小数据量插入排序

```java
static void sort(int[] a, int left, int right, boolean leftmost) {
    int length = right - left + 1;

    // Use insertion sort on tiny arrays
    if (length < INSERTION_SORT_THRESHOLD) {
        if (leftmost) {
        }
```



② 逻辑实现

通过双枢纽元分割实现；

类似 BFPRT 算法中对于枢纽元的选取，将原来期望的复杂度转换成确定的复杂度；

```
   left part           center part                   right part
 +--------------------------------------------------------------+
 |  < pivot1  |  pivot1 <= && <= pivot2  |    ?    |  > pivot2  |
 +--------------------------------------------------------------+
               ^                          ^       ^
               |                          |       |
              less                        k     great
              
              
   left part         center part                  right part
 +----------------------------------------------------------+
 | == pivot1 |  pivot1 < && < pivot2  |    ?    | == pivot2 |
 +----------------------------------------------------------+
              ^                        ^       ^
              |                        |       |
             less                      k     great
             
             
 Partitioning degenerates to the traditional 3-way
 (or "Dutch National Flag") schema:

   left part    center part              right part
 +-------------------------------------------------+
 |  < pivot  |   == pivot   |     ?    |  > pivot  |
 +-------------------------------------------------+
              ^              ^        ^
              |              |        |
             less            k      great
```



（3） 插入排序

为快速排序中的子过程实现；

```java
if (length < INSERTION_SORT_THRESHOLD) {
    if (leftmost) {
        /*
        * Traditional (without sentinel) insertion sort,
        * optimized for server VM, is used in case of
        * the leftmost part.
        */
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
    } else {
        /*
        * Skip the longest ascending sequence.
        */
        do {
            if (left >= right) {
                return;
            }
        } while (a[++left] >= a[left - 1]);

        /*
        * Every element from adjoining part plays the role
        * of sentinel, therefore this allows us to avoid the
        * left range check on each iteration. Moreover, we use
        * the more optimized algorithm, so called pair insertion
        * sort, which is faster (in the context of Quicksort)
        * than traditional implementation of insertion sort.
        */
        for (int k = left; ++left <= right; k = ++left) {
            int a1 = a[k], a2 = a[left];

            if (a1 < a2) {
                a2 = a1; a1 = a[left];
            }
            while (a1 < a[--k]) {
                a[k + 2] = a[k];
            }
            a[++k + 1] = a1;

            while (a2 < a[--k]) {
                a[k + 1] = a[k];
            }
            a[k + 1] = a2;
        }
        int last = a[right];

        while (last < a[--right]) {
            a[right + 1] = a[right];
        }
        a[right + 1] = last;
    }
    return;
}
```





**&& binarySearch**







## Collections

**&& sort**

JDK8 中借助 List 中自带的 sort() 函数调用实现；







**&& binarySearch**

对 List 进行二分搜索

根据底层是数组还是链表采用不同的处理：

① 数组： 数组随机访问定位实现

② 链表：  接着 ListIterator 实现二分查找



**&& stream()**









