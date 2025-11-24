package Cliente;

import computadora.tarea;
import java.io.Serializable;
import java.math.BigDecimal;

public class pi implements tarea<BigDecimal>, Serializable {
    private static final long serialVersionUID = 227L;
    private final int digits;

    public pi(int digits) {
        this.digits = digits;
    }

    public BigDecimal execute() {
        return computadoraPi(digits);
    }

    public static BigDecimal computadoraPi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(new BigDecimal(4)).subtract(arctan1_239).multiply(new BigDecimal(4));
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal arctan(int invx, int scale) {
        BigDecimal result, numer, term;
        BigDecimal invx2 = BigDecimal.valueOf(invx * invx);
        
        numer = BigDecimal.ONE.divide(BigDecimal.valueOf(invx), scale, BigDecimal.ROUND_HALF_EVEN);
        result = numer;
        int i = 1;
        
        do {
            numer = numer.divide(invx2, scale, BigDecimal.ROUND_HALF_EVEN);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, BigDecimal.ROUND_HALF_EVEN);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        
        return result;
    }
}