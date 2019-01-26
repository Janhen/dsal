package com.janhen.structures.heapAndpriorityQueue.indexHeap.reverseIndex;

import com.janhen.structures.heapAndpriorityQueue.IIndexHeap;

import java.util.*;
import java.lang.*;

// 最大索引堆
public class IndexMaxHeap<E extends Comparable<E>> implements IIndexHeap<E> {

    protected E[] data;      // 最大索引堆中的数据
    protected int[] indexes;    // 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    protected int[] reverse;    // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    protected int N;
    protected int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public IndexMaxHeap(int capacity){
        data = (E[])new Comparable[capacity+1];
        indexes = new int[capacity+1];
        reverse = new int[capacity+1];
        for( int i = 0 ; i <= capacity ; i ++ )
            reverse[i] = 0;

        N = 0;
        this.capacity = capacity;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    public void insert(int i, E item){

        assert N + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(i);

        i += 1;
        data[i] = item;
        indexes[N+1] = i;
        reverse[i] = N + 1;
        N ++;

        shiftUp(N);
    }

    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public E extractMax(){
        assert N > 0;

        E ret = data[indexes[1]];
        swapIndexes( 1 , N );
        reverse[indexes[N]] = 0;
        N --;
        shiftDown(1);

        return ret;
    }

    // 从最大索引堆中取出堆顶元素的索引
    public int extractMaxIndex(){
        assert N > 0;

        int ret = indexes[1] - 1;
        swapIndexes( 1 , N );
        reverse[indexes[N]] = 0;
        N --;
        shiftDown(1);

        return ret;
    }

    // 获取最大索引堆中的堆顶元素
    public E getMax(){
        assert N > 0;
        return data[indexes[1]];
    }

    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert N > 0;
        return indexes[1]-1;
    }

    // 看索引i所在的位置是否存在元素
    boolean contain( int i ){
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i+1] != 0;
    }

    // 获取最大索引堆中索引为i的元素
    public E getElement( int i ){
        assert contain(i);
        return data[i+1];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change( int i , E newItem ){

        assert contain(i);

        i += 1;
        data[i] = newItem;

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp( reverse[i] );
        shiftDown( reverse[i] );
    }

    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    private void swapIndexes(int i, int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }

    //********************
    //* 最大索引堆核心辅助函数
    //********************

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftUp(int k){

        while( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0 ){
            swapIndexes(k, k/2);
            k /= 2;
        }
    }

    // 索引堆中, 数据之间的比较根据data的大小进行比较, 但实际操作的是索引
    private void shiftDown(int k){

        while( 2*k <= N ){
            int j = 2*k;
            if( j+1 <= N && data[indexes[j+1]].compareTo(data[indexes[j]]) > 0 )
                j ++;

            if( data[indexes[k]].compareTo(data[indexes[j]]) >= 0 )
                break;

            swapIndexes(k, j);
            k = j;
        }
    }

    // 测试索引堆中的索引数组index和反向数组reverse
    // 注意:这个测试在向堆中插入元素以后, 不进行extract操作有效
    public boolean testIndexes(){

        int[] copyIndexes = new int[N+1];
        int[] copyReverseIndexes = new int[N+1];

        for( int i = 0 ; i <= N ; i ++ ) {
            copyIndexes[i] = indexes[i];
            copyReverseIndexes[i] = reverse[i];
        }

        copyIndexes[0] = 0;
        copyReverseIndexes[0] = 0;
        Arrays.sort(copyIndexes);
        Arrays.sort(copyReverseIndexes);

        // 在对索引堆中的索引和反向索引进行排序后,
        // 两个数组都应该正好是1...N这N个索引
        boolean res = true;
        for( int i = 1 ; i <= N ; i ++ )
            if( copyIndexes[i-1] + 1 != copyIndexes[i] ||
                    copyReverseIndexes[i-1] + 1 != copyReverseIndexes[i] ){
                res = false;
                break;
            }

        if( !res ){
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    // 测试 IndexMaxHeap
    public static void main(String[] args) {

        int N = 1000000;
        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<Integer>(N);
        for( int i = 0 ; i < N ; i ++ )
            indexMaxHeap.insert( i , (int)(Math.random()*N) );

        assert indexMaxHeap.testIndexes();
    }
}