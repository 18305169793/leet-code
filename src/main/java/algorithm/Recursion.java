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
        if(s!=null && len>0){
            System.out.print("[ ");
            reversing(s,len);
        }else{
            System.out.println("[]");
        }
    }

    private void reversing(char[] s, int len) {
        if(len>1) {
            System.out.print(s[len - 1]+" ");
            reversing(s, len - 1);
        }{
            System.out.println("]");
        }
    }
}
