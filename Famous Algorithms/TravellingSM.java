package Prac5;

import java.util.Scanner;

/**
 *
 * @author Kartik
 */
public class TravellingSM {
    int graph[][]; 
    int i;
    int path[] ;
    int cost = Integer.MAX_VALUE;
    static int path2[];
    int getCos(){
        return cost;
    }
    public TravellingSM(int graph[][],int i,int si) {
        this.graph = graph;
        this.i=i;
        path = new int[si];
        path2= new int[si]; 
    }
    
    void printA(int a[],int n){
        int sum=0;
        long st = System.nanoTime();
        System.out.print(this.i+"-->");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+"-->");
            
        }
        System.out.print(this.i);
        sum+= graph[this.i][a[0]];
        for(int j=1;j<n;j++)
        {
            sum += graph[a[j-1]][a[j]];
        }
        sum += graph[a[n-1]][this.i];
        
        System.out.print("  "+sum+" ");
        long en = System.nanoTime();
        System.out.print((double)(en-st)/1000+" ");
        System.out.println();
        
        if(sum < cost){
            cost = sum;
            for(int i=0;i<n;i++)path2[i] = a[i];
        }
        
    }
    public void permutate(int a[],int size,int n)
    {
        if(size == 1)
        {
            printA(a,n);
        }
        for(int i=0;i<size;i++)
        {
            permutate(a,size-1,n);
            
            if(size%2==1)
            {
                int temp = a[0];
                a[0]=a[size-1];
                a[size-1]=temp;
            }
            else{
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1]=temp;
            }
        }
    }
    public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          System.out.println("Enter number of cities");
          int cities = sc.nextInt();
          
          
          int ar[][]= new int[cities][cities];
          int a[] = new int[cities];
        switch (cities) {
            case 4:
                ar[0][0] = 0;
                ar[1][0] = 5;
                ar[2][0] = 6;
                ar[3][0] = 8;
                ar[0][1] = 10;
                ar[1][1] = 0;
                ar[2][1] = 13;
                ar[3][1] = 8;
                ar[0][2] = 15;
                ar[1][2] = 9;
                ar[2][2] = 0;
                ar[3][2] = 9;
                ar[0][3] = 20;
                ar[1][3] = 10;
                ar[2][3] = 12;
                ar[3][3] = 0;
                a[0] = 0;
                a[1] = 1;
                a[2] = 2;
                a[3] = 3;
                break;
            case 5:
                ar[0][0] = 0;
                ar[1][0] = 5;
                ar[2][0] = 6;
                ar[3][0] = 8;
                ar[4][0] = 9;
                ar[0][1] = 10;
                ar[1][1] = 0;
                ar[2][1] = 13;
                ar[3][1] = 8;
                ar[4][1] = 2;
                ar[0][2] = 15;
                ar[1][2] = 9;
                ar[2][2] = 0;
                ar[3][2] = 9;
                ar[4][2] = 7;
                ar[0][3] = 20;
                ar[1][3] = 10;
                ar[2][3] = 12;
                ar[3][3] = 0;
                ar[4][3] = 3;
                ar[0][4] = 2;
                ar[1][4] = 12;
                ar[2][4] = 6;
                ar[3][4] = 3;
                ar[4][4] = 0;
                a[0] = 0;
                a[1] = 1;
                a[2] = 2;
                a[3] = 3;
                a[4] = 4;
                break;
            case 6:
                ar[0][0] = 0;
                ar[1][0] = 5;
                ar[2][0] = 6;
                ar[3][0] = 8;
                ar[4][0] = 9;
                ar[5][0] = 7;
                ar[0][1] = 10;
                ar[1][1] = 0;
                ar[2][1] = 13;
                ar[3][1] = 8;
                ar[4][1] = 2;
                ar[5][1] = 1;
                ar[0][2] = 15;
                ar[1][2] = 9;
                ar[2][2] = 0;
                ar[3][2] = 9;
                ar[4][2] = 7;
                ar[5][2] = 3;
                ar[0][3] = 20;
                ar[1][3] = 10;
                ar[2][3] = 12;
                ar[3][3] = 0;
                ar[4][3] = 3;
                ar[5][3] = 5;
                ar[0][4] = 2;
                ar[1][4] = 12;
                ar[2][4] = 6;
                ar[3][4] = 3;
                ar[4][4] = 0;
                ar[5][4] = 9;
                ar[0][5] = 4;
                ar[1][5] = 8;
                ar[2][5] = 9;
                ar[3][5] = 2;
                ar[4][5] = 11;
                ar[5][5] = 0;
                a[0] = 0;
                a[1] = 1;
                a[2] = 2;
                a[3] = 3;
                a[4] = 4;
                a[5] = 5;
                break;
            default:
                break;
        }
          
          
          char choise = 'y';
          while(choise == 'y')
          {
          System.out.println("Enter initial node");
          int init = sc.nextInt();
          int at[]=new int[a.length-1];
          TravellingSM s = new TravellingSM(ar,init,at.length);
          int j=0;
          for(int i=0;i<a.length;i++)
          {
              if(a[i] == init) continue;
              else at[j] = a[i]; j++;
          }
          long start = System.currentTimeMillis();
          s.permutate(at, at.length, at.length);

          
          System.out.print(init+"-->");
          for(int ele : s.path2)
          {
              System.out.print(ele+"-->");
          }
          System.out.print(init);
          System.out.println("   Minimum Cost is :"+s.getCos());
          long end = System.currentTimeMillis();
              System.out.println("Time taken: "+(double)(end-start)/1000);
              System.out.println("Do you want to continue? y or n");
              choise = sc.next().charAt(0);
    }
    }
}
