import java.io.PrintWriter;

/**
 * Utilities for working with TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @author Rommin Adl
 * @author Shibam Mukhopadhyay
 */
public class TBUtils {
    // +--------------+------------------------------------------------------
    // | Class Fields |
    // +--------------+
    
    /**
     * A really big sequence of dashes, used to efficiently generate strings of dashes.
     */
    static String lotsOfDashes = "--";

    /**
     * A really big sequence of spaces, used to efficiently generate strings of spaces.
     */
    static String lotsOfSpaces = "  ";

    // +----------------+----------------------------------------------------
    // | Static Methods |
    // +----------------+
    
    /**
     * Builds a sequence of dashes of a specified length.
     * 
     * @param len The length of the dashes string to generate.
     * @return A string of dashes of the specified length.
     */
    static String dashes(int len) {
        while (lotsOfDashes.length() < len) {
            lotsOfDashes += lotsOfDashes;
        }
        return lotsOfDashes.substring(0, len);
    }

    /**
     * Prints a TextBlock to the specified PrintWriter.
     * 
     * @param pen The PrintWriter to which the TextBlock should be printed.
     * @param block The TextBlock to print.
     */
    public static void print(PrintWriter pen, TextBlock block) {
        for (int i = 0; i < block.height(); i++) {
            try {
                pen.println(block.row(i));
            } catch (Exception e) {
                pen.println("Error printing row: " + e.getMessage());
            }
        }
    }

    /**
     * Builds a sequence of spaces of a specified length.
     * 
     * @param len The length of the spaces string to generate.
     * @return A string of spaces of the specified length.
     */
    static String spaces(int len) {
        while (lotsOfSpaces.length() < len) {
            lotsOfSpaces += lotsOfSpaces;
        }
        return lotsOfSpaces.substring(0, len);
    }

    /**
     * Compares two TextBlock objects for content equality.
     * 
     * @param t1 The first TextBlock to compare.
     * @param t2 The second TextBlock to compare.
     * @return True if the two TextBlock objects contain the same content, false otherwise.
     */
    public static boolean equal(TextBlock t1, TextBlock t2) {
        if (t1.height() != t2.height() || t1.width() != t2.width()) {
            return false;
        }
        for (int i = 0; i < t1.height(); i++) {
            try {
                if (!t1.row(i).equals(t2.row(i))) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares two TextBlock objects for reference equality.
     * 
     * @param t1 The first TextBlock to compare.
     * @param t2 The second TextBlock to compare.
     * @return True if both TextBlock objects point to the same memory location, false otherwise.
     */
    public static boolean eq(TextBlock t1, TextBlock t2) {
        return t1 == t2;
    }

    /**
     * Compares two TextBlock objects for equivalence in structure and content.
     * 
     * @param t1 The first TextBlock to compare.
     * @param t2 The second TextBlock to compare.
     * @return True if the two TextBlock objects are of the same type and contain the same content, false otherwise.
     */
    public static boolean eqv(TextBlock t1, TextBlock t2) {
        return t1.getClass() == t2.getClass() && equal(t1, t2);
    }
} // class TBUtils
