for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 heapSortReverse.py $i > ./test/heapSort_reverse$i.txt
done
