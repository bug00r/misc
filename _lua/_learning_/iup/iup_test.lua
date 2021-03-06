-- plot1.lua
require( "iuplua" )
require( "iupluacontrols" )
require( "iuplua_plot"  )

plot = iup.plot{TITLE = "A simple XY Plot",
                    MARGINBOTTOM="35",
                    MARGINLEFT="35",
                    AXS_XLABEL="X",
                    AXS_YLABEL="Y"
                    }

iup.PlotBegin(plot,0)
iup.PlotAdd(plot,0,0)
iup.PlotAdd(plot,5,5)
iup.PlotAdd(plot,10,7)
iup.PlotEnd(plot)

dlg = iup.dialog{plot; title="Plot Example",size="QUARTERxQUARTER"}

dlg:show()

iup.MainLoop()