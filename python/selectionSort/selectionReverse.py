#Name: Nisha Patel
#File : selectionReverse.py
# Description : implementation of Cormen Selection Sort Algorithm for reserved n numbers


import sys
n = sys.argv[1]
A = []
for item in range(int(n) ,0, -1):
    A.append(item)
print("Unsorted",A)
for i in range(0,len(A)-1):
    min = i
    for j in range(i+1,len(A)):
        if A[j] < A[min]:
            min = j
    A[min],A[i] = A[i],A[min]

print("\n Sorted",A)
