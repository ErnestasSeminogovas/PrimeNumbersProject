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

        String result = "";

        if(number == 0 || number < 0) {
            return null;
        }

        while (number % 2 == 0) {
            number /= 2;
            if (number == 1) {
                result += "2";
            } else {
                result += "2*";
            }

        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                number /= i;
                if (number == 1) {
                    result += i;
                } else {
                    result += (i + "*");
                }
            }
        }

        if (number > 2) {
            result += (number);
        }
        return result;
    }

    public static String sieveFactoriser(int number) {
        String result = "";
        int smallestPrimeFactor[] = new int[MAXN];
        smallestPrimeFactor = sieve(smallestPrimeFactor);
        Vector<Integer> primeNumbers = getFactorisation(number, smallestPrimeFactor);

        for(int i =0;i<primeNumbers.size();i++) {
            if(!result.isEmpty()) {
                result+="*" + primeNumbers.get(i);
            } else {
                result+=primeNumbers.get(i);
            }
        }

        return result;
    }

    static Vector<Integer> getFactorisation(int number, int[] smallestPrimeFactor)
    {
        Vector<Integer> ret = new Vector<>();
        while (number != 1)
        {
            ret.add(smallestPrimeFactor[number]);
            number= number/ smallestPrimeFactor[number];
        }
        return ret;
    }

    static int[] sieve(int[] smallestPrimeFactor)
    {
        smallestPrimeFactor[1] = 1;
        for (int i=2; i<MAXN; i++)

            smallestPrimeFactor[i] = i;

        for (int i=4; i<MAXN; i+=2)
            smallestPrimeFactor[i] = 2;

        for (int i=3; i*i<MAXN; i++)
        {
            if (smallestPrimeFactor[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)

                    if (smallestPrimeFactor[j]==j)
                        smallestPrimeFactor[j] = i;
            }
        }
        return smallestPrimeFactor;
    }

}
