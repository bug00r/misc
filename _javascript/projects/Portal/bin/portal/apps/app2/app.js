const express = require('express');
const path = require('path');

var app2 = express();

function test(req, res) {
    res.sendFile(path.join(__dirname + '/pub/html/app2.html'));
}

app2.get('/', test);
app2.use(express.static(path.join(__dirname, 'pub')));

module.exports = app2;