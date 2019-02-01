const express = require('express');
const path = require('path');
const fs = require('fs');

var dsatoolset = express();

function start(req, res) {
    res.sendFile(path.join(__dirname + '/pub/html/dsa_toolset.html'));
}

dsatoolset.get('/', start);
dsatoolset.use(express.static(path.join(__dirname, 'pub')));

var features = JSON.parse(fs.readFileSync(path.join(__dirname + '/data/features.json')));

dsatoolset.get('/features', (req, res) => {
    res.send(features.features);
});

var hgen = require('./hgenrouter');

dsatoolset.use('/hgen',hgen);

module.exports = dsatoolset;