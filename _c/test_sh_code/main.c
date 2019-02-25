#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int func1(int a, int b) {
	return a + b;
}

int func2(int a, int b) {
	return a - b;
}

//void func1() {
//	printf("func1\n");
//}
//
//void func2() {
//	printf("func2\n");
//}

const char _shell1[] = "\x55\x48\x89\xe5\x89\x4d\x10\x89\x55\x18\x8b\x55\x10\x8b\x45\x18\x01\xd0\x5d\xc3";
const char _shell2[] = "\x55\x48\x89\xe5\x89\x4d\x10\x89\x55\x18\x8b\x45\x10\x2b\x45\x18\x5d\xc3";

int main(int argc, char **argv) {
	
	int (*func)(int, int);
	//void (*func)();
	
	int a = 3;
	int b = 4;
	
	func = func1;
	//func();
	printf("(normal)	3 + 4: %i\n",func(a,b));
	
	func = func2;
	//func();
	printf("(normal)	3 - 4: %i\n",func(a,b));
	
	/*
	   0:   55                      push   %rbp
	   1:   48 89 e5                mov    %rsp,%rbp
	   4:   89 4d 10                mov    %ecx,0x10(%rbp)
	   7:   89 55 18                mov    %edx,0x18(%rbp)
	   a:   8b 55 10                mov    0x10(%rbp),%edx
	   d:   8b 45 18                mov    0x18(%rbp),%eax
	  10:   01 d0                   add    %edx,%eax
	  12:   5d                      pop    %rbp
	  13:   c3                      retq
	*/
	/*
	  \x55\x48\x89\xe5\x89\x4d\x10\x89\x55\x18\x8b\x55\x10\x8b\x45\x18\x01\xd0\x5d\xc3                      
	*/
	
	//const char shell1[] = "\x90\x90\x90\x90";
	char *shell1 = malloc(sizeof(_shell1));
	memcpy(shell1, &_shell1,sizeof(_shell1));
	//func = (void(*)())&shell1;
	//func();
	
	printf("(shell)	3 + 4: %i\n",((int(*)(int, int))shell1)(a, b));
	free(shell1);
	/*
		  14:   55                      push   %rbp
		  15:   48 89 e5                mov    %rsp,%rbp
		  18:   89 4d 10                mov    %ecx,0x10(%rbp)
		  1b:   89 55 18                mov    %edx,0x18(%rbp)
		  1e:   8b 45 10                mov    0x10(%rbp),%eax
		  21:   2b 45 18                sub    0x18(%rbp),%eax
		  24:   5d                      pop    %rbp
		  25:   c3                      retq
	*/
	/*
		  \x55\x48\x89\xe5\x89\x4d\x10\x89\x55\x18\x8b\x45\x10\x2b\x45\x18\x5d\xc3
	*/
	
	//const char shell2[] = "\x55\x48\x89\xe5\x48\x83\xec\x20\x48\x8d\x0d\x06\x00\x00\x00\xe8\x00\x00\x00\x00\x90\x48\x83\xc4\x20\x5d\xc3";
	//func = (int(*)(int, int))&shell2;
	//func = (void(*)())&shell2;
	//func();
	char *shell2 = malloc(sizeof(_shell2));
	memcpy(shell2, &_shell1,sizeof(_shell2));
	printf("(shell)	3 - 4: %i\n",((int(*)(int, int))shell2)(a, b));
	free(shell2);
	return 0;
}