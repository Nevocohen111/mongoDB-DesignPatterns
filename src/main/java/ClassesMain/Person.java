package ClassesMain;

public class Person {
    private String name;
    private int age;
    private boolean isHealthy;


    protected Person(String name, int age, boolean isHealthy) {
        this.name = name;
        this.age = age;
        this.isHealthy = isHealthy;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", isHealthy: " + isHealthy;
    }
}
