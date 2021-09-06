#!/bin/sh

mkdir dist

x=$(find . -type d -name distributions)
echo $x

for i in $x; do 
   cp "$i"/*.zip  dist
done

cd  dist
 
for i in *; do mv "$i" $1_"$i"; done

cd ..

ls dist