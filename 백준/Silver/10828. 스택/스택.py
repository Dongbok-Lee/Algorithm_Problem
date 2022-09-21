import sys
N = int(input())
li = []
i = 0 
stk = []

def push(i, stk, li):
    stk.append(int(li[i][1]))
    
def pop(stk):
    if len(stk) == 0:
        return -1
    else:
        tmp = stk[len(stk)-1]
        del stk[len(stk)-1]
        return tmp

def size(stk):
    return len(stk)

def empty(stk):
    if len(stk) == 0:
        return 1
    else:
        return 0

def top(stk):
    if len(stk) == 0:
        return -1
    else:
        return stk[len(stk)-1]

func = {'push':push, 'pop':pop, 'size':size, 
       'empty':empty,'top':top}

for _ in range(N):
    li.append(sys.stdin.readline().split())

for i in range(N):
    if li[i][0] == 'push':
      func[li[i][0]](i, stk, li)
    else:
      print(func[li[i][0]](stk))