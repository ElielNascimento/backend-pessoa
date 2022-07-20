package br.com.backendattornatus.api.pessoa;

import java.io.Serializable;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PessoaRepository PessoaRepository;

    @Transactional(readOnly = true)
	public Page<PessoaModel> listarPessoas(Pageable pageable) {
		Page<PessoaModel> response = PessoaRepository.findAll(pageable);
		return response;
	}

    @Transactional
	public PessoaModel salvarPessoa(PessoaModel PessoaModel) {
		return PessoaRepository.save(PessoaModel);
	}

    @Transactional(readOnly = true)
	public Optional<PessoaModel> buscarPessoaPeloId(Long id) throws Exception {
		Optional<PessoaModel> Pessoa = PessoaRepository.findById(id);

		if (Pessoa.isPresent()) {
			return Pessoa;
		} else {
			throw new Exception("Você esta tentando buscar uma Pessoa que não existe");
		}
	}

    @Transactional
	public PessoaModel atualizarDadosPessoa(Long id, PessoaModel newPessoa) {
		PessoaModel pessoa = PessoaRepository.findById(id).get();
		pessoa.setNome(newPessoa.getNome());
		pessoa.setEmail(newPessoa.getEmail());

		pessoa = PessoaRepository.save(pessoa);
		return pessoa;
	}

    @Transactional
	public void deletarPessoa(Long id) {
		PessoaRepository.deleteById(id);
	}

}