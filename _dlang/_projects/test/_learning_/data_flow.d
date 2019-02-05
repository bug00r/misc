//dataflow
import std.stdio;

void main()
{
	if ( 1 == 1 ) 
		writeln("Arithmetic works on D!!");
		
	int c = 5;
	
	switch(c)
	{
		case 0: .. case 9:
			writeln(c, " ist zwischen 0-9");
			break;
		case 10:
			writeln("Eine Zehn");
			break;
		default:
			writeln("nichts");
			break;
	}
}
