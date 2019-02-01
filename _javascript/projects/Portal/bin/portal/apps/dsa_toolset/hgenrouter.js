const express = require('express');
const path = require('path');
const fs = require('fs');

const heroservice = require('./heroservice');

var hgen = express();

hgen.get('/savedheros', (req, res) => {
    res.send(heroservice.getSavedHeros());
});

hgen.post('/hero/add', (req, res) => {

    res.send(newhero);
});

module.exports = hgen;