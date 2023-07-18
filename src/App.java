import Exceptions.*;

public class App {

   /* public static boolean checkHex(String[] hexNum){

        List<String> avaibleStrings = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"));

        for(int i = 0; i < hexNum.length; i++){

            if(!avaibleStrings.contains(hexNum[i].toUpperCase()))
                return false;
        }
        return true;
    }*/

    public static int Exponent(int num, int e){

        if(e == 0) return 1;

        if(e == 1) return num;

        int tempNum = num;
        for(int i = e; i > 1; i--){
            num *= tempNum;
        }
        return num;
    }

    public static int parseDecimal(String dec) throws NotHexadecimalException{

        dec = dec.toUpperCase();
        try{
            int value = Integer.parseInt(dec);
            return value;
        } catch (Exception e){
            switch (dec){
                case "A": return 10;
                case "B": return 11;
                case "C": return 12;
                case "D": return 13;
                case "E": return 14;
                case "F": return 15;
                default: throw new NotHexadecimalException(dec+" is not a hexadecimal expression");
            }
        }
    }

    public static String convertHexToDec(String number) throws NotHexadecimalException{

        int finalNum = 0;
        String[] splitted = number.split("(?<=.)");

        //if(checkHex(splitted)){

            for(int i = splitted.length-1; i >= 0; i--){

                int temp = parseDecimal(splitted[i]);
                finalNum += (temp * Exponent(16, (splitted.length - i - 1)));
            }
            return "The decimal of "+number+" is "+finalNum;
        //}
    }
    public static void main(String[] args) throws Exception {
        
        System.out.print("Give me a hexadecimal number to convert ");

        String num = System.console().readLine();

        System.out.println("\n"+convertHexToDec(num));

    }
}
