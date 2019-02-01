> MINGW64 /c/dev/testplace/repo/_lua/_learning_
$ make
./../lua-5.3.4/bin/lua.exe ./test.lua
Hello World

> MINGW64 /c/dev/testplace/repo/_lua/_learning_
$ make JIT=1
./../LuaJIT-2.0.5/bin/luajit.exe ./test.lua
Hello World


#############
# LUA hints #
#############

# $ make USE_DLL=1 USE_LUA53=1 USE_IMLUA=1 USE_CDLUA=1 USE_IUPLUA=1 USE_IM=1 USE_CD=1 USE_IUPWEB=0 TEC_UNAME=dllg4_64 EXTRAINCS=-DGCC_WINDRES
# $ make USE_DLL=1 USE_LUA51=1 TEC_UNAME=dllg4_64 EXTRAINCS=-DGCC_WINDRES
# make USE_LUA51=1 TEC_UNAME=gcc4_64 EXTRAINCS=-DGCC_WINDRES

I want to do this:

Die Lua Bindings für iupcontrols funktionieren nicht. Die community kann auch nichts darüber sagen.
Vielleicht habe ich einen seltsamen Fall erschaffen. für mich ist das thema Lua IUP beendet.

1. lua mit UI lib ans laufen bekommen
2. lua mit UI lib über LED verwenden 
3. UI lib ohne LED über C ansprechen
4. UI Lib mit LED als binary extension ansprechen
5. alles statisch linken
 




