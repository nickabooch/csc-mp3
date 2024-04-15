/**
 * A textblock that diagonally flips a given TextBlock.
 * 
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */

public class DiagonallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  // Represents the unflipped block
  TextBlock inputBlock;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Constructs a new DiagonallyFlipped object.
   * 
   * @param inputBlock The TextBlock to be diagonally flipped.
   */
  public DiagonallyFlipped(TextBlock inputBlock) {
    this.inputBlock = inputBlock;
  }//DiagonallyFlipped(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the diagonally flipped block.
   * 
   * @param i The index of the row to retrieve.
   * @return The diagonally flipped row at the specified index.
   * @throws Exception If the index is out of bounds.
   */
  @Override
  public String row(int i) throws Exception {
    StringBuilder diagonallyFlippedRow = new StringBuilder();
    int width = this.inputBlock.width();
    int height = this.inputBlock.height();
        
    if (i < 0 || i >= width) {
      throw new Exception("Index out of bounds.");
    }//if

    for (int j = 0; j < height && (i + j) < width; j++) {
      diagonallyFlippedRow.append(this.inputBlock.row(j).charAt(i + j));
    }//for
    return diagonallyFlippedRow.toString();
  }//row(int)

  /**
   * Determine how many rows are in the diagonally flipped block.
   * 
   * @return The number of rows in the diagonally flipped block.
   */
  @Override
  public int height() {
    return this.inputBlock.width(); 
  }//height

  /**
   * Determine how many columns are in the diagonally flipped block.
   * 
   * @return The number of columns in the diagonally flipped block.
   */
  @Override
  public int width() {
    return this.inputBlock.height();
  }//width

  /**
   * Determine if two blocks were built the same way.
   * 
   * @param other The TextBlock to compare with.
   * @return True if the two blocks were built the same way, otherwise false.
   */
  @Override
  public boolean eqv(TextBlock other) {
    return (other instanceof DiagonallyFlipped) && 
           (this.inputBlock.eqv(((DiagonallyFlipped) other).inputBlock));
  }//eqv(TextBlock)
}//DiagonallyFlipped