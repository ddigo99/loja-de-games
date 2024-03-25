package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Categoria;
import model.Produto;
import repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listarTodosProdutos() {
		return produtoRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/{idProduto}/categorias")
	public List<Categoria> listarCategoriasPorProduto(@PathVariable Long idProduto) {
		Produto produto = produtoRepository.findById(idProduto).orElse(null);
		if (produto != null) {
			return (List<Categoria>) produto.getCategoria();
		}
		return null;
	}

	@PostMapping
	public Produto criarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@GetMapping("/{id}")
	public Produto buscarProdutoPorId(@PathVariable Long id) {
		return produtoRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {

		if (produtoRepository.existsById(id)) {
			produto.setId(id);
			return produtoRepository.save(produto);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
}
