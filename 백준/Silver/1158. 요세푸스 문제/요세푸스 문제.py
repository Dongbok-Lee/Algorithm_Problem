N,K = map(int,input().split(' '))
arr = []
arr1 = []
arr2 = []
cursor = 0

print('<',end = '')

for i in range(N):
  arr.append(i+1)

for i in range(len(arr)):
  if len(arr) == 1:
    print(arr[0], end = '>')
  elif K%len(arr) == 0:
    arr1 = arr[0:len(arr)]
    print(arr1.pop(),end = ', ')
    arr = arr1    
  elif K > len(arr):
    arr1 = arr[0:K%len(arr)]
    arr2 = arr[K%len(arr):]
    print(arr1.pop(),end = ', ')
    arr = arr2 + arr1
  else:
    arr1 = arr[0:K]
    arr2 = arr[K:]
    print(arr1.pop(),end = ', ')
    arr = arr2 + arr1