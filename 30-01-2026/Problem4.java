import java.util.*;
import java.util.logging.Logger;
public class Problem4 {
    static int summ(ArrayList<Number> su){
        int s=0;
        for(Number i:su){
            if(i instanceof Integer){
                s=s+i.intValue();

            }
        }
        return s;
    }
    static double Average(ArrayList<Number> su){
        double s=0;
        int c=0;
        for(Number i:su){
            if(i instanceof Double ){
                s=s+i.doubleValue();
                c=c+1;
            }
        }
        return s/c;
    }
    private static final Logger logger = Logger.getLogger(Problem4.class.getName());
 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
       
        System.out.println("Enter the N elements one after the other");
        ArrayList<Number> list = new ArrayList<>();
        boolean validinput=false;
       
           
            for(int i=0;i<n;i++){
                String input = sc.next();
           try {
                if (input.contains(".")) {
                    list.add(Double.parseDouble(input));
                } else {
                    list.add(Integer.parseInt(input));
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid Input");
            }
        }
       
       
        System.out.println("Sum of Integers: "+summ(list));
        System.out.println("Average of floating numbers: "+Average(list));
       
    }
       
 
   
   
}
 