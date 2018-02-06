package seedu.addressbook.data.person;

public class PostalCode {
    public final String postalCode;

    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return postalCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof PostalCode
                && this.postalCode.equals(((PostalCode) other).postalCode));
    }

    @Override
    public int hashCode() {
        return postalCode.hashCode();
    }
}
