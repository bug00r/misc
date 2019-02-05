//memory
import std.stdio;

void sichereFunktion() 
{
	writeln("Hallo Welt!!");
	int *p = new int;
}

void unsichereFunktion() 
{
	int *p = new int;
	int *memarith = p + 5;
}


void main() 
{
	sichereFunktion();
	unsichereFunktion();
}