public class PhoneNumber {

    private String phoneNumber;

    PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    String getPhoneNumber() {
//        return phoneNumber;
//    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
