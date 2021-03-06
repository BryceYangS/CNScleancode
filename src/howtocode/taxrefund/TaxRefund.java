package howtocode.taxrefund;

public class TaxRefund implements Tax {

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
    public long getTotalSalary() { return totalSalary; }
    public long getPaidIncomeTax() { return paidIncomeTax; }
    public long getDeduction() { return deduction; }
    public long getCollectIncomeTax() { return collectIncomeTax; }
    public long getRefundMoney() { return refundMoney; }


    public long calculateDeduction() {
        return calculateBaseDeduction() + calculateAdditionalDeduction();
    }

    public long calculateBaseDeduction() {
        return calculateHouseholderBaseDeduction() + calculateSpouseBaseDeduction() + calculateDependentBaseDeduction();
    }

    public long calculateHouseholderBaseDeduction() {
        return HOUSEHOLDER_BASE_DEDUCTION;
    }

    public long calculateSpouseBaseDeduction() {
        if ( household.getSpouse() == null ) {
            return 0;
        }
        return SPOUSE_BASE_DEDUCTION;
    }

    public long calculateDependentBaseDeduction() {
        long dependentBaseDeduction = 0;
        for ( int i = 0; i < household.getDependent().length; i++ ) {
            dependentBaseDeduction += DEPENDENT_BASE_DEDUCTION;
        }
        return dependentBaseDeduction;
    }


    public long calculateAdditionalDeduction() {
        return calculateDisabledDeduction() + calculateSeniorDeduction() + calculateChildrenDeduction();
    }

    public long calculateDisabledDeduction() {
        return household.countDisabled() * DISABLED_DEDUCTION;
    }

    public long calculateSeniorDeduction() {
        return household.countSeniorPerson() * SENIOR_DEDUCTION;
    }

    public long calculateChildrenDeduction() {
        return household.countChildren() * CHILD_DEDUCTION;
    }

    public long calculateCollectIncomeTax() {
        if ( calculateTaxBaseStandard() <= TAX_BASE_STANDARD_1 ) {
            return (long)( calculateTaxBaseStandard() * TAX_RATE_STANDARD_1 );
        } else if ( calculateTaxBaseStandard() <= TAX_BASE_STANDARD_2 ) {
            return (long)( calculateTaxBaseStandard() * TAX_RATE_STANDARD_2 );
        } else if ( calculateTaxBaseStandard() <= TAX_BASE_STANDARD_3 ) {
            return (long)( calculateTaxBaseStandard() * TAX_RATE_STANDARD_3 );
        } else {
            return (long)( calculateTaxBaseStandard() * TAX_RATE_STANDARD_4 );
        }
    }

    private long calculateTaxBaseStandard() { return totalSalary - deduction; }

    public long calculateRefundMoney() {
        return collectIncomeTax - paidIncomeTax;
    }

}