package howtocode.taxrefund;

public class Person {

    private static final int SENIOR_AGE = 70;
    private static final int CHILD_AGE = 6;

    private String name;
    private int age;
    private boolean disabled;
    private boolean isChild;
    private boolean isSenior;

    public Person( String name, int age, boolean disabled ) {
        this.name = name;
        this.age = age;
        this.disabled = disabled;
        this.isChild = age <= CHILD_AGE ? true : false;
        this.isSenior = age >= SENIOR_AGE ? true : false;
    }

    public String getName() {
        return name;
    }
    public int getAge() { return age; }

    public boolean isDisabled() { return disabled; }
    public boolean isChild() { return isChild; }
    public boolean isSenior() { return isSenior; }
}