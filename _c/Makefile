export MAKE=mingw32-make
export AR=ar
export ARFLAGS=rcs
export PATHSEP=/
export CC=gcc
export BUILDROOT=build

ifeq ($(CLANG),1)
	export CC=clang
endif

export BUILDDIR=$(BUILDROOT)$(PATHSEP)$(CC)
export BUILDPATH=$(BUILDDIR)$(PATHSEP)

ifeq ($(DEBUG),1)
	export debug=-Ddebug=1
	export isdebug=1
endif

ifeq ($(ANALYSIS),1)
	export analysis=-Danalysis=1
	export isanalysis=1
endif

ifeq ($(DEBUG),2)
	export debug=-Ddebug=2
	export isdebug=1
endif

ifeq ($(DEBUG),3)
	export debug=-Ddebug=3
	export isdebug=1
endif

ifeq ($(OUTPUT),1)
	export outimg=-Doutput=1
endif

.PHONY: all clean tetris collections math color shape mesh scene texture renderer renderer_ui_iup renderer_ui_sdl

all: renderer_ui_iup renderer_ui_sdl

collections:
	$(MAKE) -C data
	$(MAKE) -C collections

math:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math

color:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C color

shape:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape

mesh:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape
	$(MAKE) -C mesh

scene:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape
	$(MAKE) -C mesh
	$(MAKE) -C scene

texture:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C texture

renderer:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape
	$(MAKE) -C mesh
	$(MAKE) -C scene
	$(MAKE) -C texture
	$(MAKE) -C renderer

renderer_ui_iup:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape
	$(MAKE) -C mesh
	$(MAKE) -C scene
	$(MAKE) -C texture
	$(MAKE) -C renderer
	$(MAKE) -C renderer_ui_iup
	
renderer_ui_sdl:
	$(MAKE) -C data
	$(MAKE) -C collections
	$(MAKE) -C math
	$(MAKE) -C color
	$(MAKE) -C shape
	$(MAKE) -C mesh
	$(MAKE) -C scene
	$(MAKE) -C texture
	$(MAKE) -C renderer
	$(MAKE) -C renderer_ui_sdl

tetris:
	$(MAKE) -C tetris
	
clean:
	$(MAKE) -C data clean
	$(MAKE) -C collections clean
	$(MAKE) -C math clean
	$(MAKE) -C color clean
	$(MAKE) -C shape clean
	$(MAKE) -C mesh clean
	$(MAKE) -C scene clean
	$(MAKE) -C texture clean
	$(MAKE) -C renderer clean
	$(MAKE) -C renderer_ui_iup clean
	$(MAKE) -C renderer_ui_sdl clean
	