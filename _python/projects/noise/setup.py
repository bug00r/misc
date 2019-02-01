from distutils.core import setup
from distutils.extension import Extension
from Cython.Distutils import build_ext
from Cython.Build import cythonize

"""from pathlib import Path

rootpath = Path('.')
libs = []
libs.append(rootpath / 'portal_src')

ext_modules = []
for lib in libs:
	for file in lib.glob('**/*.py'):
		file_name=file.__str__()
		name = file.parts[-1].split('.')[0]
		ext_name="lib.portal_src." + ".".join(file.parts[1:-1]) + "." + name
		ext_modules.append(Extension(ext_name, [file_name], extra_compile_args=['-DMS_WIN64'],library_dirs=['.\\..\\..\\Python34']))

setup(
  name = 'Bug0rs Portal Tool',
  cmdclass = {'build_ext': build_ext},
  ext_modules = ext_modules
)
"""
ext_modules = []

ext_modules.append(Extension("noise", 
							 ["noise.pyx"], 
							 language="c",
				             extra_compile_args=['-DMS_WIN64'],
							 include_dirs=[
								'.\\..\\..\\..\\math\\vec',
								'.\\..\\..\\..\\math\\mat',
								'.\\..\\..\\..\\math\\utils',
								'.\\..\\..\\..\\math\\statistics',
								'.\\..\\..\\..\\math\\algorithm\\noise',
								'.\\..\\..\\..\\collections\\array'
							 ],
							 libraries=['noise', 'farray', 'array', 'statistics', 'utilsmath', 'mat', 'vec'],
							 library_dirs=[
								'.\\..\\..\\..\\math\\vec\\build\\gcc',
								'.\\..\\..\\..\\math\\mat\\build\\gcc',
								'.\\..\\..\\..\\math\\utils\\build\\gcc',
								'.\\..\\..\\..\\math\\statistics\\build\\gcc',
								'.\\..\\..\\..\\math\\algorithm\\noise\\build\\gcc',
								'.\\..\\..\\..\\collections\\array\\build\\gcc'
							 ]))

"""ext_modules.append(Extension("noise", 
							 ["noise.pyx", 
							 ".\\..\\..\\..\\math\\vec\\vec.c",						 
							 ".\\..\\..\\..\\math\\vec\\vec2.c", 
							 ".\\..\\..\\..\\math\\vec\\vec3.c",
							 ".\\..\\..\\..\\math\\mat\\mat.c",
							 ".\\..\\..\\..\\math\\mat\\mat2.c",
							 ".\\..\\..\\..\\math\\mat\\mat3.c",
							 ".\\..\\..\\..\\math\\mat\\mat4.c",
							 ".\\..\\..\\..\\math\\utils\\utils_math.c",
							 ".\\..\\..\\..\\math\\statistics\\statistics.c", 
							 ".\\..\\..\\..\\math\\statistics\\average.c",
							 ".\\..\\..\\..\\math\\algorithm\\noise\\noise.c", 
							 ".\\..\\..\\..\\collections\\array\\array.c", 
							 ".\\..\\..\\..\\collections\\array\\farray.c"], 
							 language="c",
				             extra_compile_args=['-DMS_WIN64', '-DMSVC'],
							 include_dirs=[
								'.\\..\\..\\..\\math\\vec',
								'.\\..\\..\\..\\math\\mat',
								'.\\..\\..\\..\\math\\utils',
								'.\\..\\..\\..\\math\\statistics',
								'.\\..\\..\\..\\math\\algorithm\\noise',
								'.\\..\\..\\..\\collections\\array'
							 ]))	
							 """
#'.\\..\\..\\..\\..\\..\\..\\Program Files (x86)\\Microsoft Visual Studio 10.0\\VC\\include',
#libraries=['color',],
#library_dirs=['.\\..\\..\\..\\color\\build\\gcc']

setup(
  name = 'Bug0rs Portal Tool',
  cmdclass = {'build_ext': build_ext},
  ext_modules = cythonize(ext_modules, compiler_directives={'language_level': 3})
)
