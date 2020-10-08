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
