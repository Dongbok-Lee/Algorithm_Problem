import sys
stk = list(input())
N = int(input())
stk2 = []
cmd =[]

for i in range(N):
  cmd.append(sys.stdin.readline().strip('\n').split(' '))
for i in range(len(cmd)):
  if cmd[i][0] == 'L':
    if len(stk) != 0:
      tmp = stk.pop()
      stk2.append(tmp)
  elif cmd[i][0] == 'D':
    if len(stk2) != 0:
      tmp = stk2.pop()
      stk.append(tmp)
  elif cmd[i][0] == 'B':
    if len(stk) != 0:
      stk.pop()
  elif cmd[i][0] == 'P':
    stk.append(cmd[i][1])

for i in range(len(stk)):
  print(stk[i], end = '')
for j in range(len(stk2)):
  print(stk2[(len(stk2)-1)-j], end = '')