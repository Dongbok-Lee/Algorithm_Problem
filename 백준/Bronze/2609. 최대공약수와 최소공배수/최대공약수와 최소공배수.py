(a,b) = map(int,input().split(' '))
c = 0

for i in range(1,max(a,b)+1):
  if a%i == 0 and b%i == 0:
    c = max(i,c)
print(c, c*(a//c)*(b//c),sep='\n')