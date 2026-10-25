package day_6_Sorting_Algos;

public class Sorting_Algorithms
{
    static void Merger(int a[],int start,int mid,int  end)
    {
        int i=start;//start of block 1
        int j=mid+1;//start of block2
        int t_index=start;//for temp array
        int temp[]=new int[a.length];
        while(i<=mid && j<=end)
        {
            if(a[i]<a[j])
                temp[t_index++]=a[i++];//copy and go to next
            else
                temp[t_index++]=a[j++];//copy and go to next
        }
        while(i<=mid)
            temp[t_index++]=a[i++];//copy and go to next
        while(j<=end)
            temp[t_index++]=a[j++];//copy and go to next
        //recopy to a
        for(i=start;i<=end;i++)
            a[i]=temp[i];
    }



    static void Merge_Sort(int a[],int start,int end)
    {
       if(start<end)//size1
        {
            int mid=(start+end)/2;
            Merge_Sort(a,start,mid);
            Merge_Sort(a,mid+1,end);
            Merger(a,start,mid,end);
        }
    }
    static void Quick_Sort(int a[],int start,int end)
    {
        int i,j,pivot;
        i=start;j=end;
        pivot=start;
        while(i<j)
        {
            while(a[j]>a[pivot])//As pivot is at the start, sorting will be done from the end.
                j--;
            if(i<j)
            {
                int t=a[i];a[i]=a[j];a[j]=t;
            }
        }
        if(i<end)//not over
            Quick_Sort(a,i+1,end);
    }
    static void Quick_Sort2(int a[],int start,int end)
    {
        int i,j,pivot;
        i=start;j=end;
        pivot=end;
        while(i<j)
        {
            while(a[i]<a[pivot])//As pivot is at the start, sorting will be done from the end.
                i++;
            if(i<j)
            {
                int t=a[i];a[i]=a[j];a[j]=t;
            }
        }
        if(start<j)//Has not reached the stop
            Quick_Sort2(a,start,j-1
            );
    }
    static void Insertion_Sort(int a[])
    {
        int i,j,new_element;
        for(i=0;i<a.length-1;i++)//n-1 passes fr sorting
        {
            new_element=a[i+1];//new inserted
            j=i+1;
            while(j>0 && a[j-1]>new_element)
            {
                a[j]=a[j-1];//move back
                j--;//search next
            }
            a[j]=new_element;
        }
    }
    static void Binary_Search(int a[]) {
    	int start , mid, end;
    	start = 0;
    	end = a.length;
    	mid = (start + end) /2 ;
    	
    	int key = 88;
    	
    		if(key < a[mid]{
    			for(int i=0; i<a[mid];i++) {
    				if(key==a[i]) {
    					System.out.println("key found at index"+ i);
    				}
    		}
    			
    			else (key>)
    	}
    	
    	
    }

    static void print_array(int a[])
    {
        System.out.print("\nArray has:");
        for(int i:a)
            System.out.print(i+",");
    }
    
    static void Bubble_Sort(int a[]) {
        int pass=0;
        for (int i = 0; i < a.length - 1; i++)
        { for(int j=0;j<a.length-1;j++)
            {
                pass++;
                if(a[j]>a[j+1])
                {
                    int t=a[j];a[j]=a[j+1];a[j+1]=t;
                }
                System.out.println(pass);
            }

        }
    }
    
	static void heap_sort(int a[]) {
		int i, pc, j;
		for (i = a.length - 1; i > 0; i--) {
			for (j = 0; j <= i; j++) {
				pc = j;
				while (pc > 0) {
					if (a[pc] > a[pc / 2]) {
						int temp = a[pc];
						a[pc] = a[pc / 2];
						a[pc / 2] = temp;
						pc = pc / 2;// move to parent
					} // if
					else
						break;
				} // while
			} // for j
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
		} // for i
	}


    public static void main(String[] args) {
        int a[]={99,11,66,22,88,77,33,55,44};
        print_array(a);
        //Merge_Sort(a,0,a.length-1);
        //Quick_Sort(a,0,a.length-1);
        //Quick_Sort2(a,0,a.length-1);
        Insertion_Sort(a);
        print_array(a);
    }

}

