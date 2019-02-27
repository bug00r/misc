#WINDOWS: RCX, RDX, R8, R9
#
#The Microsoft x64 calling convention is followed on Windows and pre-boot UEFI (for long mode on x86-64). 
#It uses registers 
#
#RCX, RDX, R8, R9 for the first four integer or pointer arguments (in that order), 
#and XMM0, XMM1, XMM2, XMM3 are used for floating point arguments. Additional arguments 
#are pushed onto the stack (right to left). 
#Integer return values (similar to x86) are returned in RAX if 64 bits or less. 
#Floating point return values are returned in XMM0. Parameters less than 64 bits long are not zero extended; 
#the high bits are not zeroed.
#
#LINUX/OSX: RDI, RSI, RDX, RCX, R8, R9
#
#The calling convention of the System V AMD64 ABI is followed on Solaris, Linux, FreeBSD, OS X, and other UNIX-like or
#POSIX-compliant operating systems. 
#
#The first six integer or pointer arguments are passed in registers RDI, RSI, RDX, RCX, R8, and R9, 
#while XMM0, XMM1, XMM2, XMM3, XMM4, XMM5, XMM6 and XMM7 are used for floating point arguments. 
#For system calls, R10 is used instead of RCX. As in the Microsoft x64 calling convention, 
#additional arguments are passed on the stack and the return value is stored in RAX.
#
#.extern printf
#.extern exit
#.data
#_hello:
#  .asciz "hello world\n"
#
#.text
#.globl WinMain
#WinMain:
#  subq $8, %rsp
#  movb $0, %al
#  leaq _hello(%rip), %rcx
#  call printf
#
#  movq $0, %rcx
#  call exit
#  ret
# 
        .global WinMain

        .text
WinMain:                                   # This is called by C library's startup code
		mov     $message, %rcx          # First integer (or pointer) parameter in %rdi
        call    puts                    # puts(message)
		movq $0, %rcx
		call exit
		ret                            # Return to C library code
message:
        .asciz "Hola, mundo"            # asciz puts a 0 byte at the end
