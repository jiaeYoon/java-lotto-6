package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusNumber;
    private final int winningValue;
    private final String message;

    Prize(int matchCount, boolean bonusNumber, int winningValue, String message) {
        this.matchCount = matchCount;
        this.bonusNumber = bonusNumber;
        this.winningValue = winningValue;
        this.message = message;
    }

    public static Prize getPrize(int matchCount, boolean bonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount && prize.bonusNumber == bonusNumber)
                .findAny()
                .orElse(NONE);
    }

    public static String getWinningPrizeState(Prize prize, int winningNumber) {
        return String.format("%s - %d개", prize.message, winningNumber);
    }

    public static int getWinningValue(Prize prize) {
        return prize.winningValue;
    }
}
