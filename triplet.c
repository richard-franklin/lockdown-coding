#include<stdio.h>
int main() 
{
    int t, n,i,k,j,ans;
    scanf("%d",&t);
    while (t--)
    {
    	int c = 0;
        scanf("%d",&n);
        int a[n];
        for ( i = 0; i < n; i++)
        {
            scanf("%d",&a[i]);            
        }
    
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            ans = a[i] + a[j];
            for(k=0;k<n;k++)
            {
                if(ans == a[k])
                {
                    c++;
                }
            }

        }
    }
    if(c == 0)
    {
    	c = -1;
	}
    printf("%d\n",c);

    }
    return 0;
}
