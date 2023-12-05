package lotto.validate;

import lotto.util.Util;
import lotto.config.LottoConfig;

import java.util.List;
import java.util.Set;

public class InputValidate {

    public static void amountValidate(String input) {
        isPositiveNum(input);
        isDividedWith1000(input);
    }

    private static void isDividedWith1000(String input) {
        if (Util.toInt(input) % LottoConfig.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }

    private static void isPositiveNum(String input) {
        String regex = "^([1-9]+[0-9]*)$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }

    public static void winningNumbersValidate(String input) {
        List<String> numbers = Util.toList(Util.split(input));

        isValidNumbersSize(numbers);
        hasDuplicate(numbers);
        for (String number : numbers) {
            isPositiveNum(number);
            isValidRange(number);
        }
    }

    private static void isValidRange(String input) {
        int number = Util.toInt(input);
        if (!(number >= LottoConfig.LOTTO_LOWER_BOUND.getValue() && number <= LottoConfig.LOTTO_UPPER_BOUND.getValue())) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }

    private static void hasDuplicate(List<String> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }

    private static void isValidNumbersSize(List<String> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }

    public static void bousNumberValidate(String input, List<Integer> numbers) {
        isPositiveNum(input);
        isValidRange(input);
        isDuplicateOfNumbers(input, numbers);
    }

    private static void isDuplicateOfNumbers(String input, List<Integer> numbers) {
        int number = Util.toInt(input);
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
        }
    }
}
