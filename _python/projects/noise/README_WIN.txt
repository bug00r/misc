Microsoft Windows [Version 10.0.15063]
(c) 2017 Microsoft Corporation. Alle Rechte vorbehalten.

C:\Users\BReimann>cd c:\dev\testplace\repo\_python\projects\hello

c:\dev\testplace\repo\_python\projects\hello>cl /LD hello.c /Ic:\dev\testplace\repo\_python\Python34\include c:\dev\testplace\repo\_python\Python34\libs\python34.lib /link/out:hello.dll
Microsoft (R) C/C++-Optimierungscompiler Version 16.00.30319.01 für x64
Copyright (C) Microsoft Corporation. Alle Rechte vorbehalten.

hello.c
c:\dev\testplace\repo\_python\python34\include\pyconfig.h(68) : fatal error C1083: Datei (Include) kann nicht geöffnet werden: "io.h": No such file or directory

c:\dev\testplace\repo\_python\projects\hello>cd C:\Program Files (x86)\Microsoft Visual Studio 10.0\VC

C:\Program Files (x86)\Microsoft Visual Studio 10.0\VC>vcvarsall.bat
Setting environment for using Microsoft Visual Studio 2010 x86 tools.

C:\Program Files (x86)\Microsoft Visual Studio 10.0\VC>vcvarsall.bat x86_amd64
Setting environment for using Microsoft Visual Studio 2010 x64 cross tools.

C:\Program Files (x86)\Microsoft Visual Studio 10.0\VC>cd c:\dev\testplace\repo\_python\projects\hello

c:\dev\testplace\repo\_python\projects\hello>cl /LD hello.c /Ic:\dev\testplace\repo\_python\Python34\include c:\dev\testplace\repo\_python\Python34\libs\python34.lib /link/out:hello.dll
Microsoft (R) C/C++ Optimizing Compiler Version 16.00.30319.01 for x64
Copyright (C) Microsoft Corporation.  All rights reserved.

hello.c
Microsoft (R) Incremental Linker Version 10.00.30319.01
Copyright (C) Microsoft Corporation.  All rights reserved.

/out:hello.dll
/dll
/implib:hello.lib
/out:hello.dll
hello.obj
c:\dev\testplace\repo\_python\Python34\libs\python34.lib
   Bibliothek "hello.lib" und Objekt "hello.exp" werden erstellt.

c:\dev\testplace\repo\_python\projects\hello>
