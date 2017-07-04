package contactbook.model;

public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
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
