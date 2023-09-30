package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int ano;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany
    @JoinTable(
            name = "livro_autor",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();

    // Construtores, getters, setters e outros métodos, se necessário

    public Livro() {
        // Construtor padrão
    }

    public Livro(String titulo, int ano, String isbn, Categoria categoria, Editora editora, List<Autor> autores) {
        this.titulo = titulo;
        this.ano = ano;
        this.isbn = isbn;
        this.categoria = categoria;
        this.editora = editora;
        this.autores = autores;
    }

	public String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAno() {
		// TODO Auto-generated method stub
		return null;
	}

	public Categoria getEditora() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIsbn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Categoria getCategoria() {
		// TODO Auto-generated method stub
		return null;
	}

    // Outros métodos, se necessário
}
