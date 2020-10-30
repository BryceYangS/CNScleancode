package howtocode.taxrefund;

public class TaxRefund {

    private final long HOUSEHOLDER_BASE_DEDUCTION = 1500000;
    private final long SPOUSE_BASE_DEDUCTION = 1500000;
    private final long DEPENDENT_BASE_DEDUCTION = 1500000;

    private final long DISABLED_DEDUCTION = 2000000;
    private final long SENIOR_DEDUCTION = 1000000;
    private final long CHILD_DEDUCTION = 1000000;

    private final long TAX_RATE_STANDARD_1 = 12000000L;
    private final long TAX_RATE_STANDARD_2 = 46000000L;
    private final long TAX_RATE_STANDARD_3 = 88000000L;

    private final Household household;    // 가구
    
    private final long totalSalary;       // 총 급여액
    private final long paidIncomeTax;     // 총 지급된 소득세

    private final long deduction;         // 공제금액
    private final long collectIncomeTax;  // 징수해야 할 소득세
    private final long refundMoney;       // 환급대상 금액
    
    public TaxRefund( Household household, long totalSalary, long paidIncomeTax ) {
        this.household        = household;
        this.totalSalary      = totalSalary;
        this.paidIncomeTax    = paidIncomeTax;
        this.deduction        = calculateDeduction();
        this.collectIncomeTax = calculateCollectIncomeTax();
        this.refundMoney      = calculateRefundMoney();
    }

    public Household getHousehold() { return household; }

    public long getTotalSalary() {
        return totalSalary;
    }

    public long getPaidIncomeTax() {
        return paidIncomeTax;
    }

    public long getDeduction() {
        return deduction;
    }

    public long getCollectIncomeTax() {
        return collectIncomeTax;
    }

    public long getRefundMoney() {
        return refundMoney;
    }

    public long calculateDeduction() {
        return calculateBaseDeduction() + calculateAdditionalDeduction();
    }

    public long calculateBaseDeduction() {
        long baseDeduction = HOUSEHOLDER_BASE_DEDUCTION;

        if ( household.getSpouse()!= null ) {
            baseDeduction += SPOUSE_BASE_DEDUCTION;
        }

        for ( int i = 0; i < household.getDependent().length; i++ ) {
            baseDeduction += DEPENDENT_BASE_DEDUCTION;
        }
        return baseDeduction;
    }

    public long calculateAdditionalDeduction() {
        // 장애인 공제
        long additionalDeduction = household.countDisabled() * DISABLED_DEDUCTION;

        // 연령 공제
        additionalDeduction += household.countSeniorPerson() * SENIOR_DEDUCTION;
        additionalDeduction += household.countChildren() * CHILD_DEDUCTION;

        return additionalDeduction;
    }
    
    public long calculateCollectIncomeTax() {
        
        long standard = totalSalary - deduction;    // 과세표준
        long collectIncomeTax = 0;

        if ( standard <= TAX_RATE_STANDARD_1 ) {
            collectIncomeTax = (long)( standard * 0.06 );
        } else if ( standard <= TAX_RATE_STANDARD_2 ) {
            collectIncomeTax = (long)( standard * 0.15 );
        } else if ( standard <= TAX_RATE_STANDARD_3 ) {
            collectIncomeTax = (long)( standard * 0.24 );
        } else {
            collectIncomeTax = (long)( standard * 0.35 );
        }
        
        return collectIncomeTax;
    }
    
    public long calculateRefundMoney() {
        
        long refundMoney = collectIncomeTax - paidIncomeTax;
        
        return refundMoney;
    }

}