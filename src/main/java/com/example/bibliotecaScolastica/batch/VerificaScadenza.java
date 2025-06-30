package com.example.bibliotecaScolastica.batch;

import com.example.bibliotecaScolastica.model.Prestito;
import com.example.bibliotecaScolastica.repository.PrestitoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class VerificaScadenza {

    @Autowired
    private PrestitoRepository prestitoRepository;

    @Autowired
    private JavaMailSender mailSender;

    // Metodo eseguito ogni giorno alle 11:00
    @Scheduled(cron = "0 25 14 * * *") 
    @Transactional
    public void inviaNotifichePrestitiScaduti() {
        List<Prestito> prestitiScaduti = prestitoRepository.findPrestitiScadutiNonRestituiti();

        for (Prestito p : prestitiScaduti) {
            String email = p.getUtente().getEmail(); // Assumiamo: `Prestito` ha `@ManyToOne private Utente utente`
            if (email != null && !email.isBlank()) {
                inviaEmail(email, p);
            }
        }
    }

    private void inviaEmail(String destinatario, Prestito prestito) {
        SimpleMailMessage messaggio = new SimpleMailMessage();
        messaggio.setTo(destinatario);
        messaggio.setSubject("Restituzione libro scaduta");
        messaggio.setText("Gentile utente,\n\nIl termine per la restituzione del libro ID " + prestito.getIdLibro() +
                " è scaduto il " + ((Timestamp) prestito.getDataFine()).toLocalDateTime() +
                ". Ti preghiamo di restituirlo il prima possibile.\n\nGrazie!");

        mailSender.send(messaggio);
    }
}
