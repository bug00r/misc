const express = require('express');
const path = require('path');
const fs = require('fs')

var portalapp = express();

portalapp.get('/', (req, res) => {
    res.sendFile(path.join(__dirname + '/pub/html/portal.html'));
});

portalapp.use(express.static(path.join(__dirname, 'pub')));

var config = JSON.parse(fs.readFileSync(path.join(__dirname + '/data/config.json')));

config.applications.value.forEach(app => {
    console.log(`found app: ${app.name}`);
    var curapp = require(`./${config.applications.root}/${app.path}/app`);
    portalapp.use(`/${app.path}`,curapp);
});

portalapp.get('/apps', (req, res) => {
    res.send(config.applications.value);
});

module.exports = portalapp;