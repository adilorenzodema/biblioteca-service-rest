package com.example.bibliotecaScolastica.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.bibliotecaScolastica.model.UtenteDTO;
import com.example.bibliotecaScolastica.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{	
	private final UtenteRepository utenteRepository;
	private final JavaMailSender mailSender;
    public UtenteServiceImpl(UtenteRepository utenteRepository,JavaMailSender mailSender) {
        this.utenteRepository = utenteRepository;
        this.mailSender=mailSender;
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
			 try {
			        LocalDateTime now = LocalDateTime.now();
			        Timestamp timestamp = Timestamp.valueOf(now);

			        int codiceVerifica = new Random().nextInt(900000) + 100000;
			        utenteDTO.setCodiceVerifica(codiceVerifica);

			        utenteRepository.addUtente(
			            utenteDTO.getNome(),
			            utenteDTO.getCognome(),
			            utenteDTO.getCodiceFiscale(),
			            utenteDTO.getClasse(),
			            utenteDTO.getEmail(),
			            timestamp,
			            null,
			            utenteDTO.getUsername(),
			            utenteDTO.getPassword(),
			            false,
			            utenteDTO.getIdRuolo(),
			            codiceVerifica
			        );

			        emailVerifica(utenteDTO.getEmail(), utenteDTO.getUsername(), codiceVerifica);
			    } catch (Exception e) {
			        e.printStackTrace(); // oppure usa un logger
			        throw new RuntimeException("Errore durante l'aggiunta dell'utente: " + e.getMessage());
			    }
		
		}
		
		private void emailVerifica(String email, String username, int codice) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Conferma la tua registrazione");
	        message.setText("Clicca sul link per verificare il tuo account: "
	            + "https://biblioteca-scolastica.onrender.com/verifica-codice/verifica-codice.html?username=" + username
	            + "\nCodice di verifica: " + codice);
	        
	        mailSender.send(message);
	    }

	    // Metodo per attivare l'utente
	    public boolean attivaUtente(String username, int codice) {
	        return utenteRepository.attivaUtente(username, codice) > 0;
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
