n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=0
for i in range(n):
    for j in range(n):
        if a[j]>b[j]:
            a[j]=a[j]-b[j]
            c+=1
