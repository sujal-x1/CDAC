package day_6_Sorting_Algos;

public class Merge_Sorting
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
    static void print_array(int a[])
    {
        System.out.print("\nArray has:");
        for(int i:a)
            System.out.print(i+",");
    }

    public static void main(String[] args) {
        int a[]={99,11,66,22,88,77,33,55,44,};
        print_array(a);
        Merge_Sort(a,0,a.length-1);
        print_array(a);
    }

}
