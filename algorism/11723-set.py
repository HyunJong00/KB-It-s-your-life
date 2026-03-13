import sys
input = sys.stdin.readline



s = set()

m = int(input())
for i in range(m):
    order = list(input().split())
    if order[0] == 'add': s.add(int(order[1]))
    elif order[0] == 'check':
         print(1 if order[1] in s else 0)
    elif order[0] == 'remove':
            s.discard(order[1])
    elif order[0] == 'toggle':
        if order[1] in s: s.discard(order[1])
        else: s.add(int(order[1]))
    elif order[0] == 'all':
        s = set(list(range(1,21)))
    elif order[0] == 'empty':
        s=set()
