package howtocode.taxrefund;

public class Household {

    private final int SENIOR_AGE = 70;
    private final int CHILD_AGE = 6;

    private final Person householder; // 본인
    private final Person spouse;      // 배우자
    private final Person[] dependent;       // 부양가족들

    public Household(Person householder, Person spouse, Person[] dependent) {
        this.householder = householder;
        this.spouse = spouse;
        this.dependent = dependent;
    }

    public Person getHouseholder() { return householder; }
    public Person getSpouse() { return spouse; }
    public Person[] getDependent() { return dependent; }

    public int countDisabled() {

        int count = 0;

        if ( this.getHouseholder().isDisabled() ) {
            count++;
        }

        if ( this.getSpouse() != null && this.getSpouse().isDisabled() ) {
            count++;
        }

        for ( int i = 0; i < this.getDependent().length; i++ ) {
            if ( this.getDependent()[i].isDisabled() ) {
                count++;
            }
        }

        return count;
    }

    public int countChildren() {

        int count = 0;

        if ( this.getHouseholder().getAge() <= CHILD_AGE ) {
            count++;
        }

        if ( this.getSpouse() != null && this.getSpouse().getAge() <= CHILD_AGE ) {
            count++;
        }

        for ( int i = 0; i < this.getDependent().length; i++ ) {
            if ( this.getDependent()[i].getAge() <= CHILD_AGE ) {
                count++;
            }
        }

        return count;
    }

    public int countSeniorPerson() {

        int count = 0;

        if ( this.getHouseholder().getAge() >= SENIOR_AGE ) {
            count++;
        }

        if ( this.getSpouse() != null && this.getSpouse().getAge() >= SENIOR_AGE ) {
            count++;
        }

        for ( int i = 0; i < this.getDependent().length; i++ ) {
            if ( this.getDependent()[i].getAge() >= SENIOR_AGE ) {
                count++;
            }
        }

        return count;
    }
}
