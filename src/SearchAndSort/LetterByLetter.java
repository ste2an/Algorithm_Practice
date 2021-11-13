package SearchAndSort;

public class LetterByLetter {
    public static void main(String[] args) {
        String str = "G2";
        System.out.println(checkString(str));
    }

    /**
     * Letter followed by Digit: Given a string str write a function which will check if the string no
     * letter followed by another letter, and no digit followed by another digit.
     */
    public static boolean checkString(String str){
        int len = str.length();
        if(len == 1) return true;

        for(int i = 0; i < len - 1; i ++){
            char pre = str.charAt(i);
            char cur = str.charAt(i + 1);
            if(Character.isLetter(pre)){
                if(Character.isLetter(cur)){
                    return false;
                }
            }else if(Character.isDigit(pre)){
                if(Character.isDigit(cur)){
                    return false;
                }
            }
        }
        return true;
    }
}
