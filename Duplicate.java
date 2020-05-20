import java.util.*;
import java.io.*;
class Duplicate
{
	public static void main(String args[])
	{
		int n,f=0;
		System.out.println("Enter the size of the array");
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[i]);
					f=1;
				}
			}
		}
		if(f==0)
			System.out.println("-1");
	}
}
