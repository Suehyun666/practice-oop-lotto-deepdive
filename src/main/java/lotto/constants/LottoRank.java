package lotto.constants;

public enum LottoRank {
    FIRST("1등", 6, false, 2_000_000_000),
    SECOND("2등",5, true, 30_000_000),
    THIRD("3등",5, false, 1_500_000),
    FOURTH("4등",4, false, 50_000),
    FIFTH("5등",3, false, 5_000),
    NONE("꽝",0, false, 0);

    private final String rank;
    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    LottoRank(String rank, int matchCount, boolean bonusMatch, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public String getRank() { return rank; }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {return bonusMatch;};

}
