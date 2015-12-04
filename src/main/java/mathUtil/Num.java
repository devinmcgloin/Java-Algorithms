package mathUtil;

/**
 * @author devinmcgloin
 * @version 12/3/15.
 */
public class Num {

    private Num() {
    }

    /**
     * <ol> <li>gcd(0, v) = v, because everything divides zero, and v is the largest number that divides v. gcd(u, 0) =
     * u. gcd(0, 0) is not typically defined, but it is convenient to set gcd(0, 0) = 0.</li> <li>If u and v are both
     * even, then gcd(u, v) = 2 * gcd(u/2, v/2), because 2 is a common divisor.</li> <li>If u is even and v is odd, then
     * gcd(u, v) = gcd(u/2, v), because 2 is not a common divisor.</li> <li>if u is odd and v is even, then gcd(u, v) =
     * gcd(u, v/2).</li> <li>If u and v are both odd, and u >= v, then gcd(u, v) = gcd((u - v)/2, v).</li> <li>If both
     * are odd and u < v, then gcd(u, v) = gcd((v - u)/2, u).</li> </ol> Repeat steps 2-4 until u = v, or (one more
     * step) until u = 0. In either case, the GCD is 2kv, where k is the number of common factors of 2 found in step 2.
     *
     * @param u
     * @param v
     *
     * @return
     */
    public static long gcd(long u, long v) {
        if (u == 0)
            return v;
        if (v == 0)
            return u;

        boolean uEven = (u & 1) == 0;
        boolean vEven = (v & 1) == 0;
        int mutiplyBy = 1;

        while (u != v || u != 0) {
            if (uEven && vEven) {
                u /= 2;
                v /= 2;
                mutiplyBy *= 2;
            }
            if (uEven)
                u /= 2;
            if (vEven)
                v /= 2;
            if (u >= v)
                u = (u - v) / 2;
            if (u < v) {
                long tmp = u;
                u = (v - u) / 2;
                v = tmp;
            }
        }
        return mutiplyBy * gcd(u, v);
    }
}
