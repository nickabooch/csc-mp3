/** A text block that truncates the block based on the specified maximum width.
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */

public class Truncated implements TextBlock {
  private TextBlock original;
  private int maxWidth;

  /**
   * Constructs a Truncated text block with a specified maximum width.
   * 
   * @param original The original TextBlock to truncate.
   * @param maxWidth The maximum width of the Truncated block.
   * @throws IllegalArgumentException If the maxWidth is greater than the original block's width.
   */
  public Truncated(TextBlock original, int maxWidth) {
    if (maxWidth > original.width()) {
      throw new IllegalArgumentException("maxWidth must be at most as large as the original block's width.");
    }
    this.original = original;
    this.maxWidth = maxWidth;
  }//Truncated(TextBlock, int)

  @Override
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height()) {
      throw new IndexOutOfBoundsException("Invalid row index: " + i);
    }
    String originalRow = original.row(i);
    return originalRow.length() > maxWidth ? originalRow.substring(0, maxWidth) : originalRow;
  }//row(int)

  @Override
  public int height() {
    return original.height();
  }//height

  @Override
  public int width() {
    return Math.min(original.width(), maxWidth);
  }//width

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Truncated)) return false;
      Truncated other = (Truncated) obj;
      return this.maxWidth == other.maxWidth && this.original.equals(other.original);
  }//equals(Object)

  @Override
  public int hashCode() {
    return 31 * original.hashCode() + maxWidth;
  }//hashCode

  @Override
  public boolean eqv(TextBlock other) {
    if (!(other instanceof Truncated)) return false;
    Truncated otherTruncated = (Truncated) other;
    return this.maxWidth == otherTruncated.maxWidth && this.original.eqv(otherTruncated.original);
  }//eqv(TextBlock)
}//Truncated
