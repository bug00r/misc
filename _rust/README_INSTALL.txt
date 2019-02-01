Follow this to install portable Rust Version:

1. install Msys2 => msys2.org if not happen
2. GOTO Rust Installer Directory => 	cd /c/dev/testplace/repo/_rust/rust-1.23.0-x86_64-pc-windows-gnu/
3. INSTALL Rust via script	 =>	./install.sh --destdir=../rust --prefix=""
4. SETUP ENV VARS:
	1. add to PATH rust/bin
	2. set CARGO_HOME => to given cargo_home cache dir
	There are some other may be useful var, read the doc if you need: https://doc.rust-lang.org/cargo/reference/environment-variables.html
