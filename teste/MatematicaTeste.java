import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatematicaTeste {
  Matematica m;

  @Before
  public void setUp() throws Exception {
    m = new Matematica();
  }

  @Test
  public void testeRaiz() {
    assertEquals(4.0, m.raiz(16), 0.001);
  }

  @Test
  public void testMaior() {
    assertEquals(2, m.maior(1, 2));
  }

  @Test
  public void testDivide() {
    assertEquals(2, m.divide(4, 2));
  }

  // @Test
  // public void testDivide4Por2() {
  // assertEquals(4, m.divide(4, 2));
  // }
}