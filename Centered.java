/**
 * A text block that centers its contents within a given width.
 * Adjusts the text block to center its contents if the provided width is larger than the text block width.
 * Implements the TextBlock interface for compatibility with the text layout system.
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class Centered implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
    private TextBlock textBlock;
    private int width;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+
    /**
     * Constructs a Centered text block with the specified text block and width.
     * 
     * @param textBlock The text block to be centered.
     * @param width The width within which the text block should be centered.
     * @throws IllegalArgumentException If the provided width is less than the text block's width.
     */
    public Centered(TextBlock textBlock, int width) {
        if (width < textBlock.width()) {
            throw new IllegalArgumentException("Provided width must be longer than or equal to the block's width.");
        }
        this.textBlock = textBlock;
        this.width = width;
    }

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+
    @Override
    public String row(int i) throws Exception {
        if (i < 0 || i >= this.height()) {
            throw new IllegalArgumentException("Invalid row index: " + i);
        }
        String originalRow = this.textBlock.row(i);
        int padding = (this.width - originalRow.length()) / 2;
        int extraPadding = (this.width - originalRow.length()) % 2;
        return TBUtils.spaces(padding) + originalRow + TBUtils.spaces(padding + extraPadding);
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.textBlock.height();
    }

    @Override
    public boolean eqv(TextBlock other) {
        if (!(other instanceof Centered)) return false;
        Centered otherCentered = (Centered) other;
        return this.textBlock.eqv(otherCentered.textBlock) && this.width == otherCentered.width;
    }
}
