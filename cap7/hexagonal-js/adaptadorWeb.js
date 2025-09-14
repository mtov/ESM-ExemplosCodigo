// API de acesso ao sistema, no caso via HTTP/REST

const dominio = require('./dominio.js');
const express = require('express');
const app = express();

function start() {
  app.use(express.static('public'));
  
  app.get('/', (req, res) => {
    res.render('index.html');
  });
  
  app.get('/pesquisa', (req, res) => {
    livro = dominio.pesquisarAutor(req.query.autor);
    res.send(livro)
  });
  
  app.listen(3000, '0.0.0.0', () => {
    console.log('Servidor rodando na porta 3000')
  });
}

exports.start = start;
