package lotto;

import lotto.validate.InputValidate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputValidateTest {

    @Test
    void isPositiveNumber() {
        String input = "1000j";
        Assertions.assertThatThrownBy(() -> InputValidate.amountValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
