package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
