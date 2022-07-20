package br.com.backendattornatus.api.endereco;

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
@RequestMapping(value="api/enderecos")
public class EnderecoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping
	private ResponseEntity<Page<EnderecoModel>> listarEnderecos(Pageable pageable) {
		Page<EnderecoModel> response = enderecoService.listarEnderecos(pageable);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	private ResponseEntity<EnderecoModel> salvarenderecos(@RequestBody EnderecoModel enderecoModel) throws Exception {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				                             .path("/{id}")
				                             .buildAndExpand(enderecoModel.getId()).toUri();
		EnderecoModel response = enderecoService.salvarEndereco(enderecoModel);
		return ResponseEntity.created(uri).body(response);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Optional<EnderecoModel>> buscarenderecoPeloId(@PathVariable Long id)
			                                                               throws Exception {
		Optional<EnderecoModel> response = enderecoService.buscarEnderecoPeloId(id);
		return ResponseEntity.ok().body(response);
	}
	

	@PutMapping("/{id}")
	private ResponseEntity<EnderecoModel> atualizarDadosendereco(@PathVariable Long id, 
			                                                 @RequestBody EnderecoModel newendereco ){
		 EnderecoModel response = enderecoService.atualizarEndereco(id, newendereco);
		 return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> deletarEndereco(@PathVariable Long id){
		enderecoService.deletarEndereco(id);
		return ResponseEntity.noContent().build();
	}
	

}
