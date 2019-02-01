from pathlib import Path
from lxml import etree
from io import StringIO, BytesIO
import argparse
import json
import types
import string

argparser = argparse.ArgumentParser(description='parse xml into json files')

argparser.add_argument('-f', '--xmlfiles', nargs="*", help='file list space separated')

args = argparser.parse_args()

class DefaultJsonEncoder(json.JSONEncoder):
    def default(self, obj):
        ttype = None
        if isinstance(obj, argparse._ArgumentGroup):
            ttype = obj.__str__()
        if isinstance(obj, int):
            ttype = "%i" % obj
        if isinstance(obj, types.FunctionType):
            ttype = "func"

        try:
            print(type(obj))
            ttype = json.JSONEncoder.default(self, obj)
        except:
            ttype = "unknown"
        return ttype

def elementtojson(element):
    subresult = {}
    subresult[element.tag] = []
    if len(element.attrib) > 0:
        attributes = {'_attr': dict(element.attrib)}
        subresult[element.tag].append(attributes)
    if element.text is not None:
        strippedtext = element.text.strip(string.whitespace)
        if len(strippedtext) > 0:
            subresult[element.tag].append(element.text.strip(string.whitespace))
    for child in element.getchildren():
            subresult[element.tag].append(elementtojson(child))
    return subresult



for file in args.xmlfiles:
    with open(file, encoding="utf-8") as _file:
        xml = _file.read()
        fb = BytesIO(xml.encode())
        parser = etree.XMLParser(remove_comments=True)
        doc = etree.parse(fb, parser=parser)
        
        root = doc.getroot()
        result = elementtojson(root)

        with open(file + ".json", mode="w",encoding="utf-8") as _file:
            _file.write(json.dumps(result))
        print("done writing: " + file + ".json")
