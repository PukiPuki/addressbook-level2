package seedu.addressbook.data.person;

public class Block {
    public final String block;

    public Block(String block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return block;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Block
                && this.block.equals(((Block) other).block));
    }

    @Override
    public int hashCode() {
        return block.hashCode();
    }
}
