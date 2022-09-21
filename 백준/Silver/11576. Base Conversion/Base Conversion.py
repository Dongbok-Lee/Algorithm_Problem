A,B = map(int,input().split())
N = int(input())
Aarr = list(map(int,input().split(' ')))
ten = 0
Aarr.reverse()
Barr = []

for i in range(len(Aarr)):
  ten += Aarr[i]*(A**i)

while ten >= B:
  Barr.append(ten%B)
  ten = ten//B
Barr.append(ten)
Barr.reverse()

for i in Barr:
  print(i,end = ' ')