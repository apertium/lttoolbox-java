lt-comp lr apertium-sh-mk.translit.dix translit.bin

echo Expected output:
echo "То је прова"
echo 

echo Actual output:
echo "To je prova" | lt-proc -t translit.bin

