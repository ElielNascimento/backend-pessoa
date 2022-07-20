package br.com.backendattornatus.api.pessoaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.backendattornatus.api.pessoa.PessoaModel;
import br.com.backendattornatus.api.pessoa.PessoaRepository;
import br.com.backendattornatus.api.pessoa.PessoaService;

@SpringBootTest
public class PessoaServiceTest {

	private static final long ID = 1L;

	private static final String EMAIL = "eliel_bn@gmail.com";

	private static final String CPF = "47303955909";

	private static final String NOME = "Eliel";

	@InjectMocks
	private PessoaService pessoaService;

	@Mock
	private PessoaRepository pessoaRepository;

	@Mock
	private Pageable pageable;

	@Mock
	private PessoaModel pessoaModel;

	private Optional<PessoaModel> optionalPessoa;

	@Test
	void listarTodasPessoasComSucesso() {

	}

	@Test
	void adicionarPessoasComSucesso() {

	}

	@Test
	void deletarPessoasComSucesso() {

	}

	@Test
	void atualizarPessoasComSucesso() {

	}

	@Test
	void buscarPessoasComSucessoPeloId() {

	}

	void startProduto() {
		pessoaModel = new PessoaModel(ID, NOME, CPF, EMAIL, LocalDate.now());
		optionalPessoa = Optional.of(new PessoaModel(1l, NOME, CPF, EMAIL, LocalDate.now()));
	}

}