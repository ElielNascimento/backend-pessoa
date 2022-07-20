package br.com.backendattornatus.api.pessoa;

import java.io.Serializable;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="api/pessoas")
public class PessoaController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	private ResponseEntity<Page<PessoaModel>> listarPessoas(Pageable pageable) {
		Page<PessoaModel> response = pessoaService.listarPessoas(pageable);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	private ResponseEntity<PessoaModel> salvarPessoas(@RequestBody PessoaModel pessoaModel) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				                             .path("/{id}")
				                             .buildAndExpand(pessoaModel.getId()).toUri();
		PessoaModel response = pessoaService.salvarPessoa(pessoaModel);
		return ResponseEntity.created(uri).body(response);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<PessoaModel>> buscarPessoaPeloId(@PathVariable Long id)
			                                                               throws Exception {
		Optional<PessoaModel> response = pessoaService.buscarPessoaPeloId(id);
		return ResponseEntity.ok().body(response);
	}
	

	@PutMapping("/{id}")
	private ResponseEntity<PessoaModel> atualizarDadosPessoa(@PathVariable Long id, 
			                                                 @RequestBody PessoaModel newPessoa ){
		 PessoaModel response = pessoaService.atualizarDadosPessoa(id, newPessoa);
		 return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deletarPessoa(@PathVariable Long id){
		pessoaService.deletarPessoa(id);
		return ResponseEntity.noContent().build();
	}
	

}
