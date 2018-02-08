for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 randomPivot_reverse.py $i > ./test/qsrandom_reverse_$i.txt
done
