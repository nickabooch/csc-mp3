//package labfile;

/**
 * The vertical composition of two text blocks.
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class VComposition implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+
    
    /**
     * The top portion of the composition.
     */
    private TextBlock top;
    
    /**
     * The bottom portion of the composition.
     */
    private TextBlock bottom;
    
    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+
    
    /**
     * Constructs a new block by composing top and bottom vertically.
     * 
     * @param top The top TextBlock.
     * @param bottom The bottom TextBlock.
     */
    public VComposition(TextBlock top, TextBlock bottom) {
        this.top = top;
        this.bottom = bottom;
    }
    
    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+
    
    /**
     * Gets one row from the block.
     * 
     * @param i The index of the row to retrieve.
     * @return The content of the row at index i.
     * @throws Exception If the index is out of the block's bounds.
     */
    public String row(int i) throws Exception {
        int th = this.top.height();
        int bh = this.bottom.height();
        int tw = this.top.width();
        int bw = this.bottom.width();
        int h = th + bh;
        
        String padtop = "", padbot = "";
        if (tw > bw) {
            padbot = TBUtils.spaces(tw - bw);
        } else {
            padtop = TBUtils.spaces(bw - tw);
        }
        
        if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
        } else if (i < th) {
            return this.top.row(i) + padtop;
        } else {
            return this.bottom.row(i - th) + padbot;
        }
    }
    
    /**
     * Determines the total number of rows in the block.
     * 
     * @return The sum of the heights of the top and bottom blocks.
     */
    public int height() {
        return this.top.height() + this.bottom.height();
    }
    
    /**
     * Determines the width of the block.
     * 
     * @return The greater of the widths of the top and bottom blocks.
     */
    public int width() {
        return Math.max(this.top.width(), this.bottom.width());
    }
    
    /**
     * Checks if another block is equivalent to this VComposition.
     * 
     * @param other The TextBlock to compare with this one.
     * @return true if the other block is a VComposition with equivalent top and bottom blocks; false otherwise.
     */
    public boolean eqv(TextBlock other) {
        if (!(other instanceof VComposition)) return false;
        VComposition otherComp = (VComposition) other;
        return this.top.eqv(otherComp.top) && this.bottom.eqv(otherComp.bottom);
    }
    
} // class VComposition
