PS = list(input())
stk = []
cnt = 0

for i in range(len(PS)):
  if PS[i] == '(':
    if PS[i+1] == ')':
      cnt+=len(stk)
    else:
      stk.append('(')
      cnt+=1
  else:
    if PS[i-1] != '(':
      stk.pop()

print(cnt)
