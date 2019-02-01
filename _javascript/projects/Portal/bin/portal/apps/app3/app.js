const express = require('express');
const path = require('path');

var app3 = express();

function test(req, res) {
    res.sendFile(path.join(__dirname + '/pub/html/app3.html'));
}

app3.get('/', test);
app3.use(express.static(path.join(__dirname, 'pub')));

module.exports = app3;