package howtocode.taxrefund;

public class TaxRefund {

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
        
        // 기본 공제
        
        long deduction = 1500000;
        
        if ( household.getSpouse()!= null ) {
            deduction += 1500000;
        }
        
        for ( int i = 0; i < household.getDependent().length; i++ ) {
            deduction += 1500000;
        }
        
        // 장애인 공제
        deduction += countDisabled() * 2000000;
        
        // 연령 공제
        deduction += countSeniorPerson() * 1000000;
        deduction += countChildren() * 1000000;
        
        return deduction;
    }
    
    public long calculateCollectIncomeTax() {
        
        long standard = totalSalary - deduction;    // 과세표준
        long collectIncomeTax = 0;

        if ( standard <= 12000000L ) {
            collectIncomeTax = (long)( standard * 0.06 );
        } else if ( standard <= 46000000L ) {
            collectIncomeTax = (long)( standard * 0.15 );
        } else if ( standard <= 88000000L ) {
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
    
    public int countDisabled() {
        
        int count = 0;
        
        if ( household.getHouseholder().isDisabled() ) {
            count++;
        }
        
        if ( household.getSpouse() != null && household.getSpouse().isDisabled() ) {
            count++;
        }
        
        for ( int i = 0; i < household.getDependent().length; i++ ) {
            if ( household.getDependent()[i].isDisabled() ) {
                count++;
            }
        }
        
        return count;
    }
    
    public int countSeniorPerson() {
        
        int count = 0;
        
        if ( household.getHouseholder().getAge() >= 70 ) {
            count++;
        }
        
        if ( household.getSpouse() != null && household.getSpouse().getAge() >= 70 ) {
            count++;
        }
        
        for ( int i = 0; i < household.getDependent().length; i++ ) {
            if ( household.getDependent()[i].getAge() >= 70 ) {
                count++;
            }
        }
        
        return count;
    }
    
    public int countChildren() {
        
        int count = 0;
        
        if ( household.getHouseholder().getAge() <= 6 ) {
            count++;
        }
        
        if ( household.getSpouse() != null && household.getSpouse().getAge() <= 6 ) {
            count++;
        }
        
        for ( int i = 0; i < household.getDependent().length; i++ ) {
            if ( household.getDependent()[i].getAge() <= 6 ) {
                count++;
            }
        }
        
        return count;
    }
}