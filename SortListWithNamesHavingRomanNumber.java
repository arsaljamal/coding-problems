import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortListWithNamesHavingRomanNumber {

    public static void main(String[] args) {
        List<String> n = new ArrayList<>();
        n.add("Philippe VI");
        n.add("Jean II");
        n.add("Charles V");
        n.add("Charles VI");
        n.add("Charles VII");
        n.add("Louis XI");
        List<String> r = sortRoman(n);
        for(String s: r) {
            System.out.println(s);
        }
    }

    public static List<String> sortRoman(List<String> names) {
        // Write your code here
        String[] namesDuplicates = new String[names.size()];
        for(int i =0; i< names.size(); i++) {
            namesDuplicates[i] = names.get(i);
        }

        for(int i = 0; i < namesDuplicates.length; i++) {
            for(int j = 1; j < (namesDuplicates.length-i); j++) {
                if (compare(namesDuplicates[j-1], namesDuplicates[j])) {
                    String temp = namesDuplicates[j-1];
                    namesDuplicates[j-1] = namesDuplicates[j];
                    namesDuplicates[j] = temp;
                }
            }
        }

        List<String> result = new ArrayList<>();
        for(int i =0;i<namesDuplicates.length;i++) {
            result.add(namesDuplicates[i]);
        }
        return result;
    }

    public static Boolean compare(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }

        String  s1List[] = s1.split(" ");
        String  s2List[] = s2.split(" ");

        int s1RomanLiteral = getNumberFromRoman(s1List[1]);
        int s2RomanLiteral = getNumberFromRoman(s2List[1]);

        if (s1List[0].compareTo(s2List[0]) > 0) {
            return true;
        }
        if (s1List[0].compareTo(s2List[0]) == 0 && s1RomanLiteral > s2RomanLiteral) {
            return true;
        }

        return false;
    }

    public static int getNumberFromRoman(String s) {
        HashMap<Character, Integer> romanConstants = new HashMap<>();
        romanConstants.put('I', 1);
        romanConstants.put('V', 5);
        romanConstants.put('X', 10);
        romanConstants.put('L', 50);

        int num = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (i>0 && romanConstants.get(ch) > romanConstants.get(s.charAt(i-1))) {
                num += romanConstants.get(ch) - 2*romanConstants.get(s.charAt(i-1));
            } else {
                num += romanConstants.get(ch);
            }
        }
        return num;
    }
}
