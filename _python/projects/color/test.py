import color

print("start color test")
print(color.make_color(1.5, 2.5, 4.5))

col = color.create_color(1.5, 2.5, 4.5)
print(col["r"])
color.free_color(col)

col_py = color.make_color_py(6.6, 5.5, 4.5)
col_py.print_color()
col_py.add(12.12)
col_py.print_color()
color.add_more(col_py, 666.666)
col_py.print_color()

fact = color.Py_col_factory()
fact.add_alot(col_py.ccol())