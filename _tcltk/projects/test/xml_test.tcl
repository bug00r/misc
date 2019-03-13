 package require dom
 package require Tcldot

 set sample {
     <graph>
     <node id="1" label="H" />
     <node id="2" label="a" />
     <node id="3" label="m" />
     <node id="4" label="r" />
     <node id="5" label="n" />
     <node id="6" label="b" />
     <node id="7" label="u" />
     <node id="8" label="r" />
     <node id="9" label="g" />
     <edge from="1" to="2" best="1" />
     <edge from="2" to="3" best="1" />
     <edge from="3" to="6" best="1" />
     <edge from="6" to="7" best="1" />
     <edge from="7" to="8" best="1" />
     <edge from="8" to="9" best="1" />
     <edge from="2" to="4" />
     <edge from="4" to="5" />
     <edge from="5" to="6" />
     </graph>
 }
 set c [canvas .c]
 pack $c -fill both -expand 1

 set g [dotnew digraph rankdir LR]
 $g setnodeattribute style filled color white shape box

 #------------------- parser callback for element start:
 proc start {name atts} {
    global g ;# graph
    array set a [concat {best 0} $atts]
    switch -- $name {
        node {
            set ::n$a(id) [$g addnode $a(id) label ($a(id))\n$a(label)]
        }
        edge {
            set cmd [list [set ::n$a(from)] addedge [set ::n$a(to)]]
            if $a(best) {lappend cmd style bold}
            eval $cmd
        }
    }
 }
 set parser [expat -elementstartcommand start]
 $parser parse $sample

 $g layout        ;# determine suitable x/y coordinates for canvas items
 eval [$g render] ;# put them on the canvas named $c