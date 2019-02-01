#!perl
use strict;
use warnings;
use Tk;
use Tk::Text;
my $mw = tkinit;
my $text = $mw->Scrolled('Text',
	-width => 40,
	-height => 10,
	-wrap => 'word',
)->pack(-expand => 1, -fill => 'both',);
# Set up the tags
$text->tagConfigure('bold_italics', 
	-font => [
		-family => 'courier', 
		-size => 12, 
		-weight => 'bold', 
		-slant => 'italic'
	],
);
$text->tagConfigure('big' => -font => [-family => 'helvetica', -size => 24, -weight => 'bold']);
$text->tagConfigure('color1' => -foreground => 'red');
$text->tagConfigure('sunken' => -relief => 'sunken', -borderwidth => 1);
$text->tagBind('Ouch', '<1>', sub{ $text->insert('end', "Ouch! "); });
# Now insert text that has the property of the tags
$text->insert('end', "Here are a few text styles\n");
$text->insert('end', "1. Bold italic text.\n", 'bold_italics');
$text->insert('end', "2. Larger Helvetica  text.\n", 'big');
$text->insert('end', "3. Red text.\n", 'color1');
$text->insert('end', "4. Sunken text.\n", 'sunken');
my $btn = $text->Button(
	-text    => "5. An embedded Hello Button",
	-command => sub{ $text->insert('end', "Hello "); },
);
$text->windowCreate('end', -window => $btn);
$text->insert('end', "\n");
$text->insert('end', "6. Text with a binding (try clicking me)", 'Ouch');
$text->insert('end', "\nAnd all this is editable!");
$mw->MainLoop;