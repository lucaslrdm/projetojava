package br.com.gama.projetofinal.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.gama.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento, Integer>{
	
	public List<Agendamento> findByAgenciaIdOrderByDataagendamentoAscHoraagendamentoAsc(int id);
	
	public List<Agendamento> findByDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(Date dataagendamento);
	
	public List<Agendamento> findByNomecliOrderByDataagendamentoAscHoraagendamentoAsc(String nomecli);
	
	public List<Agendamento> findByAgenciaIdAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(int id, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaIdAndNomecliOrderByDataagendamentoAscHoraagendamentoAsc(int id, String nomecli);
	
	public List<Agendamento> findByNomecliAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(String nomecli, Date dataagendamento);
	
	public List<Agendamento> findByAgenciaIdAndNomecliAndDataagendamentoOrderByDataagendamentoAscHoraagendamentoAsc(int id, String nomecli,Date dataagendamento);
	
	public List<Agendamento> findByHoraagendamentoAndDataagendamentoAndAgenciaId(String horaagendamento,Date dataagendamento,int id);
	
	public List<Agendamento> findAllByOrderByDataagendamentoAscHoraagendamentoAsc();

}
