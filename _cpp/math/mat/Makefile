BUILDROOT?=build
BUILDDIR?=$(BUILDROOT)/g++
BUILDPATH?=$(BUILDDIR)/

ifeq ($(DEBUG),1)
	debug=-Ddebug=1
endif

ifeq ($(ANALYSIS),1)
	analysis=-Danalysis=1
endif

ifeq ($(DEBUG),2)
	debug=-Ddebug=2
endif

ifeq ($(DEBUG),3)
	debug=-Ddebug=3
endif

CFLAGS=-std=c++11 -Wpedantic -pedantic-errors -Wall -Wextra -O1 $(debug)
#-ggdb
#-pg for profiling 
SRC=mat.cpp

LIBNAME=libmat.a
OBJS=mat.o

TESTSRC=test_mat.cpp
TESTBIN=test_mat.exe
TESTLIB=-lmat
TESTLIBDIR=-L$(BUILDDIR)

all: createdir $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(TESTBIN) test

$(BUILDPATH)$(LIBNAME): $(BUILDPATH)$(OBJS)
	$(AR) $(ARFLAGS) $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(OBJS)

$(BUILDPATH)$(OBJS): mat.cpp mat2.cpp mat3.cpp mat4.cpp mat.h mat2.h mat3.h mat4.h
	$(CXX) $(CFLAGS) -c $(SRC) -o $(BUILDPATH)$(OBJS)

$(BUILDPATH)$(TESTBIN): $(TESTSRC)
	$(CXX) $(CFLAGS) $(TESTSRC) -o $(BUILDPATH)$(TESTBIN) $(TESTLIBDIR) $(TESTLIB) 
	
.PHONY: clean test createdir

createdir:
	mkdir -p $(BUILDDIR)

test:
	./$(BUILDPATH)$(TESTBIN)
	
clean:
	-rm -dr $(BUILDROOT)
	