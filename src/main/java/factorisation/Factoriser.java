package factorisation;

import java.util.Vector;

public class Factoriser {

  private static final int MAXN = 100001;

  /**
   * Returns the prime factors of a given number in String format
   *
   * @param number - the number for which we need to get the prime factors
   */
  public static String regularFactoriser(int number) {

    StringBuilder result = new StringBuilder();

    if (number == 0 || number < 0) {
      return null;
    }

    while (number % 2 == 0) {
      number /= 2;
      if (number == 1) {
        result.append("2");
      } else {
        result.append("2*");
      }
    }

    for (int i = 3; i <= Math.sqrt(number); i += 2) {
      while (number % i == 0) {
        number /= i;
        if (number == 1) {
          result.append(i);
        } else {
          result.append(i).append("*");
        }
      }
    }

    if (number > 2) {
      result.append(number);
    }
    return result.toString();
  }

  public static String sieveFactoriser(int number) {
    StringBuilder result = new StringBuilder();
    int[] smallestPrimeFactor = new int[MAXN];
    sieve(smallestPrimeFactor);
    Vector<Integer> primeNumbers = getFactorisation(number, smallestPrimeFactor);

    for (Integer primeNumber : primeNumbers) {
      if (result.length() > 0) {
        result.append("*").append(primeNumber);
      } else {
        result.append(primeNumber);
      }
    }

    return result.toString();
  }

  private static Vector<Integer> getFactorisation(int number, int[] smallestPrimeFactor) {
    Vector<Integer> ret = new Vector<>();
    while (number != 1) {
      ret.add(smallestPrimeFactor[number]);
      number = number / smallestPrimeFactor[number];
    }
    return ret;
  }

  private static int[] sieve(int[] smallestPrimeFactor) {
    smallestPrimeFactor[1] = 1;
    for (int i = 2; i < MAXN; i++) {
      smallestPrimeFactor[i] = i;
    }

    for (int i = 4; i < MAXN; i += 2) {
      smallestPrimeFactor[i] = 2;
    }

    for (int i = 3; i * i < MAXN; i++) {
      if (smallestPrimeFactor[i] == i) {
        for (int j = i * i; j < MAXN; j += i) {
          if (smallestPrimeFactor[j] == j) {
            smallestPrimeFactor[j] = i;
          }
        }
      }
    }
    return smallestPrimeFactor;
  }
}
