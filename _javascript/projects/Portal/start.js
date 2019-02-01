const express = require('express');
const portalapp = require('./bin/portal/app');
const path = require('path');

const app = express();

app.use(express.static(path.join(__dirname, 'pub')));

app.use('/portal', portalapp);

app.listen(3000, () => console.log('Example app listening on port 3000!'));