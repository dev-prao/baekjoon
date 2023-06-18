word = list(input())
answer = []
temp = []

for i in range(1,len(word)-1):
    for j in range(i+1, len(word)):
        a = word[:i]
        b = word[i:j]
        c = word[j:]
        a.reverse()
        b.reverse()
        c.reverse()
        temp.append(a+b+c)
        
for piece in temp:
    answer.append(''.join(piece))
    
print(sorted(answer)[0])