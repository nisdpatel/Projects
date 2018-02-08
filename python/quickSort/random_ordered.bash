for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 randomPivot_ordered.py $i > ./test/qsrandom_ordered_$i.txt
done
