package asv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(asv.Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(asv.Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test
  public void testPrimeVeryFast() {
    Assert.assertTrue(asv.Primes.isPrimeVeryFast(Integer.MAX_VALUE));
  }

  @Test (enabled = false)
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(asv.Primes.isPrime(n));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(asv.Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
