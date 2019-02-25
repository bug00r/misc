all: opcodes build run

#gcc -S -c tst.c -o -
# or 
#gcc -g -ggdb -c tst.c
#objdump -S tst.o
# or..char array
# gcc -c tst.c
#objdump -D -j .data tst.o

build:
	gcc main.c -o main.exe
run: 
	-./main.exe
opcodes:
	gcc main.c -c
	objdump -D main.o

.PHONY: clean

clean:
	-rm *.exe
	-rm *.o