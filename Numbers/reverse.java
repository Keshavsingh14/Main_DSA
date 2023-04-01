package Numbers;

public class reverse {
    public static void main(String args[]){
        int num = 5432;
        int reversedNumber = 0, rem;

        while(num != 0){
            rem = num % 10;
            reversedNumber = reversedNumber * 10 + rem;
            num = num / 10;
        }
        System.out.println("Reaversed number is = "+reversedNumber);
    }
}
