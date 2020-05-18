#include<stdio.h>
#include<string.h>
#include<stdlib.h>
void main()
{
    char a[100],b[100];
    int f=0;
    printf("Enter string 1 : ");
    scanf("%s",a);
    printf("Enter string 2 : ");
    scanf("%s",b);
    if(strlen(a)!=strlen(b))
    {
        printf("The given two strings are not anagrams\n");
        exit(0);
    }
    for(int i=0;a[i]!='\0';i++)
    {
        for(int j=0;b[j]!='\0';j++)
        {
            if(a[i]==b[j])
                b[j]='-';
        }
    }
    for(int i=0;b[i]!='\0';i++)
    {
        if(b[i]=='-')
            f++;
    }
    if(f==strlen(b))
        printf("The given two strings are anagrams\n");
    else
        printf("The given two strings are not anagrams\n");
        
}
