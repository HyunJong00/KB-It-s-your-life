import sys
input = sys.stdin.readline

n,m = map(int,input().split())

dontHearSet = set()
dontSeeSet = set()
for i in range(n):
    name = input().strip()
    dontHearSet.add(name)
for i in range(m):
    name = input().strip()
    dontSeeSet.add(name)
answer = sorted(dontHearSet & dontSeeSet)
print(len(answer))
for name in answer:
    print(name)
