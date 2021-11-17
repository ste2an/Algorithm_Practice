package String;


import java.util.ArrayList;
import java.util.List;

public class JustifyText {
    public static void main(String[] args) {
        String[] test = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        JustifyText justifyText = new JustifyText();
        List<String> res = justifyText.fullJustify(test, 16);
        for(String s: res){
            System.out.println(s);
        }

    }

    private String[] words;
    private int width;

    public List<String> fullJustify(String[] words, int maxWidth){
        if(words == null || maxWidth < 1){
            return null;
        }

        this.width = maxWidth;
        this.words = words;
        List<String> res = new ArrayList<>();
        int left = 0;
        while(left < words.length){
            int right = getRight(left);
            res.add(justifyWords(left, right));
            left = right + 1;
        }
        return res;
    }

    public int getRight(int left){
        int wordLen = words[left].length();
        int right = left + 1;
        while(right < words.length && (wordLen + 1 + words[right].length()) <= width){
            wordLen += words[right].length();
            right ++;
        }
        return right - 1;
    }

    // 处理多个单词的非最后一行
    public String justifyWords(int left, int right){
        if(left == right){
            return oneWordLine(words[left]);
        }
        if(right == words.length - 1){
            return lastLine(left, right);
        }

        int wordLen = 0;
        int numOfGap = right - left;

        for(int i = left; i <= right; i ++){
            wordLen += words[i].length();
        }
        int spaceTotal = width - wordLen;
        int spaceBetween = spaceTotal / numOfGap;
        int leftMorePart = spaceTotal % numOfGap;
        StringBuilder line = new StringBuilder();
        for(int i = left; i < right; i ++){
            line.append(words[i]);
            line.append(addSpace(spaceBetween));
            if(leftMorePart > 0){
                line.append(" ");
            }
            // 可以遍历完，如果leftMorePart 一定小于 right - left，否则 between 会多1
            leftMorePart --;
        }
        line.append(words[right]);

        return line.toString();

    }

    // 处理最后一行
    public String lastLine(int left, int right){
        int wordsLen = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = left; i < right; i ++){
            sb.append(words[i]);
            sb.append(" ");
            wordsLen += words[i].length() + 1;
        }
        wordsLen += words[right].length();
        sb.append(words[right]);
        sb.append(addSpace(width - wordsLen));
        return sb.toString();
    }

    // 处理只有一个单词的一行
    public String oneWordLine(String word){

        int wordsLen = word.length();
        StringBuilder sb = new StringBuilder(word);
        sb.append(addSpace(width - wordsLen));
        return sb.toString();

    }

    // 添加空格 leftmost
    private String addSpace(int k){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k ;i ++){
            sb.append(" ");
        }

        return sb.toString();
    }
}
