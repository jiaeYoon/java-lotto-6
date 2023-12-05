package lotto.domain;

import lotto.util.Util;
import lotto.validate.InputValidate;
import lotto.view.InputView;

import java.util.List;

public class Winning {

    private static final int BOUUS_NUMBER_CHECK_MATCH_COUNT = 5;

    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning() {
        this.numbers = setWinningNumbers();
        this.bonusNumber = setBonusNumber();
    }

    public Prize compareTo(Lotto lotto) {
        int matchCount = countMatchNumber(lotto);
        boolean bonusNumberValid = isBonusNumberValid(matchCount, lotto);
        return Prize.getPrize(matchCount, bonusNumberValid);
    }

    private int setBonusNumber() {
        String input;
        while (true) {
            try {
                input = InputView.readBousNumber();
                InputValidate.bousNumberValidate(input, numbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Util.toInt(input);
    }

    private List<Integer> setWinningNumbers() {
        String input;
        while (true) {
            try {
                input = InputView.readWinningNumbers();
                InputValidate.winningNumbersValidate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Util.toIntegerList(input);
    }

    public static Winning setWinningCondition() {
        return new Winning();
    }

    private boolean isBonusNumberValid(int matchCount, Lotto lotto) {
        if (matchCount != BOUUS_NUMBER_CHECK_MATCH_COUNT) {
            return false;
        }
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int countMatchNumber(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
