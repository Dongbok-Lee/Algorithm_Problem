(arr,num) = map(str,input().split(' '))
arr = list(arr)
num = int(num)
sum = 0
arr.reverse()

for i in range(len(arr)):
  if ord(arr[i]) > 64:
    sum +=  (ord(arr[i])-55)*(num**i)
  else:
    sum += int(arr[i])*(num**i)
print(sum)