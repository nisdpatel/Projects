for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 selectionReverse.py $i > ./test/selection_Reverse_$i.txt
done
