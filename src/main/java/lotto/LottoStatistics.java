package lotto;

public enum LottoStatistics {
    THREE(3, false, 5000L),
    FOUR(4, false, 50000L),
    FIVE(5, false, 1500000L),
    FIVE_BONUS(5, true, 30000000L),
    SIX(6, false, 2000000000L),
    NONE(0, false, 0L);

    private final int matchCount;
    private final boolean hasBonus;
    private final long prize;

    LottoStatistics(int matchCount, boolean hasBonus, long prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static LottoStatistics valueOf(int matchCount, boolean hasBonus) {
        if(matchCount == 6) return SIX;
        if(matchCount == 5) {
            if (hasBonus) return FIVE_BONUS;
            return FIVE;
        }
        if(matchCount == 4) return FOUR;
        if(matchCount == 3) return THREE;
        return NONE;
    }
}
