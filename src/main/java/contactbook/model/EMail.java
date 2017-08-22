package contactbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EMail {

    private String eMail;

    public EMail(@JsonProperty("email")String eMail) {
        this.eMail = eMail;
    }

    public String getEMail() {
        return eMail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final EMail other = (EMail) o;
        return Objects.equals(this.eMail, other.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.eMail);
    }

    @Override
    public String toString() {
        return eMail;
    }
}
