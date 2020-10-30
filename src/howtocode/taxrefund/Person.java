package howtocode.taxrefund;

public class Person {
    
    private String name;
    private int age;
    private boolean disabled;
    
    public Person( String name, int age, boolean disabled ) {
        this.name = name;
        this.age = age;
        this.disabled = disabled;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge( int age ) {
        this.age = age;
    }
    
    public boolean isDisabled() {
        return disabled;
    }
    
    public void setDisabled( boolean disabled ) {
        this.disabled = disabled;
    }
}