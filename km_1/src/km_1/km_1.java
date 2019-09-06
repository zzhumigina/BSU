package km_1;
import java.math.BigInteger;
import java.util.Random;

public class km_1 {

	public static int Ferma( BigInteger a, BigInteger n, BigInteger m)
	{
		BigInteger res= a.modPow(n, m);
		if(res.compareTo(a)==0)
		{
			return 1;
		}
		return 0;
	}
	
	
	public static int gcd(BigInteger a,BigInteger b) 
	{
		if (b==BigInteger.ZERO)
			return a.intValue();
		return gcd(b,a.mod(b));
	}
	
	
	public static BigInteger jacobySign(BigInteger a, BigInteger b) // a - целое, b - натуральное > 1, нечетное
    {
        if (gcd (a, b) != 1){
            return BigInteger.ZERO;
        }

        int x = 1;

        
        if(a.compareTo(BigInteger.valueOf(0))<0)
        {
            a = a.negate();

            if (b.remainder(BigInteger.valueOf(4)) == BigInteger.valueOf(3))
            {
                x = -x;
            }
        }

        while (a != BigInteger.valueOf(0))
        {
            int t = 0;

            while (a.remainder(BigInteger.valueOf(2)) == BigInteger.valueOf(0))
            {
                t++;
                a = a.divide(BigInteger.valueOf(2));
            }

            if (t % 2 != 0)
            {
                BigInteger mod = b.remainder(BigInteger.valueOf(8));

                if (mod == BigInteger.valueOf(3) || mod == BigInteger.valueOf(5))
                {
                    x = -x;
                }
            }

            BigInteger modA = a.remainder(BigInteger.valueOf(4));

            if ((modA == b.remainder(BigInteger.valueOf(4))) && modA  == BigInteger.valueOf(3)) {
                x = -x;
            }
            BigInteger c = a;
            a = b.remainder(c);
            b = c;
        }

        return BigInteger.valueOf(x);
    }


    public static int randomInRange(BigInteger min,BigInteger max){
        Random rand = new Random();
        int randomNum = rand.nextInt((((max.subtract(min)).add(BigInteger.valueOf(1))).add(min)).intValue());

        return randomNum;
    }


    public static int pow(BigInteger foundation,int degree, BigInteger modeF){
        BigInteger answer = BigInteger.valueOf(1);

        for (int i = 0; i < degree; i++){
            answer= answer.multiply(foundation);
            answer=answer.remainder(modeF);
        }

        return  answer.intValue();
    }


    public static boolean SoloveiShtrassen(BigInteger number, int accuracy){ //number > 2, нечётное натуральное число
        for (int i = 0; i < accuracy; i++){
        	int random=(randomInRange(BigInteger.valueOf(2), number.subtract(BigInteger.valueOf(1))));
           //BigInteger randomInt = (randomInRange(BigInteger.valueOf(2), number.subtract(BigInteger.valueOf(1));
        	BigInteger randomInt=BigInteger.valueOf(random);
            if (gcd(randomInt, number) > 1){
                return false;
            }

            int checkNumberW = pow(randomInt, ((number.subtract(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2))).intValue(), number);
            BigInteger jacobyS = ((jacobySign(randomInt, number).add(number))).remainder(number);

            if (BigInteger.valueOf(checkNumberW) != jacobyS){
                return false;
            }
        }

        return true;
    }


	
	
	public static void main(String args[])
	{
		Random random= new Random();
		BigInteger a= BigInteger.valueOf(12);
		if(Ferma(a, BigInteger.valueOf(2), BigInteger.valueOf(2))==1)
			System.out.print("Is prime by Ferma\n");
		else
			System.out.print("Is not prime by Ferma\n");
		
		if(!SoloveiShtrassen(a, 3))
			System.out.print("Is not prime by Solovei-Shtrassen\n");
		else
			System.out.print("Is prime by Solovei-Shtrassen\n");
	}
}
