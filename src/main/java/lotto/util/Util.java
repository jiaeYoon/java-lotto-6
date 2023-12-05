package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    private static final String SPLIT_REGEX = ",";

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> toIntegerList(String input) {
        return Arrays.stream(split(input))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> toList(String[] strings) {
        return Arrays.stream(strings).toList();
    }

    public static String[] split(String input) {
        return input.split(SPLIT_REGEX);
    }
}
