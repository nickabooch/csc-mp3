/**
 * Represents a single line of text as a TextBlock.
 * 
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class TextLine implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
    
    /**
     * The contents of the line.
     */
    private String line;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+
    
    /**
     * Constructs a new TextLine with the specified contents.
     * 
     * @param line The text content of this line.
     */
    public TextLine(String line) {
        this.line = line;
    }

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+
    
    /**
     * Returns a single row of text from this TextLine.
     * 
     * @param i The row number to retrieve, which must be 0 for a TextLine.
     * @return The text of this line.
     * @throws Exception if the row number is not 0, as TextLine contains only one row.
     */
    @Override
    public String row(int i) throws Exception {
        if (i != 0) {
            throw new Exception("Invalid row " + i + "; TextLine contains only one row.");
        }
        return this.line;
    }

    /**
     * Returns the number of rows in this TextLine, which is always 1.
     * 
     * @return The fixed height of 1.
     */
    @Override
    public int height() {
        return 1;
    }

    /**
     * Returns the width of this TextLine, based on its content length.
     * 
     * @return The length of the line.
     */
    @Override
    public int width() {
        return this.line.length();
    }

    /**
     * Checks if another TextBlock is equivalent to this TextLine.
     * 
     * @param other The TextBlock to compare with this TextLine.
     * @return true if the other TextBlock is a TextLine with the same content; false otherwise.
     */
    @Override
    public boolean eqv(TextBlock other) {
        if (!(other instanceof TextLine)) return false;
        TextLine otherLine = (TextLine) other;
        return this.line.equals(otherLine.line);
    }
}
