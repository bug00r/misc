fn main() {
    let bytes = include_bytes!("text.in");
    print!("{}", String::from_utf8_lossy(bytes));
}
