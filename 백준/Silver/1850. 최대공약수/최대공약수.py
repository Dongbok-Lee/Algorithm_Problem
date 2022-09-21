(a,b) = map(int,input().split(' '))
a,b = max(a,b),min(a,b)
result = []
while b != 0:
  a,b = b,a%b

print('1'*a)