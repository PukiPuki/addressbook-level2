package seedu.addressbook.data.person;

public class Unit {
    public final String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Unit
                && this.unit.equals(((Unit) other).unit));
    }

    @Override
    public int hashCode() {
        return unit.hashCode();
    }
}
