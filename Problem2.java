import java.util.*;
public class Problem2 {
   
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the Number of employes");
        int n=sc.nextInt();
        sc.nextLine();
        //array
        String[] emp=new String[n];
        System.out.println("enter the name of employes ");
        for(int i=0;i<n;i++){
            emp[i]=sc.nextLine();
        }
 
 
        //arraylist
        ArrayList<String> arr=new ArrayList<>(Arrays.asList(emp));
        System.out.println( "All the Employees :"+ arr);
 
 
        //hashset
        HashSet<String> duplicates=new HashSet<>();
        for(String name:arr){
            duplicates.add(name);
        }
        System.out.println("Unique Employee names : " +duplicates);
 
 
        //Hashmap frequency of each element
        HashMap<String,Integer> map=new HashMap<>();
        for(String i :emp){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        System.out.println(map);

        //iterator
        Iterator<String> itt=arr.iterator();
        while(itt.hasNext()){
            String f=itt.next();
            System.out.println(f);
        }

        System.out.println(arr);
 
 
 
    sc.close();
 
    }
   
}