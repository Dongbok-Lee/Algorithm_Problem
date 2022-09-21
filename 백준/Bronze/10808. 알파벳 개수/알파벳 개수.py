alpha = list(0 for _ in range(26))
array = list(input())
for i in range(len(array)):
  alpha[ord(array[i])-97] += 1

for i in range(len(alpha)):
  print(alpha[i],end = ' ')
