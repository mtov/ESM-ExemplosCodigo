// Código de domínio (regras de negócio)
// Totalmente independente de tecnologia

var repositorio = null;

function configuraRepo(repo) {
  repositorio = repo; 
}

function pesquisarAutor(autor) {
  return repositorio.getLivroAutor(autor);
}

exports.pesquisarAutor = pesquisarAutor;
exports.configuraRepo = configuraRepo;