#
# The example of the previous lesson revisited - to get a
# more general "database"
#

proc addname {db first last} {
    upvar $db name

    # Create a new ID (stored in the name array too for easy access)

    incr name(ID)
    set id $name(ID)

    set name($id,first) $first   ;# The index is simply a string!
    set name($id,last)  $last    ;# So we can use both fixed and
                                 ;# varying parts
}

proc report {db} {
    upvar $db name

    # Loop over the last names: make a map from last name to ID

    foreach n [array names name "*,last"] {
        #
        # Split the name to get the ID - the first part of the name!
        #
        regexp {^[^,]+} $n id

        #
        # Store in a temporary array:
        # an "inverse" map of last name to ID)
        #
        set last       $name($n)
        set tmp($last) $id
    }

    #
    # Now we can easily print the names in the order we want!
    #
    foreach last [lsort [array names tmp]] {
        set id $tmp($last)
        puts "   $name($id,first) $name($id,last)"
    }
}

#
# Initialise the array and add a few names
#
set fictional_name(ID) 0
set historical_name(ID) 0

addname fictional_name Mary Poppins
addname fictional_name Uriah Heep
addname fictional_name Frodo Baggins

addname historical_name Rene Descartes
addname historical_name Richard Lionheart
addname historical_name Leonardo "da Vinci"
addname historical_name Charles Baudelaire
addname historical_name Julius Caesar

#
# Some simple reporting
#
puts "Fictional characters:"
report fictional_name
puts "Historical characters:"
report historical_name