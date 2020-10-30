package howtocode.taxrefund;

import java.text.NumberFormat;
import java.util.Locale;

public class TaxRefundTest {

    static final NumberFormat FORMAT = NumberFormat.getInstance( Locale.KOREA );

    public static void main( String[] args ) {

        Household household = new Household(
                new Person( "김철수", 40, false ),
                new Person( "최영희", 38, true ),
                new Person[] {new Person( "김영감", 72, false ),
                        new Person( "문점순", 68, false ),
                        new Person( "김동수", 10, false ),
                        new Person( "김나나", 6, false )});

        TaxRefund tax = new TaxRefund( household, 38200000, 5000000 );

        printReportHeader(tax);
        printTotalSalaryAndDeduction(tax);
        printSplitLine();
        printDeductionDetail(tax);
        printSplitLine();
        printIncomeTaxDetail(tax);
        printReportFooter(tax);

        household = new Household(
                new Person( "박초롱", 40, true ),
                null,
                new Person[] { new Person( "박돌쇠", 80, true ),
                        new Person( "서미미", 80, false ) });
        tax = new TaxRefund( household,58600000, 8500000 );

        printReportHeader(tax);
        printTotalSalaryAndDeduction(tax);
        printSplitLine();
        printDeductionDetail(tax);
        printSplitLine();
        printIncomeTaxDetail(tax);
        printReportFooter(tax);
    }

    public static void printReportHeader(TaxRefund tax) {
        System.out.println( "=======================================================" );
        System.out.println( "[" + tax.getHousehold().getHouseholder().getName() + "] 님의 연말정신 결과" );
        System.out.println( "=======================================================" );
    }

    public static void printTotalSalaryAndDeduction(TaxRefund tax) {
        System.out.println( "총 급여액 : " + FORMAT.format( tax.getTotalSalary() ) );
        System.out.println( "총 공제금액 : " + FORMAT.format( tax.getDeduction() ) );
    }

    public static void printDeductionDetail(TaxRefund tax) {
        System.out.println( "본인 : " + FORMAT.format( tax.calculateHouseholderBaseDeduction() ) );
        if ( tax.getHousehold().getSpouse() != null ) {
            System.out.println( "배우자 : " + FORMAT.format( tax.calculateSpouseBaseDeduction() ) );
        }
        if ( tax.getHousehold().getDependent().length > 0 ) {
            System.out.println( "부양가족 : " + FORMAT.format( tax.calculateDependentBaseDeduction() ) );
        }
        if ( tax.getHousehold().countDisabled() > 0 ) {
            System.out.println( "장애인 : " + FORMAT.format( tax.calculateDisabledDeduction() ) );
        }
        if ( tax.getHousehold().countSeniorPerson() > 0 ) {
            System.out.println( "경로우대 : " + FORMAT.format( tax.calculateSeniorDeduction() ) );
        }
        if ( tax.getHousehold().countChildren() > 0 ) {
            System.out.println( "자녀양육비 : " + FORMAT.format( tax.calculateChildrenDeduction() ) );
        }
    }

    public static void printIncomeTaxDetail(TaxRefund tax) {
        System.out.println( "지급된 소득세 : " + FORMAT.format( tax.getPaidIncomeTax() ) );
        System.out.println( "징수할 소득세 : " + FORMAT.format( tax.calculateCollectIncomeTax() ) );
        System.out.println( "소득세 차이 : " + FORMAT.format( tax.calculateRefundMoney() ) );
    }

    public static void printReportFooter(TaxRefund tax) {
        System.out.println( "=======================================================" );
        System.out.println( "연말정산 환급 총액 : " + FORMAT.format( tax.getRefundMoney() ) );
        System.out.println( "* (-)인 경우 돌려받으며, (+)인 경우 추가 징수됩니다." );
        System.out.println( "=======================================================" );
    }

    public static void printSplitLine() {
        System.out.println( "-------------------------------------------------------" );
    }


}