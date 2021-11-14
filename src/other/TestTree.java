package other;

public class TestTree {
    public static void main(String[] args) {
       /*
        PrefixTree test = new PrefixTree();
        test.insert("apple");
        test.insert("apt");
        test.insert("adobe");

        System.out.println(test.search("app"));
        System.out.println(test.searchPrefix("app"));
        System.out.println(test.searchPrefix("apple"));
        System.out.println(test.search("adob"));
        System.out.println(test.searchPrefix("adob"));
        */

        SuffixTrie test1 = new SuffixTrie();
        test1.addString("aababa");
        System.out.println(test1.isSubString("aaba"));
        System.out.println(test1.isSubString("aabac"));

        System.out.println(test1.findNumberOfOccurrence("ba"));
    }
}
