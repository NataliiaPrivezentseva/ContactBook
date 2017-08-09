package contactbook.model;

import java.util.Objects;

public class EMail {

    private String eMail;

    public EMail(String eMail) {
        this.eMail = eMail;
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
