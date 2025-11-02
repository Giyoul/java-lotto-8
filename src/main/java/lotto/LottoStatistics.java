package lotto;

public enum LottoStatistics {
    THREE(3, false, 5000L),
    FOUR(4, false, 50000L),
    FIVE(5, false, 1500000L),
    FIVE_BONUS(5, true, 30000000L),
    SIX(6, false, 2000000000L),
    NONE(0, false, 0L);

    private static final String THREE_MATCH_DESCRIPTION = "3개 일치 (5,000원)";
    private static final String FOUR_MATCH_DESCRIPTION = "4개 일치 (50,000원)";
    private static final String FIVE_MATCH_DESCRIPTION = "5개 일치 (1,500,000원)";
    private static final String FIVE_AND_BONUS_MATCH_DESCRIPTION = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String SIX_MATCH_DESCRIPTION = "6개 일치 (2,000,000,000원)";

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

    public String getDescriptionMessage() {
        if(this == THREE) return THREE_MATCH_DESCRIPTION;
        if(this == FOUR) return FOUR_MATCH_DESCRIPTION;
        if(this == FIVE) return FIVE_MATCH_DESCRIPTION;
        if(this == FIVE_BONUS) return FIVE_AND_BONUS_MATCH_DESCRIPTION;
        if (this == SIX) return SIX_MATCH_DESCRIPTION;
        return "";
    }

    public static LottoStatistics[] getRanks() {
        return new LottoStatistics[]{THREE, FOUR, FIVE, FIVE_BONUS, SIX};
    }

    public Long getTotalPrize(Long rankCount) {
        return this.prize * rankCount;
    }
}
