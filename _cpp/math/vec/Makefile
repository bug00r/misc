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

INCLUDEDIR=-I./../mat

SRC=vec.cpp

LIBNAME=libvec.a
OBJS=vec.o

TESTSRC=test_vec.cpp
TESTBIN=test_vec.exe
TESTLIB=-lvec -lmat
TESTLIBDIR=-L$(BUILDDIR) \
		   -L./../mat/$(BUILDDIR)

all: createdir $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(TESTBIN) test

$(BUILDPATH)$(LIBNAME): $(BUILDPATH)$(OBJS)
	$(AR) $(ARFLAGS) $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(OBJS)
	
$(BUILDPATH)$(OBJS): vec.cpp vec2.cpp vec3.cpp vec.h vec2.h vec3.h
	$(CXX) $(CFLAGS) -c $(SRC) -o $(BUILDPATH)$(OBJS) $(INCLUDEDIR)
	
$(BUILDPATH)$(TESTBIN): $(TESTSRC)
	$(CXX) $(CFLAGS) $(TESTSRC) -o $(BUILDPATH)$(TESTBIN) $(TESTLIBDIR) $(INCLUDEDIR) $(TESTLIB)
	
.PHONY: clean createdir test

test:
	./$(BUILDPATH)$(TESTBIN)

createdir:
	mkdir -p $(BUILDDIR)

clean:
	-rm -dr $(BUILDROOT)
	