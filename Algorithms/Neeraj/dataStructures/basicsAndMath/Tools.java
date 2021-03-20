import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Check if One String Swap Can Make Strings Equal3\n" +
                        "Find Center of Star Graph3\n" +
                        "Maximum Average Pass Ratio5\n" +
                        "Maximum Score of a Good Subarray"
        );
//        printCamelCase(
//                "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold"
////                "Product of Array Except Self",
//        );
        getReplaced(
                Arrays.asList(""),
                Arrays.asList("[", "{"),
                Arrays.asList("\"", "'"),
                Arrays.asList("]", "}")
        ).forEach(System.out::println);
    }

    private static void getContest(String input) {
        String[] strings = input.split("\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(Tools::getCamelCase).forEach(System.out::println);
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input) {
        return input
                .replace("[", "{")
                .replace("]", "}")
                .replace("\"", "'");
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
