num = int(input())
result = ''

if num == 0:
  print('0')

while num != 0:
  if num%(-2):
    result = '1' + result
    num = num//-2 + 1
  else:
    result = '0' + result
    num //=-2
print(result) 