import java.util.*;

public class Anagrams {

    public static void main(String[] args) {
        String [] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = printAnagrams(s);
        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> printAnagrams(String[] arr) {
        List<List<String>> result = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            Set<String> list = new HashSet<>();
            for (int j=0;j<arr.length;j++) {
                if (anagram(arr[i], arr[j])) {
                    list.add(arr[j]);
                }
            }

            boolean found = false;
            for(List<String> r : result) {
                if (r.equals(list.stream().toList())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                result.add(list.stream().toList());
            }
        }


        return result;
    }

    public static boolean anagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        char s1List[] = s1.toCharArray();
        char s2List[] = s2.toCharArray();
        Arrays.sort(s1List);
        Arrays.sort(s2List);
        s1 = Arrays.toString(s1List);
        s2 = Arrays.toString(s2List);

        if (!s1.equals(s2)) {
            return false;
        }

        return true;
    }
}
