package asv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testPoint(){
    Point p = new Point(10,20);
    Assert.assertEquals(p.distance(10,20), 0.0);
    Assert.assertEquals(p.distance(13,20), 3.0);
    Assert.assertEquals(p.distance(13,60), 40.11234224026316);
  }
}
