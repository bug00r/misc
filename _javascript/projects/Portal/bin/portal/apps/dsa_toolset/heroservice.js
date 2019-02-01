const path = require('path');
const fs = require('fs');
const jpath = require('jsonpath-plus');

module.exports = new (function () {
    const savedheropath = fs.readFileSync(path.join(__dirname + '/data/saves/heros.json'));
    
    var savedheros = JSON.parse(savedheropath);

    this.getSavedHeros = function() {
        return savedheros;
    }

    function heroExist(name) {
        var herobynamepath = `$..hero[:1]._attr[?@.description === "{name}" ]`;
        var result = jpath({json: savedheros, path: herobynamepath});
        return !!name;
    }

    this.addHero = function(name) {
        var newhero = null;
        if (!heroExist(name)) {
            newhero = JSON.parse(fs.readFileSync(path.join(__dirname + '/data/basehero.json')));
            newhero.hero[0]._attr.description = 'newname';
            savedheros.heros.push(newhero);
            fs.writeFileSync(savedheropath, savedheros, 'utf8');
        }
        return newhero;
    }

})(); 