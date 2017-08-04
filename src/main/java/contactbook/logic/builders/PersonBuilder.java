package contactbook.logic.builders;

import contactbook.model.Person;

public class PersonBuilder {
    private String firstName;
    private String lastName;

    public PersonBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public Person build(){
        return new Person(this.firstName, this.lastName);
    }
}
