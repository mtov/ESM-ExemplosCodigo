// Repositório em memória principal, com funções de acesso a dados

function getLivroAutor(autor) {
  switch (autor) {
    case 'valente': 
      livro = 'Engenharia de Software Moderna';
      break;
    case 'fowler':
      livro = 'Refactoring';
      break;
    case 'gof':
      livro = 'Design Patterns';
      break;
    default:
      livro = "Livro não encontrado";
  }
  return livro;
}

exports.getLivroAutor = getLivroAutor;