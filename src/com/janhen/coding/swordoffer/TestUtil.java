package com.janhen.swordoffer;

import com.janhen.swordoffer.structures.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestUtil {

    public static int[][] CONSTS = {
            {2, 3, 4, 7, 6, 1},   // 0
            {11, 22, 33, 44, 55}, // 1
            {1, 2, 2, 2, 3, 4, 5, 5, 6},  // 2
            {2, 2, 2, 2, 2, 2},   // 3
            {},             // 4
            null,           // 5
            {-23, -3, 1, 44, 55}, // 1
            {2}
    };

    private static int count = 0;

    public static String rate(double ... times) {
        return rate(3, times);
    }

    public static String rate(int scale, double ... times) {
        // int scale = 3;
        double min = times[0];
        for (int i = 1; i < times.length; i ++)
            min = Math.min(min, times[i]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.length; i ++) {
            // double d = Math.round(times[i] / min * 1E3) / 1E3;
            double d = Math.round(times[i] / min * Math.pow(10, scale)) / Math.pow(10, scale);
            sb.append(i == times.length - 1 ? d : d + " : ");
        }
        return sb.toString();
    }

    /* -------------------- PRINT ---------------------- */

    public static <E> void printList(List<E> list) {
        for (E e : list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static <E> void printDouList(List<List<E>> list) {
        for (List<E> subList : list) {
            for (E e : subList) {
                System.out.print(e);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void printArr(Object[] objs) {
        System.out.print("[");
        for (int i = 0; i < objs.length; i ++)
            System.out.print(i != objs.length - 1 ? objs[i] + "," : objs[i] + "]");
        System.out.println();
    }

    public static void printObjectArray(Object[] objs) {
        System.out.println(Arrays.toString(objs));
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null)
            return;

        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);

        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void printf(String format, Object ... args) {
        System.out.println(count ++ + ", " + String.format(format, args));
    }

    public static void log(String format, Object ... args) {
        System.out.print(new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date()) + " ");
        System.out.println(MessageFormat.format(format, args));
    }


    /* -------------------------- GENERATE ------------------------ */

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {

        assert n > 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void run(String className, String methodName, Class<?>[] parameterTypes, Object[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Object instance = clazz.newInstance();
        Method method = clazz.getMethod(methodName, parameterTypes);
        method.invoke(instance, args);
    }


    /* ------------------------ MATH ------------------------ */

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int combine(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i ++)
            res = res * (n-k+i)/i;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(5, 3));
    }
}
