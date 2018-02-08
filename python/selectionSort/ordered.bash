for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 selectionOrdered.py $i > ./test/selection_Ordered_$i.txt
done
