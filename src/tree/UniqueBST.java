package tree;

public class UniqueBST {

    public static void main(String[] args) {
        UniqueBST uniqueBST = new UniqueBST();
        System.out.println(uniqueBST.uniqueBST(5));

    }

    public int uniqueBST(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int sum = 0;
        for(int i = 1; i <= n; i ++){
            int leftNum = uniqueBST(i - 1);
            int rightNum = uniqueBST(n - i);
            sum += leftNum * rightNum;
        }
        return sum;
    }
}
