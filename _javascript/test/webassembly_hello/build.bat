@echo off
::this is for relative developement

call %~dp0\..\..\opt\emsdk\emsdk_env.bat

call emcc hello.c -s WASM=1 -o hello.html
