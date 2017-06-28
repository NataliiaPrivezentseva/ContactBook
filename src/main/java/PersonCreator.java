class PersonCreator {

    static Person createNewPerson() {
        return new Person(Input.getInfoFromUser("first name"), Input.getInfoFromUser("last name"));
    }
}
