for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 bubbleOrdered.py $i > ./test/bubble_Ordered_$i.txt
done
