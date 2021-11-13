package SearchAndSort;

public class RansomNote {
    public static void main(String[] args) {

    }

    /***
     * Given two stings ransomNote and magazine, return true if ransomNote can be constructed
     * from magazine and false otherwise.
     * Each letter in magazine can only be used once in ransomNote.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();

        if(len1 > len2){
            return false;
        }

        int[] helper = new int[26];

        for(int i = 0; i < len1; i ++){
            char ch1 = ransomNote.charAt(i);
            helper[ch1 - 'a']--;
        }

        for(int i = 0; i < len2; i++){
            char ch2 = magazine.charAt(i);
            helper[ch2 - 'a']++;
        }

        for(int i = 0; i < 26; i ++){
            if(helper[i] < 0){
                return false;
            }
        }
        return true;
    }

}
