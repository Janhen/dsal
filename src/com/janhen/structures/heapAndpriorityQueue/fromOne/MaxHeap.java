package com.janhen.structures.heapAndpriorityQueue.fromOne;

import java.lang.*;

public class MaxHeap<E extends Comparable> {

    protected E[] data;
    protected int count;  // ★ last element
    protected int capacity;

    public MaxHeap(int capacity){
        data = (E[])new Comparable[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    // build heap
    public MaxHeap(E arr[]){

        int n = arr.length;

        data = (E[])new Comparable[n+1];
        capacity = n;

        for( int i = 0 ; i < n ; i ++ )
            data[i+1] = arr[i];
        count = n;

        for( int i = count/2 ; i >= 1 ; i -- )
            shiftDown(i);
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void insert(E item){

        assert count + 1 <= capacity;
        data[count+1] = item;
        count ++;
        shiftUp(count);
    }

    public E extractMax(){
        assert count > 0;
        E ret = data[1];

        swap( 1 , count );
        count --;
        shiftDown(1);

        return ret;
    }

    public E getMax(){
        assert( count > 0 );
        return data[1];
    }


    private void swap(int i, int j){
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    // current i:
    //   - parent: i/2
    //   - left child: i*2
    //   - right child: i*2+1
    private void shiftUp(int k){

        while( k > 1 && data[k/2].compareTo(data[k]) < 0 ){
            swap(k, k/2);
            k /= 2;
        }
    }

    private void shiftDown(int k){

        while( 2*k <= count ){
            int j = 2*k; // 在此轮循环中,data[k]和data[j]交换位置
            if( j+1 <= count && data[j+1].compareTo(data[j]) > 0 )
                j ++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值

            if( data[k].compareTo(data[j]) >= 0 ) break;
            swap(k, j);
            k = j;
        }
    }
}
