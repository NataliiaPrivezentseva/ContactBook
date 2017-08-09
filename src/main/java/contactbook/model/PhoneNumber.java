package contactbook.model;

import com.google.common.base.Objects;

public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final PhoneNumber other = (PhoneNumber) o;
        return Objects.equal(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.phoneNumber);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PhoneNumber)) return false;
//
//        PhoneNumber number = (PhoneNumber) o;
//
//        return phoneNumber != null ? phoneNumber.equals(number.phoneNumber) : number.phoneNumber == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return phoneNumber != null ? phoneNumber.hashCode() : 0;
//    }
}
