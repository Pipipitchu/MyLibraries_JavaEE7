package tk.mylibraries.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import tk.mylibraries.dao.ClassificacaoBibliotecaDAO;
import tk.mylibraries.entities.ClassificacaoBiblioteca;
import tk.mylibraries.orm.HibernateUtil;

@ManagedBean
public class ClassificacaoBibliotecaController {

	private ClassificacaoBiblioteca classificacaoBiblioteca;
	private ClassificacaoBibliotecaDAO classificacaoBibliotecaDAO;
	private String nome;

	public ClassificacaoBibliotecaController() {
		classificacaoBibliotecaDAO = new ClassificacaoBibliotecaDAO(
				HibernateUtil.getEntityManager());
		classificacaoBiblioteca = new ClassificacaoBiblioteca();
		// arrumar daqui pra frente - para fazer CRUD completo

		if (classificacaoBibliotecaDAO.getAll().size() < 4) {
			List<ClassificacaoBiblioteca> classificacaoBibliotecas = new ArrayList<ClassificacaoBiblioteca>();
			classificacaoBiblioteca.setNome("�timo");
			classificacaoBibliotecas.add(classificacaoBiblioteca);
			classificacaoBiblioteca = new ClassificacaoBiblioteca();
			classificacaoBiblioteca.setNome("Satisfat�rio");
			classificacaoBibliotecas.add(classificacaoBiblioteca);
			classificacaoBiblioteca = new ClassificacaoBiblioteca();
			classificacaoBiblioteca.setNome("Regular");
			classificacaoBibliotecas.add(classificacaoBiblioteca);
			classificacaoBiblioteca = new ClassificacaoBiblioteca();
			classificacaoBiblioteca.setNome("P�ssimo");
			classificacaoBibliotecas.add(classificacaoBiblioteca);
			classificacaoBiblioteca = new ClassificacaoBiblioteca();

			for (ClassificacaoBiblioteca classificacaoBiblioteca : classificacaoBibliotecas) {
				classificacaoBibliotecaDAO.save(classificacaoBiblioteca);
			}
		}

	}

	public void salvar() {
		classificacaoBibliotecaDAO.save(classificacaoBiblioteca);
	}

	public List<ClassificacaoBiblioteca> getAll() {
		return classificacaoBibliotecaDAO.getAll();
	}

	public void atualizar() {
		classificacaoBibliotecaDAO.update(classificacaoBiblioteca);
	}

	public void deletar() {
		classificacaoBibliotecaDAO.delete(classificacaoBiblioteca);
	}

	public String getNome() {
		return classificacaoBiblioteca.getNome();
	}

	public void setNome(String nome) {
		classificacaoBiblioteca.setNome(nome);
	}
}
