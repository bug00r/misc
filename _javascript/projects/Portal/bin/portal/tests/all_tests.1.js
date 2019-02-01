var assert = require('assert');
var fs = require('fs');
var path = require('path');
var XML = require('xml');
var jpath = require('jsonpath-plus');

describe( 'JSON to XML tests', () => {
  describe("Basehero", () => {
    var bhero = JSON.parse(fs.readFileSync(path.join(__dirname + 
        '/../apps/dsa_toolset/data/basehero.xml.json')));
    //console.log(XML(bhero, true));
  });
  
  describe("breeds", () => {
    var breeds = JSON.parse(fs.readFileSync(path.join(__dirname + 
        '/../apps/dsa_toolset/data/basehero.xml.json')));
    //console.log(XML(breeds, true));
  });

  /*
        var herobynamepath = `$..hero[:1]._attr[?@.description === "{name}" ]`;
        var result = jpath.({json: savedheros, path: herobynamepath});
  */
 describe("jsonpath find hero", () => {
    var savedheros = JSON.parse(fs.readFileSync(path.join(__dirname + 
        '/../apps/dsa_toolset/data/saves/heros.json')));
    var herobynamepath = "$..hero..[?(@['description'] === 'Baradon')].^";
    var result = jpath({json: savedheros, path: herobynamepath});
    console.log(result);
  });
});


/*describe('Array', function() {
  describe('#indexOf()', function() {
    it('should return -1 when the value is not present', function() {
      assert.equal([1,2,3].indexOf(4), -1);
    });
  });
});*/