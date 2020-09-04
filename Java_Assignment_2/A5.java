import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.sql.Timestamp;

public class A5 {

    public static void Union_Using_Array(int[] Array1,int[] Array2) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        int Arr[] = new int[11];
        for(int i = 0; i < Array1.length; i++)
        {
            Arr[Array1[i]] = 1;
        }
        for(int i = 0; i < Array2.length; i++)
        {
            Arr[Array2[i]] = 1;
        }
        for (int i=0;i<11;i++)
        {
            if (Arr[i]==1)
                System.out.print(i + " ");
        }
        System.out.println("\nTimestamp Before: "+timestamp); 
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("Timestamp After: "+timestamp2);
    }
    public static void Intersection_Using_Array(int[] Array1,int[] Array2) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        int Arr[] = new int[11];
        for(int i = 0; i < Array1.length; i++)
        {
            Arr[Array1[i]] = 1;
        }
        for(int i = 0; i < Array2.length; i++)
        {
            if (Arr[Array2[i]] == 1)
                Arr[Array2[i]] = 2;
        }
        for (int i=0;i<11;i++)
        {
            if (Arr[i]==2)
                System.out.print(i + " ");
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("\nTimestamp Before: "+timestamp); 
        System.out.println("Timestamp After: "+timestamp2);

    }
    public static void Complement_Using_Array(int[] Array1) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        int Arr[] = new int[11];
        for(int i = 0; i < Array1.length; i++)
        {
            Arr[Array1[i]] = 1;
        }
        for (int i=0;i<11;i++)
        {
            if (Arr[i]==0)
                System.out.print(i + " ");
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("\nTimestamp Before: "+timestamp); 
        System.out.println("Timestamp After: "+timestamp2);

    }
    public static void Union_Using_Set(int[] Array1,int[] Array2) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  

        HashSet<Integer> hs = new HashSet<>(); 
        for (int i = 0; i < Array1.length; i++)  
            hs.add(Array1[i]);         
        for (int i = 0; i < Array2.length; i++)  
            hs.add(Array2[i]); 
        System.out.println(hs);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("Timestamp Before: "+timestamp); 
        System.out.println("Timestamp After: "+timestamp2);
    }
    public static void Intersection_Using_Set(int[] Array1,int[] Array2) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        HashSet<Integer> hs = new HashSet<>(); 
        HashSet<Integer> hs1 = new HashSet<>(); 
          
        for (int i = 0; i < Array1.length; i++)  
            hs.add(Array1[i]); 
          
        for (int i = 0; i < Array2.length; i++)  
            if (hs.contains(Array2[i])) 
               hs1.add(Array2[i]);
        System.out.println(hs1);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("Timestamp Before: "+timestamp); 
        System.out.println("Timestamp After: "+timestamp2);
    }
    public static void Complement_Using_Set(int[] Array1) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());  
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < 11; i++)  
            hs.add(i);
        for (int i = 0; i < Array1.length; i++)  
            hs.remove(Array1[i]);
        System.out.println(hs);   
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());  
        System.out.println("Timestamp Before: "+timestamp); 
        System.out.println("Timestamp After: "+timestamp2);
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of elements you want in Array 1 :");

        String str1= sc.nextLine();
        try 
        { 
            
            n=Integer.parseInt(str1); 
        }  
        catch (NumberFormatException e)  
        { 
            System.out.println(str1 + " is not a valid input");
            return;
        }
        int Array1[] = new int[n];


        System.out.print("Enter the elements for Array 1 in the Range of 0 to 10 :");
        for(int i = 0; i < n; i++)
        {

            
            str1= sc.next();
            try 
            { 
                 
                int x=Integer.parseInt(str1); 
                Array1[i] = x;
            }  
            catch (NumberFormatException e)  
            { 
                System.out.println(str1 + " is not a valid input"); 
                return;
            }
        }


        System.out.print("Enter no. of elements you want in Array 2 :");

        str1= sc.next();
        try 
        { 
            
            n=Integer.parseInt(str1); 
        }  
        catch (NumberFormatException e)  
        { 
            System.out.println(str1 + " is not a valid input");
            return;
        }
        int Array2[] = new int[n];

        System.out.print("Enter the elements for Array 2 in the Range of 0 to 10 :");
        for(int i = 0; i < n; i++)
        {
            str1= sc.next();
            try 
            { 
                int x=Integer.parseInt(str1); 
                Array2[i] = x;
            }  
            catch (NumberFormatException e)  
            { 
                System.out.println(str1 + " is not a valid input");
                return;
            }
        }

        System.out.println("\n\nUnion_Using_Array : ");
        Union_Using_Array(Array1,Array2);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(Array2), sizeof(universe) ) ] ");

        System.out.println("\n\nIntersection_Using_Array : ");
        Intersection_Using_Array(Array1,Array2);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(Array2), sizeof(universe) ) ] ");

        System.out.println("\n\nComplement_Using_Array : ");
        Complement_Using_Array(Array1);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(universe) ) ] ");

        System.out.println("\n\nUnion_Using_Set : ");
        Union_Using_Set(Array1,Array2);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(Array2) ) ] ");

        System.out.println("\n\nIntersection_Using_Set : ");
        Intersection_Using_Set(Array1,Array2);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(Array2) ) ] ");

        System.out.println("\n\nComplement_Using_Set : ");
        Complement_Using_Set(Array1);
        System.out.println("Time Complexity : O[ max(sizeof(Array1), sizeof(universe) ) ] ");


    }

}