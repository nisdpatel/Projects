#Name: Nisha Patel
#File : selectionOrdered.py
# Description : implementation of Cormen Selection Sort Algorithm for ordered n numbers




import sys
n = sys.argv[1]
A = []
for item in range(1,int(n)):
    A.append(item)
print("Unsorted",A)

for i in range(0,len(A)-1):
    min = i
    for j in range(i+1,len(A)):
        if A[j] < A[min]:
            min = j
    A[min],A[i] = A[i],A[min]

print("\n Sorted",A)
