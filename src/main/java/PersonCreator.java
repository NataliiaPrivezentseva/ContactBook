class PersonCreator {

    static Person createNewPerson() {
        Input in = new Input();
        return new Person(in.getInfoFromUser("first name"), in.getInfoFromUser("last name"));
    }
}
