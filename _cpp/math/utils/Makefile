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

SRC=utils_math.cpp

LIBNAME=libutilsmath.a
OBJS=utils_math.o

INCLUDEDIR=-I./../vec -I./../mat

TESTSRC=test_utils_math.cpp
TESTBIN=test_utils_math.exe
TESTLIB= -lutilsmath -lmat -lvec  
TESTLIBDIR=-L$(BUILDDIR) \
		   -L./../mat/$(BUILDDIR) \
		   -L./../vec/$(BUILDDIR) \

all: createdir $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(TESTBIN) test

$(BUILDPATH)$(LIBNAME): $(BUILDPATH)$(OBJS)
	$(AR) $(ARFLAGS) $(BUILDPATH)$(LIBNAME) $(BUILDPATH)$(OBJS)

$(BUILDPATH)$(OBJS): utils_math.cpp utils_math.h
	$(CXX) $(CFLAGS) -c $(SRC) -o $(BUILDPATH)$(OBJS) $(INCLUDEDIR) 
	
$(BUILDPATH)$(TESTBIN):
	$(CXX) $(CFLAGS) $(TESTSRC) -o $(BUILDPATH)$(TESTBIN) $(INCLUDEDIR) $(TESTLIBDIR) $(TESTLIB) $(debug)

.PHONY: clean createdir test

test:
	./$(BUILDPATH)$(TESTBIN)

createdir:
	mkdir -p $(BUILDDIR)

clean:
	-rm -dr $(BUILDROOT)
	