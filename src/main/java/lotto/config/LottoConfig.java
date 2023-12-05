package lotto.config;

public enum LottoConfig {


    LOTTO_SIZE(6),

    LOTTO_LOWER_BOUND(1),
    LOTTO_UPPER_BOUND(45),

    LOTTO_PRICE(1000);

    private final int value;

    LottoConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
