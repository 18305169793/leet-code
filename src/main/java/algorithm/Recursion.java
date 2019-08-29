package algorithm;

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
}
