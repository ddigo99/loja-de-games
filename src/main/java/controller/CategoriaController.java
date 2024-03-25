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
import repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public List<Categoria> listarTodasCategorias() {
		return categoriaRepository.findAll();
	}

	@GetMapping("/por-produto/{produtoId}")
	public Categoria consultarCategoriaPorProduto(@PathVariable Long produtoId) {
		return null;
	}

	@PostMapping
	public Categoria criarCategoria(@RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@GetMapping("/{id}")
	public Categoria buscarCategoriaPorId(@PathVariable Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
		if (categoriaRepository.existsById(id)) {
			categoria.setId(id);
			return categoriaRepository.save(categoria);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deletarCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}

}
