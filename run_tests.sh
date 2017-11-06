#!/bin/bash
cd tests/input
for i in *.txt
do
	echo "running test $i"
	../../qbasic.sh tests/accounts/$i tests/output/produced/$i < $i > ../logs/$i.log
done