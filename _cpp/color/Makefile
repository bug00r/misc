CFLAGS=-std=c++11 -Wpedantic -pedantic-errors -Wall -Wextra -O1 $(debug)
#-ggdb
#-pg for profiling 

BUILDROOT?=build
BUILDDIR?=$(BUILDROOT)/g++
BUILDPATH?=$(BUILDDIR)/

INCLUDEDIR=-I.

SRC=color.cpp

LIBNAME=libcolor.a
OBJS=color.o

TESTSRC=test_color.cpp
TESTBIN=test_color.exe
TESTLIB=-lcolor
TESTLIBDIR=-L$(BUILDDIR)

all: createdir $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(TESTBIN) test_color

$(BUILDPATH)$(LIBNAME): $(BUILDPATH)$(OBJS)
	$(AR) $(ARFLAGS) $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(OBJS)

$(BUILDPATH)$(OBJS): color.cpp color.h
	$(CXX) $(CFLAGS) -c $(SRC) -o $(BUILDPATH)$(OBJS) $(INCLUDEDIR)
	
$(BUILDPATH)$(TESTBIN): test_color.cpp
	$(CXX) $(CFLAGS) $(TESTSRC) -o $(BUILDPATH)$(TESTBIN) $(INCLUDEDIR) $(TESTLIBDIR) $(TESTLIB)
	
.PHONY: test_color clean createdir

createdir:
	mkdir -p $(BUILDDIR)

clean:
	-rm -dr $(BUILDROOT)

test_color:
	./$(BUILDPATH)$(TESTBIN)