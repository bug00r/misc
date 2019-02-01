import noise
from PIL import Image
#import numpy as np

def run_test():
	print("start noise test")
	result = noise.make_noise()
	px = []
	for col in result:
		px.append((int(col), int(col), int(col)))
	#im = Image.fromarray(np.asarray(px), mode='RGB')
	im = Image.new('RGB',(513, 513))
	im.putdata(px)
	#im.save("noise.bmp")
	im.show(im)

run_test()
#run_test()
#run_test()