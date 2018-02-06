package seedu.addressbook.data.person;

public class Street {
    public final String street;

    public Street(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Street
                && this.street.equals(((Street) other).street));
    }

    @Override
    public int hashCode() {
        return street.hashCode();
    }
}
