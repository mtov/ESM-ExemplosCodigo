// Arquivo principal

const web = require('./adaptadorWeb.js');
const repo = require('./RepositorioMemoria.js');
const dominio = require('./dominio.js');

dominio.configuraRepo(repo);
web.start();