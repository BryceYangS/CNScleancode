package howtocode.taxrefund;

public class Household {

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


}
