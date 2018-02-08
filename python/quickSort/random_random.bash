for ((i=500; i<=10000; i+=500));
do
    /usr/bin/time python3 randomPivot_random.py $i > ./test/qsrandom_random_$i.txt
done
