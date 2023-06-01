package ManWoman;

public class Man extends Person {

    public Man(String firstName, String lastName, int age, String partner) {
        super(firstName, lastName, age, partner);

        if(age>=65){
            setRetired(true);
        }
    }
}
