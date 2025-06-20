package com.example.bibliotecaScolastica.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{	
	private final UtenteRepository utenteRepository;

    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }
	//API estrazione tutti gli utenti presenti
	@Override
	public List<UtenteDTO> getAllUtenti(String nomeRuolo) {
		return utenteRepository.findAllUtenti(nomeRuolo);
	}
	
	//API rimozione utente
	@Override
	public void deleteUtente(Long idUtente) {
	    try {
	        utenteRepository.deleteUtente(idUtente);
	    } catch (Exception e) {
	        throw new IllegalStateException("Impossibile cancellare l'utente: si è verificato un errore.");
	    }
	}
	
	//API aggiunta utente
		@Override
		public void addUtente(UtenteDTO utenteDTO) {
			 LocalDateTime now = LocalDateTime.now();
			 Timestamp timestamp = Timestamp.valueOf(now);
			 utenteRepository.addUtente(utenteDTO.getNome(),utenteDTO.getCognome(),utenteDTO.getCodiceFiscale(),utenteDTO.getClasse(),timestamp,null,utenteDTO.getUsername(),utenteDTO.getPassword(),true,utenteDTO.getIdRuolo());
		}

	//API modificaUtente 
		@Override
		public void modificaUtente(UtenteDTO utenteDTO) {
		    Timestamp dataModifica = Timestamp.valueOf(LocalDateTime.now());
		    utenteRepository.modificaUtente(
		        utenteDTO.getIdUtente().longValue(),
		        utenteDTO.getNome(),
		        utenteDTO.getCognome(),
		        utenteDTO.getCodiceFiscale(),
		        utenteDTO.getClasse(),
		        dataModifica,
		        utenteDTO.getPassword()
		    );
		}

		
}
