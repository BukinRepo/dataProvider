package ManWoman;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String partner;
    private Boolean isRetired = false;

    public Person(String firstName, String lastName, int age, String partner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = partner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPartner() {
        return partner;
    }

    public Boolean isRetired() {
        return isRetired;
    }

    public void setRetired(Boolean retired) {
        this.isRetired = retired;
    }
}
