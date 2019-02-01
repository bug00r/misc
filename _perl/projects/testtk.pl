#!perl
use strict;
use warnings;
use Tk;
# An example of canvases, items, and dragging things around
my $mw = tkinit();
my $c = $mw->Canvas(
	-width => 250,
	-height => 100,
);
my $myoval = $c->createOval(0, 0, 50, 50, -fill => 'orange');
my $myline = $c->createLine(50, 50, 100, 100, -fill => 'blue', -width => 4);
$c->bind($myoval, '<B1-Motion>', sub{ moveit($myoval); });
$c->bind($myline, '<B1-Motion>', sub{ moveit($myline); });
$c->grid(-row => 0, -column => 0);
$mw->MainLoop;
sub moveit {
	my $object = shift;
	my ( $x, $y ) = ( $Tk::event->x, $Tk::event->y );
	$c->coords($object, $x - 25, $y - 25, $x + 25, $y + 25);
} # /moveit