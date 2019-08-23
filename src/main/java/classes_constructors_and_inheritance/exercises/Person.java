package classes_constructors_and_inheritance.exercises;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            this.age = 0;
        } else
        this.age = age;
    }

    public boolean isTeen() {
        return getAge() > 12 && getAge() < 20;
    }

    public String getFullName() {
        if (lastName.isEmpty() && firstName.isEmpty()) {
            return "";
        }
        if (firstName.isEmpty()) {
            return lastName;
        }
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(-5);
        System.out.println(person.getAge());
    }
}
