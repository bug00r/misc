all: pynoise

pynoise:
	../../Python34/python.exe setup.py build_ext -c mingw32 --build-lib . --build-temp build/temp

.PHONY: clean test

clean:
	-rm -dr build
	-rm *.pyd
	-rm *.c
test:
	../../Python34/python.exe test.py
