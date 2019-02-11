all: test

test:
	-mv ./target/release/test_001.lib ./target/release/libtest_001.a
	-gcc -o test_ffi.exe main.c -L./target/release/ -ltest_001 -lgcc_eh -lshell32 -luserenv -lws2_32 -ladvapi32
	-strip test_ffi.exe

.PHONY: clean

clean:
	-rm test_ffi.exe