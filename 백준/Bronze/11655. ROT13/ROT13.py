arr = list(input())
for i in range(len(arr)):
  if arr[i].isupper():
    arr[i] = chr(((((ord(arr[i])-65)+13)%26)+65))
  elif arr[i].islower():
    arr[i] = chr(((((ord(arr[i])-97)+13)%26)+97))
  print(arr[i],end = '')