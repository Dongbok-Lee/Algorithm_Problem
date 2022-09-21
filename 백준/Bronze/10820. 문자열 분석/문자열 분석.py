import sys

while True:
	line = sys.stdin.readline().rstrip('\n')
	ulds = [0,0,0,0]
	if not line:
		break
	for i in line:
		if i.islower():
			ulds[0] += 1
		elif i.isupper():
			ulds[1] += 1
		elif i.isdigit():
			ulds[2] += 1
		elif i.isspace():
			ulds[3] += 1
	print(ulds[0],ulds[1],ulds[2],ulds[3])