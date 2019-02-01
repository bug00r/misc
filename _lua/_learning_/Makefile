export LUA_BIN:=./../../_third_/tec_tools/release/dll/lua.exe
export LUA_JIT_BIN:=./../LuaJIT-2.0.5/bin/luajit.exe

export LUA:=$(LUA_BIN)

ifeq ($(JIT),1)
	export LUA:=$(LUA_JIT_BIN)
endif

test:
	$(LUA) ./$@.lua

coroutine:
	$(LUA) ./$@.lua

types:
	$(LUA) ./$@.lua
	
iup_test:
	$(MAKE) -C iup
