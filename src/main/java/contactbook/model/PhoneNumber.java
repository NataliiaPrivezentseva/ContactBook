package contactbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(@JsonProperty("phoneNumber")String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
        return Objects.equals(this.phoneNumber, other.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.phoneNumber);
    }
}
