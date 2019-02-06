all: test

test:
	gcc -o test_ffi.exe main.c ./target/release/test_001.lib -lgcc_eh -lshell32 -luserenv -lws2_32 -ladvapi32

.PHONY: clean

clean:
	-rm test_ffi.exe