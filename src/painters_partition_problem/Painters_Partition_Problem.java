
package painters_partition_problem; // name of Package 
import java.util.*; //access all class in java pacakge util
import java.io.*; //access all class in java pacakge io
public class Painters_Partition_Problem { //class 
    static int getMax(int arr[],int n){ // Static method which get array size and array data
      int max=Integer.MIN_VALUE; // store max value in variable max
      for(int i=0;i<n;i++){ 
         if(arr[i]>max){ //Any num is greater than max gets value as a max
            max=arr[i]; 
         }
       }
       return max; // return value
    }
    
    static int getSum(int arr[],int n){ // static method that gets values of array and size of array
       int total=0; // intiallize variable total which assign value is 0
       for(int i=0;i<n;i++){ //loop that is < value of size
          total+=arr[i];
       }
       return total; //return total
    }

    static int numberOfPainters(int arr[],int n,int maxlen){ //static method which return the number of painter

       int total=0,numPainters=1;
       for(int i=0;i<n;i++){
          total+=arr[i];
           if(total>maxlen){
             total=arr[i];
             numPainters++;
          }
       }
       return numPainters;
    }

     static int b_search(int arr[],int n,int k){ //b_search static method which gets value (Array, size and value of k)
    
           int lo=getMax(arr,n);
           int hi=getSum(arr,n);

           while(lo<hi){
              int mid=lo+(hi-lo)/2;
 
              int requiredPainters=numberOfPainters(arr,n,mid);
              if(requiredPainters<=k)
                   hi=mid;
              else
                  lo=mid+1;
    
           }
          return lo; //return the value of lo
      
     }
    public static void main(String[] args) { // main method
        int size; // intiallize variable size for get size of array
        int k = 0,n = 0;
        Scanner input=new Scanner(System.in); // make an object of scanner class for get input from user
        System.out.println("Enter the size of Array!"); 
        size=input.nextInt();// get value
         int[] arr = new int[size]; // intiallize arrray
      if(size<=100) // set condition for geting value <= 100
      {
           for(int i=0;i<size;i++)
       {
           System.out.println("Enter any number in array at Array index "+i+"   :");
           arr[i]=input.nextInt(); //enter value
       }
       System.out.println("Enter the size of K:");
       k=input.nextInt();  //enter value of k
       n=arr.length; //store size of array in variable n
       System.out.println("Total Units: "+b_search(arr, n, k)); // call b_search for find total units for paint 
      }
      else 
      {
          System.out.println("Don't enter size of array > than 100:"); 
      }
      int a=(n/k); //In variable a store value size divided by value of k
      int b=(n-a); //In variable b store (size-value of a)
     if(k==1) //if k is 1 simply print all value because we know any value divided by 1 is same value
     {
         for(int i=0;i<size;i++)
         {
                   System.out.print("["+arr[i]+"]"); // print array
         }
         
     }
     else if(k==0) //any value divided by zero is zero
     {
         System.out.println("ERORR ___Any Number divided by zero is zero___");
     }
     else
     {
        for(int i=b-1;i<size;i++) // print values if k is greater than 1
       {
           System.out.print("["+arr[i]+"]"); //print value
       }
           System.out.print("      ");
        for(int i=0;i<k;i++)
        {
            System.out.print("["+arr[i]+"]"); //print value
        }
     }
    }
    
}
