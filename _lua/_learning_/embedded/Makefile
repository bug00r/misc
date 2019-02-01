MAKE?=mingw32-make
AR?=ar
ARFLAGS?=rcs
PATHSEP?=/
CC=gcc
BUILDROOT?=build

ifeq ($(CLANG),1)
	export CC=clang
endif

BUILDDIR?=$(BUILDROOT)$(PATHSEP)$(CC)
BUILDPATH?=$(BUILDDIR)$(PATHSEP)

ifeq ($(DEBUG),1)
	export debug=-Ddebug=1  -ggdb
	export isdebug=1
endif

ifeq ($(ANALYSIS),1)
	export analysis=-Danalysis=1
	export isanalysis=1
endif

ifeq ($(DEBUG),2)
	export debug=-Ddebug=2  -ggdb
	export isdebug=1
endif

ifeq ($(DEBUG),3) 
	export debug=-Ddebug=3  -ggdb
	export isdebug=1
endif

ifeq ($(OUTPUT),1)
	export outimg=-Doutput=1
endif

CFLAGS=-std=c11 -Wpedantic -pedantic-errors -Wall -Wextra
#-ggdb -O1 
#-pg for profiling 

INCLUDEDIR=-I. -I./../../../_third_/tec_tools/lua53

SRC=embedded_lua.c

LIBNAME=embedded_lua.a
OBJS=embedded_lua.o

TESTSRC=embedded_lua.c
TESTBIN=embedded_lua.exe
TESTLIB=-llua
TESTLIBDIR=-L$(BUILDPATH) -L./../../../_third_/tec_tools/release/static


all: createdir $(BUILDPATH)$(TESTBIN) test
	
$(BUILDPATH)$(TESTBIN):
	$(CC) $(CFLAGS) $(debug) $(TESTSRC) -o $(BUILDPATH)$(TESTBIN) $(INCLUDEDIR) $(TESTLIBDIR) $(TESTLIB)

.PHONY: clean createdir test

test:
	./$(BUILDPATH)$(TESTBIN)

createdir:
	mkdir -p $(BUILDDIR)

clean:
	-rm -dr $(BUILDROOT)
	