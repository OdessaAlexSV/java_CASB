package asv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    asv.Square s = new asv.Square(5);
    Assert.assertEquals(s.area(), 25.0);
  }
}
