import sys
N = int(input())

for i in range(N):
    
  result = 0
  case = list(map(int,sys.stdin.readline().split(' ')))
    
  for j in range(1,len(case)):
    for k in range(j+1,len(case)):
        
      a,b = max(case[j],case[k]),min(case[j],case[k]) 
    
      while b != 0:
        a,b = b,a%b
        
      result += a
    
  print(result)