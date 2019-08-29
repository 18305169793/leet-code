package algorithm;

import utils.ListNode;

import java.util.*;

public class Recursion {
    public static void main(String[] args) {

    }

    /**
     * reverse a string,using recursing
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        if(s!=null && len>1){
            helper(0,s);
        }
    }
    private void helper(int index,char[] s){
        if(index < s.length/2){
            char flag = s[index];
            s[index] = s[s.length-1-index];
            s[s.length-1-index] = flag;
            helper(index+1,s);
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode headNext = head.next;
        head.next = swapPairs(headNext.next);
        headNext.next = head;
        return headNext;

    }

    /**
     *  杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list;
       if(numRows==0){
           list = new ArrayList<List<Integer>>();
           return list;
       }else if(numRows==1){
           list = new ArrayList<List<Integer>>();
           ArrayList<Integer>inList = new ArrayList<Integer>();
           inList.add(1);
           list.add(inList);
           return  list;
       }
       list= generate(numRows-1);
       ArrayList<Integer> former= (ArrayList<Integer>) list.get(list.size()-1);
       ArrayList<Integer> later = new ArrayList<Integer>();
        for (int i = 0; i <numRows ; i++) {
            if(i==0||i==(numRows-1)){
                later.add(i,1);
            }else{
                later.add(i,(former.get(i-1)+former.get(i)));
            }
        }
        list.add(later);
        return list;
    }

    /**
     * 杨辉三角返回某行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0){
            return new ArrayList<Integer>();
        }else {
            ArrayList<Integer> receive = (ArrayList<Integer>) getRow(rowIndex - 1);
            if (rowIndex == 0) {
                receive.add(1);
            } else {
                int seed = 1;
                int buff = 0;
                for (int i = 1; i <= rowIndex; i++) {
                    if (i == rowIndex) {
                        receive.add(i, 1);
                    } else {
                        buff = receive.get(i);
                        receive.set(i, (seed + buff));
                        seed = buff;
                    }
                }
            }
            return receive;
        }
    }

    /**
     * 链表反转_递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = reverseList(head.next);// 一直返回一个头
        head.next.next = head;//p指向前一个
        head.next=null;//置空，上一层迭代时指向前一个head；
        return p;//返回头
    }

    /**
     * 链表反转_迭代
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while(right != null){
            ListNode rightNext = right.next;
            right.next = left;
            left = right;
            right = rightNext;
        }
        return left;
    }


    /**
     * 爬梯子暴力解法
     *
     * @param n
     * @return
     */
    public int climbStairs0(int n) {
        return climb_Stairs0(0, n);
    }
    public int climb_Stairs0(int i, int n){
        if (i > n){
            return 0;
        }
        if (i == n) {
            return 1;
        }
            return climb_Stairs0(i + 1, n) + climb_Stairs0(i + 2, n);
    }

    /**
     * 爬梯子_动态规划_递归
     * @param n
     * @return
     */
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int a;
        int b;
        if(map.containsKey(n-1)){
            a = map.get(n-1);
        }else{
            a = climbStairs(n-1);
            map.put(n-1,a);
        }
        if(map.containsKey(n-2)){
            b = map.get(n-2);
        }else{
            b = climbStairs(n-2);
            map.put(n-2,b);
        }
        return a+b;
    }
    /**
     * 爬梯子_动态规划_迭代
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
       return dp[n];
    }

}
