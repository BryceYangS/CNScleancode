package howtocode.taxrefund;

public interface Tax {
    // 기본 인적 공제액
    static final long HOUSEHOLDER_BASE_DEDUCTION = 1500000;
    static final long SPOUSE_BASE_DEDUCTION      = 1500000;
    static final long DEPENDENT_BASE_DEDUCTION   = 1500000;

    // 추가 인적 공제액
    static final long DISABLED_DEDUCTION = 2000000;
    static final long SENIOR_DEDUCTION   = 1000000;
    static final long CHILD_DEDUCTION    = 1000000;

    // 과세표준 범위 기준
    static final long TAX_BASE_STANDARD_1 = 12000000;
    static final long TAX_BASE_STANDARD_2 = 46000000;
    static final long TAX_BASE_STANDARD_3 = 88000000;

    // 과세표준 세율
    static final float TAX_RATE_STANDARD_1 = 0.06f;
    static final float TAX_RATE_STANDARD_2 = 0.15f;
    static final float TAX_RATE_STANDARD_3 = 0.24f;
    static final float TAX_RATE_STANDARD_4 = 0.35f;

}
