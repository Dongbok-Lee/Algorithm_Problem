num,num2 = map(int,input().split(' '))
cnt2 = 0
cnt5 = 0

def countNum(num, div):
  cnt = 0
  temdiv = div
  while num >= temdiv:
    cnt = cnt + (num // temdiv)
    temdiv = temdiv * div
  return cnt

print(min(countNum(num,5) - countNum(num2,5) - countNum(num-num2,5),countNum(num,2) - countNum(num2,2) - countNum(num-num2,2)))