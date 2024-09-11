import java.util.Random;

public class MergeSort
{
public static void main(String[] args)
{
int[] num = new int [20];
Random rand = new Random();
for(int i=0;i<num.length;i++)
{
	num[i] = rand.nextInt(101);
}

//int[] num={12, 11, 13, 5, 6, 7};
 display(num);
 //System.out.println(num.length);
	sort(num,0,num.length-1);
	System.out.println();
	 display(num);
	 

}

public static void display(int[] num)
{
for(int i=0;i<num.length;++i)
{
System.out.print(num[i]+" ,");
}
}


public static void merge(int[] array,int l,int mid,int r)
{


int n1 = mid-l+1;
int n2 = r-mid;

int[] lArray = new int[n1];
int[] rArray = new int[n2];



for(int i=0;i<n1;i++)
{
lArray[i] = array[l+i];
}



for(int i=0;i<n2;i++)
{
rArray[i] = array[mid+1+i];
}

int i=0,j=0,k=l;



while(i<n1 && j<n2)
{
	if(lArray[i]<=rArray[j])
	{
		array[k] = lArray[i];
		i++;
	}
	else
	{
	array[k] = rArray[j];
		j++;
	}
	k++;
}




while(i<n1)
{
	array[k] = lArray[i]; 
	k++;
	i++;
}

 
while(j<n2)
{

	array[k] = rArray[j];
	k++;j++;
}


}





public static void sort(int[] num,int l,int r)
{
if(l<r)
{
	int mid = l+(r-l)/2;
	
	sort(num,l,mid);
	sort(num,mid+1,r);
	merge(num,l,mid,r);
	
}
}



}
