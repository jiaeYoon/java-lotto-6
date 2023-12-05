package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.config.LottoConfig;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto issue() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        LottoConfig.LOTTO_LOWER_BOUND.getValue(),
                        LottoConfig.LOTTO_UPPER_BOUND.getValue(),
                        LottoConfig.LOTTO_SIZE.getValue()
                )
        );
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
