//type qualifier
import std.stdio: writeln;

void main()
{
	int m = 100; // mutable
	writeln("m: ", typeof(m).stringof);
	m = 10; //ok
	
	const int *cm = &m;
	writeln("cm: ", typeof(cm).stringof);
	//*cm = 5; //Fehler!!!
	
	immutable v = 100;
	writeln("v: ", typeof(v).stringof);
	//v = 5; //Fehler!!!
	
	const int *cv = &v;
	writeln("cv: ", typeof(cv).stringof);
	//*cv = 10; // Fehler!!!
}