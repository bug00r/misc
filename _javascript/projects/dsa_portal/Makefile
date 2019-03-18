PD=/

VERSION_DEL=.
VERSION_DEL_FIX=-
VERSION_FIX=1
VERSION_MINOR=0
VERSION_MAJOR=0
VERSION=$(VERSION_MAJOR)$(VERSION_DEL)$(VERSION_MINOR)$(VERSION_DEL_FIX)$(VERSION_FIX)

LOCALE_DEL=_
LOCALE_LANG=de
LOCALE_COUNTRY=DE
LOCALE=$(LOCALE_LANG)$(LOCALE_DEL)$(LOCALE_COUNTRY)

BUILD_ROOT=./build
BUILD_DIR=$(BUILD_ROOT)$(PD)$(VERSION)

TEMP_NAME=tmp
BUILD_TEMP=$(BUILD_DIR)$(PD)$(TEMP_NAME)

RES_SRC_NAME=resources
RES_SRC_DIR=./$(RES_SRC_NAME)

JS_SRC_NAME=js
JS_SRC_DIR=$(RES_SRC_DIR)$(PD)$(JS_SRC_NAME)

JS_DIR_NAME=js
JS_DIR=$(BUILD_DIR)$(PD)$(JS_DIR_NAME)

HTML_SRC_NAME=html
HTML_SRC_DIR=$(RES_SRC_DIR)$(PD)$(HTML_SRC_NAME)

TEXT_SRC_NAME=text
TEXT_SRC_DIR=$(RES_SRC_DIR)$(PD)$(TEXT_SRC_NAME)

NODE_CMD=./../../opt/node-v11.3.0-win-x64/node.exe
NODE_MAKE=$(NODE_CMD) ./build.js

all: mkbuild build

.PHONY: clean mkbuild build

build: 
	$(NODE_MAKE) build

prep_txt:
	sed -i -e '/text_resource/{ s/text_resource//g' \
	-e 'r $(TEXT_SRC_DIR)$(PD)$(LOCALE).json' \
	-e '}' $(JS_DIR)$(PD)resource.js

prep_xml:
	
copyindex:
	-cp $(HTML_SRC_DIR)$(PD)index.html $(BUILD_DIR)$(PD)index.html

copyjs:
	-cp -R $(JS_SRC_DIR) $(BUILD_DIR)

mkbuild:
	$(NODE_MAKE) mkbuild

clean:
	$(NODE_MAKE) clean

