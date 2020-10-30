package howtocode.taxrefund;

import java.text.NumberFormat;
import java.util.Locale;

public class TaxRefundTest {
    
    public static void main( String[] args ) {
        
        NumberFormat format = NumberFormat.getInstance( Locale.KOREA );
        Household household = new Household(
                new Person( "김철수", 40, false ),
                new Person( "최영희", 38, true ),
                new Person[] { new Person( "김영감", 72, false ),
                        new Person( "문점순", 68, false ),
                        new Person( "김동수", 10, false ),
                        new Person( "김나나", 6, false )});

        TaxRefund tax = new TaxRefund( household, 38200000, 5000000 );
        
        System.out.println( "=======================================================" );
        System.out.println( "[" + tax.getHousehold().getHouseholder().getName() + "] 님의 연말정신 결과" );
        System.out.println( "=======================================================" );
        System.out.println( "총 급여액 : " + format.format( tax.getTotalSalary() ) );
        System.out.println( "총 공제금액 : " + format.format( tax.calculateDeduction() ) );
        System.out.println( "-------------------------------------------------------" );
        System.out.println( "본인 : " + format.format( 1500000 ) );
        if ( tax.getHousehold().getSpouse() != null ) {
            System.out.println( "배우자 : " + format.format( 1500000 ) );
        }
        if ( tax.getHousehold().getDependent().length > 0 ) {
            long sum = 0;
            for ( int i = 0; i < tax.getHousehold().getDependent().length; i++ ) {
                sum += 1500000;
            }
            System.out.println( "부양가족 : " + format.format( sum ) );
        }
        if ( tax.countDisabled() > 0 ) {
            System.out.println( "장애인 : " + format.format( tax.countDisabled() * 2000000 ) );
        }
        if ( tax.countSeniorPerson() > 0 ) {
            System.out.println( "경로우대 : " + format.format( tax.countSeniorPerson() * 1000000 ) );
        }
        if ( tax.countChildren() > 0 ) {
            System.out.println( "자녀양육비 : " + format.format( tax.countChildren() * 1000000 ) );
        }
        System.out.println( "-------------------------------------------------------" );
        System.out.println( "지급된 소득세 : " + format.format( tax.getPaidIncomeTax() ) );
        System.out.println( "징수할 소득세 : " + format.format( tax.calculateCollectIncomeTax() ) );
        System.out.println( "소득세 차이 : " + format.format( tax.calculateRefundMoney() ) );
        System.out.println( "=======================================================" );
        System.out.println( "연말정산 환급 총액 : " + format.format( tax.getRefundMoney() ) );
        System.out.println( "* (-)인 경우 돌려받으며, (+)인 경우 추가 징수됩니다." );
        System.out.println( "=======================================================" );

        Household household1 = new Household(new Person( "박초롱", 40, true ),
                null,
                new Person[] { new Person( "박돌쇠", 80, true ),
                        new Person( "서미미", 80, false ) });
        tax = new TaxRefund( household1,58600000, 8500000 );
        
        System.out.println( "=======================================================" );
        System.out.println( "[" + tax.getHousehold().getHouseholder().getName() + "] 님의 연말정신 결과" );
        System.out.println( "=======================================================" );
        System.out.println( "총 급여액 : " + format.format( tax.getTotalSalary() ) );
        System.out.println( "총 공제금액 : " + format.format( tax.calculateDeduction() ) );
        System.out.println( "-------------------------------------------------------" );
        System.out.println( "본인 : " + format.format( 1500000 ) );
        if ( tax.getHousehold().getSpouse() != null ) {
            System.out.println( "배우자 : " + format.format( 1500000 ) );
        }
        if ( tax.getHousehold().getDependent().length > 0 ) {
            long sum = 0;
            for ( int i = 0; i < tax.getHousehold().getDependent().length; i++ ) {
                sum += 1500000;
            }
            System.out.println( "부양가족 : " + format.format( sum ) );
        }
        if ( tax.countDisabled() > 0 ) {
            System.out.println( "장애인 : " + format.format( tax.countDisabled() * 2000000 ) );
        }
        if ( tax.countSeniorPerson() > 0 ) {
            System.out.println( "경로우대 : " + format.format( tax.countSeniorPerson() * 1000000 ) );
        }
        if ( tax.countChildren() > 0 ) {
            System.out.println( "자녀양육비 : " + format.format( tax.countChildren() * 1000000 ) );
        }
        System.out.println( "-------------------------------------------------------" );
        System.out.println( "지급된 소득세 : " + format.format( tax.getPaidIncomeTax() ) );
        System.out.println( "징수할 소득세 : " + format.format( tax.calculateCollectIncomeTax() ) );
        System.out.println( "소득세 차이 : " + format.format( tax.calculateRefundMoney() ) );
        System.out.println( "=======================================================" );
        System.out.println( "연말정산 환급 총액 : " + format.format( tax.getRefundMoney() ) );
        System.out.println( "* (-)인 경우 돌려받으며, (+)인 경우 추가 징수됩니다." );
        System.out.println( "=======================================================" );
    }
}