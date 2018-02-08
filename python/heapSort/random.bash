for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 heapSortRandom.py $i > ./test/heapSort_random$i.txt
done
