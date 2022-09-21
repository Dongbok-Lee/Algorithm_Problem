N  = int(input())
Que = []
cmd = []

for _ in range(N):
  cmd.append(input().split())

def push(i, cmd, Que):
  Que.insert(0,int(cmd[i][1]))

def pop(Que):
  if len(Que) != 0:
    return Que.pop()
  else:
    return -1

def front(Que):
  if len(Que) == 0:
    return -1
  else:
    return Que[len(Que)-1]

def back(Que):
  if len(Que) == 0:
    return -1
  else:
    return Que[0]

def size(Que):
  return len(Que)

def empty(Que):
  if len(Que) == 0:
    return 1
  else:
    return 0

func = {'push':push, 'pop':pop, 'size':size, 
       'empty':empty,'front':front, 'back':back}

for i in range(N):
  if cmd[i][0] == 'push':
    push(i, cmd, Que)
  else:
    print(func[cmd[i][0]](Que))