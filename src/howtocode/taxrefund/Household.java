package howtocode.taxrefund;

public class Household {

    private final Person householder; // 본인
    private final Person spouse;      // 배우자
    private final Person[] dependent; // 부양가족들

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
        count = householder.isDisabled() ? count + 1 : count;

        if ( spouse != null ) {
            count = spouse.isDisabled() ? count + 1 : count;
        }

        for ( int i = 0; i < dependent.length; i++ ) {
            count = dependent[i].isDisabled() ? count + 1 : count;
        }

        return count;
    }

    public int countChildren() {

        int count = 0;
        count = householder.isChild() ? count + 1 : count;

        if ( spouse != null) {
            count = spouse.isChild() ? count + 1 : count;
        }

        for ( int i = 0; i < dependent.length; i++ ) {
            count = dependent[i].isChild() ? count + 1 : count;
        }

        return count;
    }

    public int countSeniorPerson() {

        int count = 0;
        count = householder.isSenior() ? count + 1 : count;

        if ( spouse != null ) {
            count = spouse.isSenior()? count + 1 : count;
        }

        for ( int i = 0; i < dependent.length; i++ ) {
            count = dependent[i].isSenior() ? count + 1 : count;
        }

        return count;
    }
}
