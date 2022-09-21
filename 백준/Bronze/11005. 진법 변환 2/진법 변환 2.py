(N,B) = map(int,input().split(' '))
arr = []

while N >= B:
    
  rem,N = N%B,N//B

  if rem > 9:
    rem = chr(rem+55)
  arr.append(rem)

if N > 9:
  N = chr(N+55)
arr.append(N)

for i in range(len(arr)-1,-1,-1):
  print(arr[i],end = '')