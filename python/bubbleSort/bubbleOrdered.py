#Name: Nisha Patel
#File : bubbleOrdered.py
# Description : implementation of Cormen Bubble Sort Algorithm for ordered n numbers

import sys
n = sys.argv[1]
A = []
for item in range(1,int(n)):
    A.append(item)
print("Unsorted",A)

for i in range(0, len(A)):
    for j in range(len(A)-1, i, -1):
        if A[j] < A[j-1]:
            A[j],A[j-1] = A[j-1],A[j]
                
print("\n Sorted",A)
