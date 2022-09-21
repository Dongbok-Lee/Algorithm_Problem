num = int(input())
cnt2 = 0
cnt5 = 0

for i in range(num,1,-1):
  if i%2 == 0:
    while i%2 == 0:
      i//=2
      cnt2 += 1
  if i%5 == 0:
    while i%5 == 0:
      i//=5
      cnt5 += 1

print(min(cnt2,cnt5))