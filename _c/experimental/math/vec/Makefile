CC=gcc
CFLAGS=-std=c11 -C

AR=ar
ARFLAGS=rcs

BUILDDIR=build
PATHSEP=/

SRC=vec.c

LIBNAME=libvec.a
OBJS=vec.o

TESTSRC=test_vec.c
TESTBIN=test_vec.exe
TESTLIB=-lvec
TESTLIBDIR=-L$(BUILDDIR)


all: vector test

vector:
	mkdir -p $(BUILDDIR)
	$(CC) $(CFLAGS) -c $(SRC) -o $(BUILDDIR)$(PATHSEP)$(OBJS)
	$(AR) $(ARFLAGS) $(BUILDDIR)$(PATHSEP)$(LIBNAME) $(BUILDDIR)$(PATHSEP)$(OBJS)

test:
	$(CC) $(CFLAGS) $(TESTSRC) -o $(BUILDDIR)$(PATHSEP)$(TESTBIN) $(TESTLIBDIR) $(TESTLIB)
	./$(BUILDDIR)$(PATHSEP)$(TESTBIN)

.PHONY: clean

clean:
	rm -dr $(BUILDDIR)
	