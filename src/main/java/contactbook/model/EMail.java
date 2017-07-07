package contactbook.model;

public class EMail {

    private String eMail;

    public EMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return eMail;
    }
}
