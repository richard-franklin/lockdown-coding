d=int(input())
f=0
for i in range(d):
    s=list(map(int,input().split()))
    c=2*22*s[0]/7
    if c<=100*s[1]:
        f+=1
print(f)
