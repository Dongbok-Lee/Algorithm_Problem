num = list(map(int,input()))
num.reverse()
arr = []
sum = 0

for i in range(0,len(num)):
  if i%3 == 0 and i > 0:
    arr.append(sum)
    sum = 0
  sum += 2**(i%3)*num[i]
arr.append(sum)
for i in range(len(arr)-1,-1,-1):
  print(arr[i],end = '') 