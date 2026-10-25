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
