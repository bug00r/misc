import std.stdio;

extern (C) {
	ubyte * noise_texture_ds(int width, int height, float maxred, float red, float startseed, float function(float,float,float,float) middlefunc);
	float function(float,float,float,float) noise_texture_ds_middlefunc();
}

void main()
{
	writeln("Edit source/app.d to start your project.");
	ubyte * result = noise_texture_ds(513, 513, 1.0, 0.5, 1.0, noise_texture_ds_middlefunc());
}
