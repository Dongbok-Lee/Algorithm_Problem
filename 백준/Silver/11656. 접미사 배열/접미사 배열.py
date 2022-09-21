arr = list(input())
arr2 = []
for i in range(len(arr)):
  arr2.append(arr[i:])
arr2.sort()
for i in range(len(arr)):
  for j in range(len(arr2[i])):
    print(arr2[i][j],end = '')
  print()