import sys
N = int(input())
for i in range(N):
  (a,b) = map(int,sys.stdin.readline().split(' '))
  c = a*b
  a,b = max(a,b),min(a,b)
  while b != 0:
    a,b = b,a%b
  print(c//a) 