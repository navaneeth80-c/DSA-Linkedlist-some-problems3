public class mergesort1
{
public static void main(String[] args)
{

int[] num = {12,2,14,3,5,23,3,-1,13,2,3,10};
sort(num,0,num.length-1);
display(num);

}

public static void sort(int[] arr,int l, int r)
{


if(l<r)
{
	int mid = l+(r-l)/2;
	
	sort(arr,l,mid);
	sort(arr,mid+1,r);
	merge(arr,l,mid,r);
}

}

public static void display(int[] num)
{
	for(int i=0;i<num.length;i++)
	{
		System.out.println(num[i]);
	}
}

public static void merge(int[] array,int l,int mid,int r)
{
	//calculate the size 
	int n1 = mid - l +1;
	int n2 =  r - mid;
	
	//declare an array..
	int[] lArray = new int[n1];
	int[] rArray = new int[n2];
	// declare an ar
	for(int i =0 ; i<n1 ;i++)
	{
		lArray[i] = array[l+i];
	}
	for(int i=0;i<n2 ; i++)
	{
		rArray[i] = array[mid+1+i];
	}
	
	int i=0,j=0,k=l;
	
	while(i<n1 && j<n2)
	{
		if(lArray[i] < rArray[j])
		{
			array[k++]=lArray[i++];
		}
		
		else
		{
			array[k++]=rArray[j++];
		}
	}
	
	while(i<n1)
	{
	array[k++] = lArray[i++];
	}
	while(j<n2)
	{
	array[k++] = rArray[j++];
	}
}
}
