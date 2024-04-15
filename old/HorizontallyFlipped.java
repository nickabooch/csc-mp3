
/**
 *  * A text block that represents a horizontally flipped version of another text block.
 * This class implements the TextBlock interface, flipping the contents of another
 * text block horizontally, so that each row is reversed.
 * 
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 * 
 */
public class HorizontallyFlipped implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
    private TextBlock original;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+
    /**
     * Constructs a HorizontallyFlipped text block wrapping the original text block.
     * 
     * @param original The original text block to be flipped.
     */
    public HorizontallyFlipped(TextBlock original) {
        this.original = original;
    }

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+
    @Override
    public String row(int i) throws Exception {
        if (i < 0 || i >= this.height()) {
            throw new IllegalArgumentException("Invalid row index: " + i);
        }
        // Retrieve the original row and reverse it for the horizontal flip.
        // Utilizes StringBuilder for efficient string reversal.
        String originalRow = this.original.row(i);
        return new StringBuilder(originalRow).reverse().toString();
    }

    @Override
    public int width() {
        // The width remains the same as the original's width after flipping.
        return original.width();
    }

    @Override
    public int height() {
        // The height remains the same as the original's height after flipping.
        return original.height();
    }

    @Override
    public boolean eqv(TextBlock other) {
        // Checks for structural equivalence, including the flipping.
        if (!(other instanceof HorizontallyFlipped)) return false;
        HorizontallyFlipped otherFlipped = (HorizontallyFlipped) other;
        return this.original.eqv(otherFlipped.original);
    }
}
