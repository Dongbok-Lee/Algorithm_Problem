N = int(input())

for _ in range(N):
  stk = []
  PS = list(input())

  for i in PS:
    if i == '(':
      stk.append(i)
    else:
      if len(stk) == 0:
        stk.append(i)
        break
      else :
        stk.pop()
  if len(stk) != 0:
    print('NO')
  else:
    print('YES')