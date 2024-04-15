/**
 * Vertically flips a TextBlock.
 * 
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class VerticallyFlipped implements TextBlock {
  // Represents the unflipped block
  private TextBlock inputBlock;

  /**
   * Construct a vertically flipped version of the input TextBlock.
   * 
   * @param inputBlock The TextBlock to be flipped.
   */
  public VerticallyFlipped(TextBlock inputBlock) {
    this.inputBlock = inputBlock;
  }//VerticallyFlipped(TextBlock)

  /**
   * Get one row from the block, reversed.
   * 
   * @param i The row index to get, starting from 0 for the bottom row.
   * @return The i-th row from the bottom.
   * @throws Exception if the index is out of bounds.
   */
  @Override
  public String row(int i) throws Exception {
    // Ensure the row index is valid
    if (i < 0 || i >= this.height()) {
      throw new IllegalArgumentException("Row index is out of bounds.");
    }
    // Flip vertically by accessing rows from the bottom up
    return inputBlock.row(inputBlock.height() - 1 - i);
  }//row(int)

  /**
   * Determine how many rows are in the block.
   * 
   * @return The height of the block.
   */
  @Override
  public int height() {
    return this.inputBlock.height();
  }//height

  /**
   * Determine how many columns are in the block.
   * 
   * @return The width of the block.
   */
  @Override
  public int width() {
    return this.inputBlock.width();
  }//width

  /**
   * Determine if two TextBlocks are equivalent.
   * 
   * @param other Another TextBlock to compare with this one.
   * @return true if the other TextBlock is a VerticallyFlipped instance with an equivalent inputBlock; false otherwise.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof VerticallyFlipped) && this.inputBlock.eqv(((VerticallyFlipped) other).inputBlock);
  }//eqv(TextBlock)

}//class VerticallyFlipped
