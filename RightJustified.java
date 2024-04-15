
/**
 * A text block that right-justifies its contents within a given width.
 * Throws an exception if the provided width is less than the width of the text block.
 * Implements the TextBlock interface for compatibility with the text layout system.
 * 
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class RightJustified implements TextBlock {
// +--------+------------------------------------------------------------
// | Fields |
// +--------+
  private TextBlock textBlock;
  private int maxWidth;

// +-------------+-------------------------------------------------------
// | Constructor |
// +-------------+
  /**
   * Constructs a RightJustified text block with the specified text block and maximum width.
   * 
   * @param textBlock The text block to be right-justified.
   * @param maxWidth The width within which the text block should be right-justified.
   * @throws IllegalArgumentException if the maxWidth is less than the width of the text block.
   */
  public RightJustified(TextBlock textBlock, int maxWidth) {
    if (textBlock.width() > maxWidth) {
      throw new IllegalArgumentException("Provided width must be longer than or equal to the block's width.");
    }
  this.textBlock = textBlock;
  this.maxWidth = maxWidth;
  }//RightJustified(TextBlock, int)

// +---------+-----------------------------------------------------------
// | Methods |
// +---------+
  @Override
  public String row(int i) throws Exception {
    if (i < 0 || i >= this.height()) {
      throw new IllegalArgumentException("Invalid row " + i);
    }
    String originalRow = this.textBlock.row(i);
    int paddingLength = this.maxWidth - originalRow.length();
    return TBUtils.spaces(paddingLength) + originalRow;
  }//row(int)

  @Override
  public int height() {
    return this.textBlock.height();
  }//height

  @Override
  public int width() {
    return this.maxWidth;
  }//width

  @Override
  public boolean eqv(TextBlock other) {
    if (!(other instanceof RightJustified)) return false;
    RightJustified otherRightJustified = (RightJustified) other;
    return this.textBlock.eqv(otherRightJustified.textBlock) && this.maxWidth == otherRightJustified.maxWidth;
  }//eqv(TextBlock)
}//RightJustified
