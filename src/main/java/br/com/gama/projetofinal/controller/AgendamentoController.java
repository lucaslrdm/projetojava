package br.com.gama.projetofinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.projetofinal.dao.AgendamentoDAO;
import br.com.gama.projetofinal.model.Agencia;
import br.com.gama.projetofinal.model.Agendamento;

@RestController
@CrossOrigin("*")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoDAO dao;
	
	@PostMapping("/relatorioporagencia")
	public ResponseEntity<List<Agendamento>> getAgendamentoAgencia(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByAgenciaIdOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getAgencia().getId());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/relatoriopordata")
	public ResponseEntity<List<Agendamento>> getAgendamentoData(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getDataagendamento());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/relatorioporcliente")
	public ResponseEntity<List<Agendamento>> getAgendamentoCliente(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByNomecliOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getNomecli());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/relatorioporagenciadata")
	public ResponseEntity<List<Agendamento>> getAgendamentoAgenciaData(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByAgenciaIdAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getAgencia().getId(),objeto.getDataagendamento());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/relatorioporagenciacliente")
	public ResponseEntity<List<Agendamento>> getAgendamentoAgenciaCliente(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByAgenciaIdAndNomecliOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getAgencia().getId(),objeto.getNomecli());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/relatorioporclientedata")
	public ResponseEntity<List<Agendamento>> getAgendamentoClienteData(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByNomecliAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getNomecli(),objeto.getDataagendamento());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/relatorioporagenciaclientedata")
	public ResponseEntity<List<Agendamento>> getAgendamentoAgenciaClienteData(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByAgenciaIdAndNomecliAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(objeto.getAgencia().getId(),objeto.getNomecli(),objeto.getDataagendamento());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/validaagendamento")
	public ResponseEntity<List<Agendamento>> getHoraAgendamento(@RequestBody Agendamento objeto){
		List<Agendamento> lista = dao.findByHoraagendamentoAndDataagendamentoAndAgenciaId(objeto.getHoraagendamento(), objeto.getDataagendamento(), objeto.getAgencia().getId());
		if(lista.size()>2) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	@PostMapping("/novoagendamento")
	public ResponseEntity<Agendamento> gravar(@RequestBody Agendamento objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	@GetMapping("/agendamentos")
	public ResponseEntity<List<Agendamento>> getAll(){
		List<Agendamento> lista = (List<Agendamento>) dao.findAllByOrderByDataagendamentoAscHoraagendamentoAsc();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/clientes")
	public ResponseEntity<List<Agendamento>> getAllClientes(){
		List<Agendamento> lista = (List<Agendamento>) dao.findAll();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}


}
