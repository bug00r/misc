extern crate rand;

use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
	println!("Guess the Number!");
	
	let secre_number = rand::thread_rng().gen_range(1, 101);
	println!("Secret Number is {}.", secre_number);
	
	loop {
		println!("Please insert your guess.");
		
		let mut guess = String::new();
		
		io::stdin().read_line(&mut guess).expect("Failed to read Line!!");
		
		println!("You guessed {}", guess);

		let guess:u32 = match guess.trim().parse() {
			Ok(num)	=> num,
			Err(_)	=> continue,
		};
		
		match guess.cmp(&secre_number) {
			Ordering::Less		=> println!("Too small"),
			Ordering::Greater	=> println!("Too big!"),
			Ordering::Equal		=> {
					println!("You win!!! :D");
					break;
			}
		}
	}
}
