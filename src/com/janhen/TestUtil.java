package com.janhen;

import com.janhen.coding.leetcode.structures.TreeNode;

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

    public static String rate(double... times) {
        return rate(3, times);
    }

    public static String rate(int scale, double... times) {
        // int scale = 3;
        double min = times[0];
        for (int i = 1; i < times.length; i++)
            min = Math.min(min, times[i]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
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
        for (int i = 0; i < objs.length; i++)
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

    public static void printf(String format, Object... args) {
        System.out.println(count++ + ", " + String.format(format, args));
    }

    public static void log(String format, Object... args) {
        System.out.print(new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date()) + " ");
        System.out.println(MessageFormat.format(format, args));
    }


    /* -------------------------- GENERATE ------------------------ */

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1)) + rangeL;
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
        for (int index = 0; index < parts.length; index++) {
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
        while (!nodeQueue.isEmpty()) {
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
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += node.val + ", ";
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
        for (int i = 1; i <= k; i++)
            res = res * (n - k + i) / i;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(5, 3));
    }

    // String AND Integer to,  0~255
    public static boolean isValid(String str) {
        return str.length() <= 3 && str.length() > 0 &&
          ((str.length() <= 1 || str.charAt(0) != '0') &&
            Integer.parseInt(str) <= 255);
    }

    /* --------------------------------- STRING ------------------------ */

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // substring [l,r] is or not palindrome
    public static boolean isPalindrome(String str, int l, int r) {
        if (l == r)
            return true;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--))
                return false;
        }
        return true;
    }

    public static String reverse(String str) {
        char[] chs = str.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            i++;
            j--;
        }
        return new String(chs);
    }

    public static String sort(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    /* ---------------------==------------ ARRAY -------------------- */

    public static void rightShift(int[] arr, int k) {
        int N = arr.length;
        k %= N;
        reverse(arr, 0, N - k - 1);
        reverse(arr, N - k, N - 1);
    }

    public static void reverse(int[] arr, int lo, int hi) {
        while (lo < hi)
            swap(arr, lo++, hi--);
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /* ---------------------==------------ ARRAY -------------------- */

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top != c) return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 数组来表示数字
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {   // use array to express num, [n-1] is bit
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        return nums;
    }

    /* ------------------------ Bit ------------------- */

    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int flip(int n) {
        return n ^ 1;
    }

    public static <K, V> PriorityQueue<Map.Entry<K, V>> sort2PQByEntryCmp(Map<K, V> map, Comparator<Map.Entry> entryComparator) {
        PriorityQueue<Map.Entry<K, V>> pq = new PriorityQueue<>(map.size(), entryComparator);
        pq.addAll(map.entrySet());
        return pq;
    }

    /* ------------------------ Map ------------------- */

    public static <K, V> Map<K, V> sort2LinkedMapByEntryCmp(Map<K, V> map, Comparator<Map.Entry<K, V>> entryComparator) {
        List<Map.Entry<K, V>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(entryComparator);
        Map<K, V> linkedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            linkedMap.put(entry.getKey(), entry.getValue());
        }
        return linkedMap;
    }

    public int numOfnthBit(int num, int n) {
        return num & (1 << n);
    }
}
