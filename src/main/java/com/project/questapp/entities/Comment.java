package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Post post;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    User user;



    // ÖNEMLİ AÇIKLAMA BURADA LOB VE COLUMN ANNOTATİONSLARINI KALDIRDIK ÇÜNKÜ ONLARI VERİNCE "texts" değişkenimizi string değilde,
    // text tipinde algılatıyoruz ama neden kaynaklı bilmiyorum text tipindeki verileri veritabanında sayı şekilde tutuyordu
    // bende "texts" değişkenimizi bu şekilde tanımladım. artık text tipinde değil de varchar şeklinde tanımlı eğer sorun çıkarsa
    // bu comment satırına aldığın 2 annotation'u aç ve TÜM TABLE'LARI SİL VE TEKRAR RUN ET yoksa tablolar dönüşürken
    // sorun olabiliyormuş.

    //@Lob
    //@Column(columnDefinition = "text")
    String texts;



    @Temporal(TemporalType.TIMESTAMP)
    Date createDate;







}
