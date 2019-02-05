import std.stdio;
import std.algorithm;
import std.range;

void main()
{
	writeln("Hallo Welt!!");
	
	int[] arr1 = [1, 2, 3];
	int[] arr2 = [5, 2, 1,9, 10];
	int[] arr3 = [6, 8, 3];
	
	sort(chain(arr1, arr2, arr3));
	writefln("%s\n%s\n%s\n", arr1, arr2,arr3);
}