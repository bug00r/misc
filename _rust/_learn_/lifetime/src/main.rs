#![allow(unused_variables)]
fn main() {
    //fn skip_prefix(line: &str, prefix: &str) -> &str {  
	fn skip_prefix<'a, 'b>(line: &'a str, prefix: &'b str) -> &'a str {
		//...
		line
	}
	
	let line = "lang:en=Hello World!";
	let lang = "en";
	
	let v;
	{
		let p = format!("lang:{}=", lang);
		v = skip_prefix(line, p.as_str());
	}
	println!("{}", v);
}
