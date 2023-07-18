package com.example.brevoemailsender.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    @Scheduled(fixedRate = 600000)
    public void mailSender() throws MessagingException, IOException {
        sendEmail();
       // sendEmailWithAttachment();
        log.info("Email sent successfully!");
    }

    void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("receb.rasulov@hotmail.com");
        msg.setFrom("receb.rasulov@gmail.com");
        msg.setSubject("Emkedasliq");
        msg.setText("Hörmətli sahibkar,\n" +
                "         Müraciət etməkdə məqsədimiz, \"Schlumberger\" şirkəti ilə şirkətimiz  arasında əməkdaşlığın və qarşılıqlı səmərəli işgüzar əlaqələrin qurulmasını, inkişaf etdirməsini və rəhbəri olduğunuz müəssisənin bütün gömrükləmə və logistika işlərinin “My Broker” şirkətinə tam əminliklə həvalə edə biləcəyinizi Sizə bildirməkdir.\n" +
                "Müasir dünya təcrübəsi əsasında yaradılan və şəffaflıq, operativlik,  nəzakətlilik prinsipləri ilə fəaliyyət göstərən “My Broker” gömrük təmsilçiliyi gömrükdən istifadə edən iş adamlarının rahatlığına xidmət etməkdədir. Artıq gömrük məntəqələrinə getməyə ehtiyyac yoxdur.  My Broker şirkətinə müraciət etməklə vaxtınıza və pulunuza qənaət edərək dünyanın istənilən ölkəsindən istənilən daşınma şərti ilə sifariş etdiyiniz yükü bizim vasitəmizlə rahat bir şəkildə ünvanınızda  təhvil ala bilərsiniz.  \n" +
                "Fəaliyyət müddətimizdə Aba logistik, ASE (Asia Sky Express), Pegas Transport LTD, Cargo Lux, Panalpina, Deniz Servis, Bakı Mexanika və Elektronik, ATEF group, Baku Steel Company, NurGün Group, “Ultra Technologies” MMC və s. kimi və s. kimi 200-dən çox yerli şirkətlərə, həmçinin Rusiya, Türkiyə, Almaniyaya, Holladiya və.s avropa ölkələrindəki beynəlxalq şirkətlərə gömrük təmsilçiliyi xidmətləri göstərirməkdədir və təqdim etdiyimiz xidmətlər ilə müştəri məmnuniyyəti əldə etmişik. \n" +
                "          \n" +
                "         \n" +""
                  );
        javaMailSender.send(msg);
    }

    void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("receb.rasulov@hotmail.com");
        helper.setFrom("receb.rasulov@gmail.com");
        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("my_photo.png", new ClassPathResource("foto.png"));

        javaMailSender.send(msg);
    }
}

