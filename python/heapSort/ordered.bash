for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 heapSortOrdered.py $i > ./test/heapSort_ordered_$i.txt
done