#
#           POWER FUNCTION
#           ---------------
#EAX - BASE
#EDI - EXP
# 2 * 2 * 2 * 2 * 2 = 2^5
#
#.section .data
#
#.section .text
#
#    .globl WinMain 
#
#        WinMain:
#                mov $1, %ebx
#                pushq $2
#                pushq $5
#                call _powr
#                jmp _eof
#
#                _powr:
#                    pushq %rax
#                    movl  %esp, %ebp
#                    subl  $4, %esp
#                    movl 8(%ebp),%edi
#                    movl 12(%ebp) , %eax
#                    call powr_loop
#                    movl %ebp, %esp
#                    popq %rax
#                    ret;
#
#
#                powr_loop:
#                    cmp $0,%edi
#                    je _return
#                    #ebx = ebx * eax
#                    imull %eax,%ebx
#                    decl %edi
#                    jmp powr_loop
#
#                _return:
#                    ret
#                _eof:
#                    call _exit
#
#/*****************************************************************************
#* powers.s
#*
#* Displays powers of 2 from 2^0 to 2^31, one per line.  It should be linked
#* with a C runtime library.  The C runtime library contains startup code
#* so you do not have to specify a starting label.  The startup code in
#* the C library eventually calls main.
#*
#* Assembler: gas
#* OS: Any Win32-based OS
#* Other libraries: Use the gccs C runtime library
#* Assemble and link: "gcc powers.s" (gcc links the C library automatically)
#*****************************************************************************/
#
#        .global WinMain
#		.extern printf
#        .text
#format: .asciz  "%d\n"
#
#WinMain:
#        pushq   %rsi                    /* callee save registers */
#        pushq   %rdi
#        
#        movq    $1, %rsi                /* current value */
#        movq    $31, %rdi               /* counter */
#L1:
#        pushq   %rsi                    /* push value of number to print */
#        #pushq   $format                 /* push address of format */
#		movq $format, %rdi
#		call    printf
#        addq    $8, %rsp
#
#        addq    %rsi, %rsi              /* double value */
#        decq    %rdi                    /* keep counting */
#        jnz     L1
#        
#        popq    %rdi
#        popq    %rsi
#        ret
# ----------------------------------------------------------------------------------------
# Writes "Hola, mundo" to the console using a C library. Runs on Linux or any other system
# that does not use underscores for symbols in its C library. To assemble and run:
#
#     gcc hola.s && ./a.out
# ----------------------------------------------------------------------------------------
# -----------------------------------------------------------------------------
# A 64-bit program that displays its commandline arguments, one per line.
#
# On entry, %rdi will contain argc and %rsi will contain argv.
# -----------------------------------------------------------------------------

        .global WinMain

        .text
WinMain:
        push    %rdi                    # save registers that puts uses
        push    %rsi
        sub     $8, %rsp                # must align stack before call

        mov     (%rsi), %rdi            # the argument string to display
        call    puts                    # print it

        add     $8, %rsp                # restore %rsp to pre-aligned value
        pop     %rsi                    # restore registers puts used
        pop     %rdi

        add     $8, %rsi                # point to next argument
        dec     %rdi                    # count down
        jnz     main                    # if not done counting keep going

        ret
format:
        .asciz  "%s\n"
 