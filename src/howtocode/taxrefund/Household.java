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

        int count = householder.isDisabled() ? 1 : 0;

        if ( spouse != null ) {
            count = spouse.isDisabled() ? count + 1 : count;
        }

        for (Person person : dependent) {
            count = person.isDisabled() ? count + 1 : count;
        }

        return count;
    }

    public int countChildren() {

        int count = householder.isChild() ? 1 : 0;

        if ( spouse != null) {
            count = spouse.isChild() ? count + 1 : count;
        }

        for (Person person : dependent) {
            count = person.isChild() ? count + 1 : count;
        }

        return count;
    }

    public int countSeniorPerson() {

        int count = householder.isSenior() ? 1 : 0;

        if ( spouse != null ) {
            count = spouse.isSenior()? count + 1 : count;
        }

        for (Person person : dependent) {
            count = person.isSenior() ? count + 1 : count;
        }

        return count;
    }
}
