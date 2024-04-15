/**
 * Represents the horizontal composition of two text blocks, combining them side by side.
 * This class implements the TextBlock interface to allow for flexible composition of text blocks.
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class HComposition implements TextBlock {
// +--------+------------------------------------------------------------
// | Fields |
// +--------+
  private TextBlock left;
  private TextBlock right;

// +--------------+------------------------------------------------------
// | Constructors |
// +--------------+
  /**
   * Constructs a new HComposition by composing two TextBlocks side by side.
   * 
   * @param left The left TextBlock.
   * @param right The right TextBlock.
   */
  public HComposition(TextBlock left, TextBlock right) {
    this.left = left;
    this.right = right;
  }//HComposition(TextBlock, TextBlock)

// +---------+-----------------------------------------------------------
// | Methods |
// +---------+
  @Override
  public String row(int i) throws Exception {
    // Generate left part of the row, filling with spaces if beyond its height
    String leftPart = i < left.height() ? left.row(i) : TBUtils.spaces(left.width());
    // Generate right part of the row, filling with spaces if beyond its height
    String rightPart = i < right.height() ? right.row(i) : TBUtils.spaces(right.width());
    // Concatenate left and right parts
    return leftPart + rightPart;
  }//row(int)

  @Override
  public int height() {
    // The height is the maximum of the heights of the left and right blocks
    return Math.max(left.height(), right.height());
  }//height

  @Override
  public int width() {
    // The width is the sum of the widths of the left and right blocks
    return left.width() + right.width();
  }//width

  @Override
  public boolean eqv(TextBlock other) {
    // Check for structural equivalence with another HComposition instance
    if (!(other instanceof HComposition)) return false;
    HComposition otherComp = (HComposition) other;
    return this.left.eqv(otherComp.left) && this.right.eqv(otherComp.right);
  }//eqv(TextBlock)
}//HComposition
