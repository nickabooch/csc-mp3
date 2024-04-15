import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TextBlockTests {
 


@Test
public void testCenteredBlock() throws Exception {
    TextBlock original = new TextLine("Test");
    Centered centered = new Centered(original, 10);
    assertEquals("Expected centered text", "   Test   ", centered.row(0));
    assertEquals("Centered block should have correct width", 10, centered.width());
    assertEquals("Centered block should have the same height as original", original.height(), centered.height());
}

@Test
public void diagonallyFlippedTest() throws Exception {
    TextBlock original = new HComposition(new TextLine("AB"), new TextLine("CD"));
    TextBlock flipped = new DiagonallyFlipped(original);
    
    assertEquals("Expected first row of diagonally flipped block", "A", flipped.row(0));
    assertEquals("Expected second row of diagonally flipped block", "B", flipped.row(1));
}


@Test
public void testHComposition() throws Exception {
    TextBlock left = new TextLine("left");
    TextBlock right = new TextLine("right");
    HComposition comp = new HComposition(left, right);
    
    assertEquals("The height should match the taller block", Math.max(left.height(), right.height()), comp.height());
    assertEquals("The width should be the sum of both blocks", left.width() + right.width(), comp.width());
    assertEquals("First row should correctly combine both blocks", "leftright", comp.row(0));
}


@Test
public void testHorizontallyFlipped() throws Exception {
    TextBlock original = new TextLine("hello");
    TextBlock flipped = new HorizontallyFlipped(original);
    
    assertEquals("olleh", flipped.row(0));
    assertEquals(original.height(), flipped.height());
    assertEquals(original.width(), flipped.width());
    
    TextBlock anotherOriginal = new TextLine("world");
    TextBlock anotherFlipped = new HorizontallyFlipped(anotherOriginal);
    assertFalse(flipped.eqv(anotherFlipped));
}
@Test
public void testRightJustified() throws Exception {
    TextBlock original = new TextLine("test");
    int maxWidth = 10;
    RightJustified rightJustified = new RightJustified(original, maxWidth);
    
    assertEquals("Right-justified content should match expected padding", "      test", rightJustified.row(0));
    assertEquals("Height should remain unchanged", original.height(), rightJustified.height());
    assertEquals("Width should be set to maxWidth", maxWidth, rightJustified.width());
    
    // Test structural equivalence
    TextBlock sameAsOriginal = new TextLine("test");
    RightJustified anotherRightJustified = new RightJustified(sameAsOriginal, maxWidth);
    assertTrue("Structurally equivalent RightJustified instances", rightJustified.eqv(anotherRightJustified));
    
    TextBlock different = new TextLine("diff");
    RightJustified differentRightJustified = new RightJustified(different, maxWidth);
    assertFalse("Non-equivalent RightJustified instances", rightJustified.eqv(differentRightJustified));
}
}