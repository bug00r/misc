all: opcodes build run asm hw

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

#-lkernel32 -luser32 -lgdi32 -lwinspool -lcomdlg32 -ladvapi32 -lshell32 -luuid -lole32 -loleaut32 -lcomctl32 -lws2_32 -lmsvcrt
asm:
	gcc test.s -g -ggdb --entry=WinMain -o test.exe
	./test.exe

hw:
	gcc hw.c -c
	objdump -D hw.o

.PHONY: clean

clean:
	-rm *.exe
	-rm *.o