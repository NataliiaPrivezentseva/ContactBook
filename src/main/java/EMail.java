public class EMail {

    private String eMail;

    EMail(String eMail) {
        this.eMail = eMail;
    }

//    String getEMail() {
//        return eMail;
//    }

    @Override
    public String toString() {
        return "E-mail: " + eMail;
    }
}
