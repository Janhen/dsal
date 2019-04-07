# 排序

## 选择排序

（1） 算法:

选择数组中最小的元素, 将它与数组的第一个元素交换, 之后开始次小元元素...
（2） 复杂度

比较: N²/2,  交换: N
最坏: O(n²)

最好: O(n²)，

平均: O(n²)

（3） 性质:

- 运行时间与输入无关；
- 不稳定；
- 原地排序；

```java
void selectSort(int[] arr) {
    if (arr == null || arr.length < 2) return;
    for (int i = 0; i < arr.length; i ++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j ++) {
            if (arr[j] < arr[minIndex])
                minIndex = i;
        }
        swap(arr,i, minIndex);
    }
}
```



## 冒泡排序

（1） 算法: 从左到右不断交换相邻逆序的元素, 经过一次循环确定最后一个元素到达最右侧
存在传入数组已经有序的情况



（2） 复杂度分析:
  最坏: O(n²)
  最好: O(n), 集合有序, 需要进行一次冒泡
  平均: O(n²)



（3） 性质：

- 元素交换的次数为固定值, 原始数据的逆序度   需要三次赋值操作；

- 稳定；

- 原地排序；
  
  

**1、基础冒泡**

```java
void bubbleSort(int[] arr) {
    // check
    for (int i = arr.length - 1; i > 0; i --)  // insure N-1~1 position, 0 must in correct position
        for (int j = 0; j < i; j ++)
            if (arr[j] > arr[j + 1])
                swap(arr, j, j + 1);
}
```



**2、 通过判定之后是否有序来进行优化**

```java
void bubbleSort(int[] arr) {
    // check
    boolean hasSorted = false;
    for (int i = arr.length - 1; i > 0 && !hasSorted; i --) {  // except bad condtion
        hasSorted = true;
        for (int j = 0; j < i; j ++) {
            if (arr[j] > arr[j + 1]) {    // when equal not modify original order
                hasSorted = false;
                swap(arr, j, j + 1);
            }
        }
    }
}
```



## 插入排序

（1）算法: 将数组分为两部分，将后部分元素逐一与前部分元素比较，如果前部分元素比array[i]小，就将前部分元素往后移动。当没有比array[i]小的元素，即是合理位置，在此位置插入array[i]。





（2） 复杂度分析
最坏: O(n²), 数组逆序, 需要 N²/2 比较  N²/2 交换
最好: O(n), 正序, 需要     N-1  比较    0  次交换
平均:   O(n^2)  N²/4  比较  N²/4 交换



（3） 性质:

- 复杂度取决于数组的初始顺序， 移动次数为逆序对的数量；

- 稳定；

- 原地排序；

  

**1、基础插入排序**

```java
public static void insertSortB(int[] arr) {
    if (arr == null || arr.length < 2)
        return;
    for (int i = 1; i < arr.length; i++)
        for (int j = i; j > 0 && arr[j] < arr[j - 1]; j --)
            swap(arr, j, j - 1);
}
```



**2、 使用赋值操作替换交换操作优化**

```java
void insertSort(int[] arr) {
    if (arr == null || arr.length < 2) return;
    for (int i = 1; i < arr.length; i ++) {
        int e = arr[i], j;                // e current element, j should put position
        for (j = i; j > 0; j --) {
            if (e < arr[j-1])
            	arr[j] = arr[j-1];
        }
        arr[j] = e;
    }
}
```



## 希尔排序

（1） 算法：使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。 

（2） 复杂度分析： 希尔排序的运行时间达不到平方级别，使用递增序列 1, 4, 13, 40, ... 的希尔排序所需要的比较次数不会超过 N 的若干倍乘于递增序列的长度。
（3） 性质：

- 交换不相邻元素，将逆序数量减少大于1；

- 基于原来的插入排序；

- 不稳定；

- 原地排序；

```java
void shellSort(int[] arr) {
    int N = arr.length;
    int h = 1;
    while (h < N/3) h = 3 * h + 1;
    while (h > 0) {
        for (int i = h; i < N; i += h) {
            for (int j = i; j >= h; j -= h) {
                if (arr[j] < arr[j-h]) swap(arr, j, j - h);
                else break;
            }
        }
        h /= 3;
    }
}
```



## 桶 | 基数 | 计数排序

**&& 桶排序**

 桶排序   O(n)
     使用桶排序来有10GB的订单数据，我们希望按订单金额（假设金额都是正整数）进行排序，但是我们的内存有限，只有几百MB，没办法一次性把10GB的数据都加
    载到内存中。这个时候该怎么办呢？





金额∈ [1, 10W]

```
针对这些划分之后还是比较大的文件，我们可以继续划分，比如，订单金额在1元到1000元之间的比较多，我们就将这个区间继续划分为10个小区间，1元
```

到100元，101元到200元，201元到300元…901元到1000元。如果划分之后，101元到200元之间的订单还是太多，无法一次性读入内存，那就继续再划分，直到所
有的文件都能读入内存为止





**&& 基数排序**

 O(dn)   d 是维度
假设我们有10万个手机号码，希望将这10万个手机号码从小到大排序，你有什么比较快速的排序方法呢？
    先按照最后一位来排序手机号码，然后，再按照倒数第二位重新排序，以此类推，最后按照第一位重新排序。经过11次排序之后，手机号码就都有序了。

我们可以把所有的单词补齐到相同长度，位数不够的可以在后面补“0”，因为根据ASCII值，所有字母都大于“0”，所以补“0”不会影响到原有的大小顺
序。这样就可以继续用基数排序了。

基数排序对要排序的数据是有要求的，
需要可以分割出独立的“位”来比较，而且位之间有递进的关系，如果a数据的高位比b数据大，那剩下的低位就不用比较了。
除此之外，每一位的数据范围不能太大，要可以用线性排序算法来排序，否则，基数排序的时间复杂度就无法做到O(n)了。





**&& 计数排序**

计数排序：
    我个人觉得，计数排序其实是桶排序的一种特殊情况。当要排序的n个数据，所处的范围并不大的时候，比如最大值是k，我们就可以把数据划分成k个桶。每个桶
    内的数据值都是相同的，省掉了桶内排序的时间。
    我们都经历过高考，高考查分数系统你还记得吗？我们查分数的时候，系统会显示我们的成绩以及所在省的排名。如果你所在的省有50万考生，如何通过成绩快
    速排序得出名次呢？
    考生的满分是900分，最小是0分，这个数据的范围很小，所以我们可以分成901个桶，对应分数从0分到900分。根据考生的成绩，我们将这50万考生划分到
    这901个桶里。桶内的数据都是分数相同的考生，所以并不需要再







 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     O(n+k)    k 是数据范围



 查找数组中数据的范围
// 申请一个计数数组c，下标大小[0,max]
 计算每个元素的个数，放入c中
 依次累加
 临时数组r，存储排序之后的结果
 计算排序的关键步骤，有点难理解
 将结果拷贝给a数组









## 快速排序

（1） 思想: 分治, 分区



（2） 复杂度:
由每次选取的分割点控制
最好: 每次分割点都为中间的元素， O(logN)
最坏: 每次分割点都为最后元素   O(n²)



（3） 性质:

- 每趟排序就有一个元素排在了最终的位置上，第n趟结束，**至少**有n个元素已经排在了最终的位置上；

- 非稳定

- 原地排序





（4） 归并 VS 快排:
归并由下到上, 先处理子问题之后合并，快排由上到下, 先进行分区然后处理子问题；

归并非原地排序，需要辅助空间，快排通过原地分区函数实现原地排序；

归并排序为稳定的排序，保留原来相同值的顺序；



（5） 优化:
 三数取中法
 随机选取法





**1、Random & Insert**

```java
void quickSort(int[] arr) {
    if (arr == null || arr.length < 2) return;
    quickSort(arr, 0, arr.length);
}
void quickSort(int[] arr, int lo, int hi) {
    if (hi - lo < INSERTION_SORT_THRESHOLD) {
        insertSort(arr, lo, hi);
        return;
    }
    int j = partition(arr, lo, hi);
    quickSort(arr, lo, j - 1);
    quickSort(arr, j +1, hi);
}
```

快速选择；

```java
int partition(int[] arr, int lo, int hi) {
    swap(arr,lo,lo +(int) Math.random() * (hi-lo+1);
    int pivot = arr[lo];
    int i = lo, j = hi + 1;
    while (true) {
		while (arr[++ i] < pivot) if (i == hi) break;
        while (arr[-- j] > pivot) if (j == lo) break;
        if (i >= j) break;
        swap(arr, i, j);
    }
    swap(arr, j, lo);
}
```



**2、三路快排**

对重复元素较多的情形优化；

函数返回重复元素第一次和最后一次出现位置；

类似荷兰国旗问题的处理；

```java
int[] partition(int[] arr, int lo,int hi) {
    int pivot = arr[lo];
    int lt = lo - 1, gt = hi + 1;
    int i = lo;
    while (i < gt) {              // 各个区间的语义
        if (arr[i] == pivot) 
            i ++;
        else if (arr[i] < pivot)
            swap(arr, i ++, ++ lt);
        else 
            swap(arr, i, -- gt);
    }
    return new int[]{lt+1, gt-1};
}

```



**3、 三数取中值**

枢纽元的选取上进行优化；

选取边界和中间数将三处进行排序，选择中间元素作为枢纽元，并放入 [hi-1] 位置；

之后 [lo], [hi] 可以作为快排内循环的哨兵；

```java
// sort three element AND put hi-1 position
int medianOf3(int[] arr, int lo, int hi) {
    int mid = lo + (hi - lo) / 2;
    if (arr[lo] > arr[mid]) swap(arr, lo, mid);
    if (arr[lo] > arr[hi]) swap(arr, lo, hi);
    if (arr[mid] > arr[hi]) swap(arr, mid, hi);
    swap(arr, mid, hi - 1);
    return arr[hi - 1];              // pivot is mid value, and position is hi-1
}
```

```java
int partition(int[] arr, int lo, int hi, int pivot) {  // pivot original position hi - 1
    int i = lo, j = hi - 1;
    while (true) {
        while (arr[++ i] < pivot);   // NOTE: [hi-1] as sentinel
        while (arr[-- j] > pivot);   // [lo] as sentinel
        if (i >= j) break;
        swap(arr, i, j);
    }
    swap(arr, i, hi - 1);  // put pivot as correct position
    return i;
}
```

```java
void quickSort(int[] arr, int lo, int hi) {
    if (hi - lo <= INSERTITION_SORT_THRESHOLD) {
        insertSort(arr, lo, hi);
        return;
    }
    int median = medianOf3(arr, lo, hi);
    int i = partition(arr, lo, hi, median);
    quickSort(arr, lo, i - 1);
    quickSort(arr,i +1, hi);
}

```



## 归并排序

（1） 算法





（2） 复杂度

大部分为 O(NlogN)

> T(n) = 2*T(n/2) + n
>     = 2*(2*T(n/4) + n/2) + n = 4*T(n/4) + 2*n
>     = 4*(2*T(n/8) + n/4) + 2*n = 8*T(n/8) + 3*n
>     = 8*(2*T(n/16) + n/8) + 3*n = 16*T(n/16) + 4*n
>     ......
>     = 2^k * T(n/2^k) + k * n



（3） 性质

- 大数据量情况下出现无法分配空间情况；

- 稳定的排序；

- 非原地排序；





**1、普通归并排序**

① 对排序的两个子数组 [lo,mid], [mid+1, hi]，在 [mid] >= [mid+1] 数组整体有序情况下跳过合并；

② 分配当前两个数组对应的数组空间作为辅助；

```java
void mergeSort(int[] arr, int lo, int hi) {
    if (hi - lo < INSERTITION_SORT_THRESHOLD) {
        insertSort(arr, lo, hi);
        return;
    }
    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, lo, mid);
    mergeSort(arr, mid + 1, hi);
    if (arr[mid] > arr[mid + 1])    // optimize for ordered array
    	merge(arr, lo, mid, hi);
}
```

```java
void merge(int[] arr, int lo, int mid, int hi) {
    int[] aux = new int[hi - lo + 1];
    int i = lo, j = mid + 1;
    for (int k = 0; k < aux.length; k ++) {
        if (i > mid) aux[k] = arr[j ++];
        else if (j > hi) aux[k] = arr[i ++];
        else if (arr[i] < arr[j]) aux[k] = arr[i ++];
        else aux[k] = arr[j ++];
    }
    for (int k = 0; k < aux.length; k ++) 
       arr[k + lo] = aux[k];
}
```



**2、 自底向上的归并排序**

考虑处理两种情况：

```html
P1  __ __ | __ __ | __ __ | _       i + sz < arr.length to control
P2  __ __ | __ __ | __ __ | __ _    min{i + sz + sz - 1, arr.length - 1} to control
```

sz 为两个子数组的区间大小

```java
void mergeSort(int[] arr) {
    if (arr == null || arr.length < 2) return;
    int N = arr.length;
    for (int sz = 1; sz < N;  sz += sz) {
        for (int i = 0; i + sz < N; i += sz + sz) {  // two array begin
            merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N-1));
        }
    }
}
```



## 堆排序

（1） 算法



（2） 复杂度

O(logN)



（3） 性质

- 无法利用到现代处理器的缓存局部性原理，一般不使用；

- 不稳定；

- 原地排序，适用于嵌入式系统中内存小的情况；





**1、 基础堆排**

先通过向堆中不断插入元素，向上调整形成堆结构；

之后不断删除堆顶元素实现排序；

```java
void heapSort(int[] arr) {
    if (arr == null || arr.length < 2)
        return;
    for (int i = 0; i < arr.length; i ++)
        heapify(arr, i);                            // heapInsert
    int N = arr.length;
    while (N > 0) {                              // heapify: delete and adjust heap structure
        swap(arr, -- N, 0);
        sink(arr, N, 0);
    }
}
```

```java
void heapify(int[] arr, int k) {
    while (arr[k] > arr[(k - 1) / 2]) {
        swap(arr, k, (k - 1) / 2);
        k = (k - 1) / 2;
    }
}
```

```java
void sink(int[] arr, int N, int k) {
    while (2 * k + 1 < N) {
        int j = 2 * k + 1;
        if (j + 1 < N && arr[j] < arr[j + 1])
            j ++;
        if (arr[k] >= arr[j])
            break;
        swap(arr, k, j);
        k = j;
    }
}
```



**2、算法优化**

与 java.util.ProrityQueue 中实现逻辑相同

① 通过 sink 向下调整进行优化；

② 下城操作中使用赋值替代交换，常数级优化；

```java
void heapSort(int[] arr) {
    if (arr == null || arr.length < 2)
        return;
    int N = arr.length;
    for (int i = (N - 2)  / 2; i >= 0; i --)      // build heap
        sink(arr, i, N);
    while (N > 0) {                   // delete max ⇔ put into last position
        swap(arr, 0, -- N);
        sink(arr, 0, N);
    }
}
```

```java
void sink(int[] arr, int k, int N) {
    int val = arr[k];
    while (k * 2 + 1 < N) {
    	int j = k * 2 + 1;
   		if (j + 1 < N && arr[j] < arr[j + 1])
   			 j = j + 1;
        if (val >= arr[j])  break;
        arr[k] = arr[j];
        k = j;
    }
    arr[k] = val;
}
```





## 总结

（1）各个排序比较

|       算法       | 稳定性 |          时间复杂度          | 空间复杂度 |            备注             |
| :--------------: | :----: | :--------------------------: | :--------: | :-------------------------: |
|     选择排序     |   ×    |        N<sup>2</sup>         |     1      |                             |
|     冒泡排序     |   √    |        N<sup>2</sup>         |     1      |                             |
|     插入排序     |   √    |      N \~ N<sup>2</sup>      |     1      |     与初始的逆序度相关      |
|     希尔排序     |   ×    | N 的若干倍乘于递增序列的长度 |     1      | 每次交换逆序度数量减少大于1 |
|     快速排序     |   ×    |            NlogN             |    logN    |                             |
| 三向切分快速排序 |   ×    |          N \~ NlogN          |    logN    |    适用于有大量重复主键     |
|     归并排序     |   √    |            NlogN             |     N      |                             |
|      堆排序      |   ×    |            NlogN             |     1      |     无法利用局部性原理      |

（2） JDK 中的排序

见 [Java-Java 集合源码]()





# 查找

## 二分查找

（1） 算法



（2） 复杂度

O(logN)

（3）性质

- 适用于处理 ceil、floor 等操作；

- 配合索引相当于是实现了跳表结构；



**1、 普通二分查找**

```java
int binarySearch(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target)
            return mid;
        if (arr[mid] < target)
            lo = mid + 1;
        else
            hi = mid - 1;
    }
    return -1;
}
```



**2、 二分查找-最先&最后**

（1） 查找含有重复元素的数组集合中元素第一次出现的位置

在相等的情况下，进行判断决定是否进行缩小范围或找到对应的值；

```java
int binarySearchFirst(int[] nums, int lo, int hi, int aim) {
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == aim) {
            if (mid == 0 || nums[mid-1] != nums[mid])  return mid;
            else hi = mid - 1;
        } else if (nums[mid] < aim) {
            lo = mid + 1;
        } else
            hi = mid - 1;
    }
    return -1;
}
```

（2） 查找含有重复元素的数组集合中元素最后一次出现的位置

```java
int binarySearchLast(int[] nums, int key, int lo, int hi) {
    while (lo <= hi) {
        int mid = (hi - lo) / 2 + lo;
        if (nums[mid] == key) {
            if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) return mid;
            else lo = mid + 1;
        } else if (nums[mid] < key) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return -1;
}
```



**3、 二分查找-大于&小于**

（1） 查找小于等于给定元素的最小元素在数组中的位置

```java
public int binarySearchFloor(int[] nums, int key, int lo, int hi) {
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] <= key) {
            if (mid == nums.length-1 || nums[mid+1] > key) return mid;
            else lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return -1;
}
```

（2） 查找大于等于给定元素的最小元素在数组中的位置

```java
public int binarySearchCeil(int[] nums, int key, int lo, int hi) {
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] >= key) {
            if (mid == 0 || nums[mid-1] < key) return mid;
            else hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return -1;
}
```



**4、 带偏移的二分查找**

用于旋转数组的查找；

```java
int binarySearchOffset(int[] nums, int key, int offset) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int realMid = (mid + offset) % nums.length;
        if (nums[realMid] == key) {
            return mid;
        } else if (nums[mid] < key) {
            lo = mid + 1;
        } else
            hi = mid - 1;
    }
    return -1;
}
```

