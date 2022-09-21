import sys
N  = int(input())
deque = []
cmd = []

for _ in range(N):
  cmd.append(sys.stdin.readline().split())

def push_back(i, cmd, deque):
  deque.insert(0,int(cmd[i][1]))

def push_front(i, cmd, deque):
  deque.append(int(cmd[i][1]))

def pop_front(deque):
  if len(deque) != 0:
    return deque.pop()
  else:
    return -1

def pop_back(deque):
  if len(deque) != 0:
    return deque.pop(0)
  else:
    return -1   

def front(deque):
  if len(deque) == 0:
    return -1
  else:
    return deque[len(deque)-1]

def back(deque):
  if len(deque) == 0:
    return -1
  else:
    return deque[0]

def size(deque):
  return len(deque)

def empty(deque):
  if len(deque) == 0:
    return 1
  else:
    return 0

func = {'front':front, 'back':back, 'pop_front':pop_front, 'pop_back':pop_back, 'size':size, 
       'empty':empty, 'push_front':push_front, 'push_back':push_back}

for i in range(N):
  if cmd[i][0] == 'push_front':
    push_front(i, cmd, deque)
  elif cmd[i][0] == 'push_back':
    push_back(i, cmd, deque)
  else:
    print(func[cmd[i][0]](deque))