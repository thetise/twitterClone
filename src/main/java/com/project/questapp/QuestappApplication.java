package com.project.questapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestappApplication.class, args);
	}


	// ŞU ANA KADAR GELİNEN TÜM NOKTALAR KONTROL EDİLDİ USERCONTROLLER, USERSERVİCE
	// CRUD YAPILARININ HEPSİ ÇALIŞIYOR POSTMAN VE POSTGRESQL İLE DENENDİ GÖRÜLDÜ
	// ENTİTY YAPILARINA EKLENMESİ GEREKEN ŞEYLER OLABİLİR BU YAPI İLERKİ VİDEOLARDA GÜNCELLENEBİLİR. (ENTİTY ŞİMDİLİK ÇALIŞIYOR)
	//----------------------------------------------------------------------------------
	// 3. videoyu tamamen biitirdik orada önemli @Transactional annotations'u vardı onu hallettik falan.
	// USER VE POST ENTİTY'LERİ İÇİN TÜM CRUD İŞLEMLERİ TAMAMLANMIŞTIR TEYİT ETTİM HEPSİNİ KONTROL ETTİM.

	// 4. VİDEO TAMAMEN HALLEDİLDİ. SADECE LİKE YAPISININ CONTROLLER VE SERVİCE KISMI KALDI.
	// BU ÇALIŞMADA İSE COMMENT YAPISINI OLUŞTURDUM VE TÜM CRUD İŞLEMLERİNİ DENEDİM, ÇALIŞTIRDIM ONAYLADIM.
	// ek olarak front kısmında ekrana postları yazdırdık bunu gördük front kısmı bu kadardı çalıştırdım baktım çalışıyor
	// VİDEO 4 E KADAR HERŞEY HALLEDİLDİ.
	// ŞU ANA KADAR SIKINTI KALMADI SADECE LİKE YAPISI YAPILACAK HOCA ORAYI BİZE BIRAKTI.

	// 5. video tamamen halledildi tüm denemeler yapıldı herşey çalışıyor.

	// 6. video bitti home sayfasının front işlemleri yapıldı.

	// 7. video bitti ama like atmada sorunlar var YAPILMADAN GEÇİLEN 2. İŞLEM OLDU BU DİĞERİ TEXTLERİN
	// GÖZÜKMEMESİYDİ.
	// 7. video 1. SAAT BİTTİ 1:03 DE KALDIK TAM SON 7 DK İZLEYİP 8 E GEÇİCEM.
	// BURADA ÇOK BÜYÜK BİR HATA VAR COMMENTLERE LİKE ATMA VE LİKE GERİ ÇEKME İŞLEMİ ÇALIŞMIYOR DENENDİ BAZI ŞEYLER
	// TRANSACTİONAL FALAN DENENDİ ACABA SORUN BURADAN DA ÖNCE Mİ OLUŞUYOR ONA BİR BAK.



	//---------------------------------------------------------------------------------------------------------------
	// 9. videoda en sonda register ve login kısmı var "Auth" ve "App" kısmında route yapılarında mı sorun vardır
	// artık nerde sorun var bilmiyorum hata şu şekilde karşımıza çıkıyor.bazen direkt register etme tuşuna basınca bazen direkt
	// kayıt edip içeri alıyor bu da userId'yi null dönmesine sebep oluyor ve db ye kaydediyor. bazende birini register ediyoruz
	// gayet güzel şekilde sayfayı yeniliyor siliyor herşeyi tam istediğimiz gibi sonra yazıyoruz kullanıcı bilgilerini 2-3 kere
	// login etme tuşuna basınca algılıyor anlamadım bence "Auth.js" ve "App.js" dosyalarında route ve handleButton yapısında sorunlar
	// var. Eğer bunu da halledersem 2 sorun kalıyor like atma da (sayfa refresh ettirmeden like çekmiyor), birde yazdığımız
	// comment'te text gözükmüyor.
	//---------------------------------------------------------------------------------------------------------------

	// 10. video dk 24:48  de kaldık tam olarak burada tabloya yeni column'lar ekledik, bunlar eklenmedi, sebebei ise
	// hibernate update yapmamıza rağmen tablolarda olan entity'ler yüzünden tüm tabloları temilzleyip yeniden create
	// ettik. Ve bu şekilde sorun çözüldü.
	// 10. VİDEODA GENEL OLARAK HERŞEYİ HALLETTİK ÇALIŞMAYAN BAZI ŞEYLER VAR LİKE ATMAK TEKTE SORUN GİBİ GÖZÜKÜYOR SİSTEME
	// TEKTE GİRİŞ YAPMAK SORUN GİBİ GÖZÜKÜYOR BU DEDİKLERİM VİDEO 10 DAN KAYNAKLI DEĞİL YOL ALIRKEN 3-5-7 DE ALDIK BU SORUNLARI
	// HANGİLERİNDE ALDIK BENDE TAM BİLMİYORUM. TEK BÜYÜK SORUNUMUZ 10. VİDEOYA DAİR AVATARI CHANGE ETTİKTEN SONRA O KULLANICI
	// TAMAMEN SİLİNİYOR AHAHAHSHAS BURAYA BAKARSIN.
	//10. videoda avaatar değiştirince kullanıcıyı siliyo

	//11. video sorunsuz şekilde tamamlandı

	//12. videoda refresh token ürettik falan ama üretim aşaması çalışıyorda sonrası çalışmıyor yeni tokenla mesela
	// user'lara GET isteği attığımızda UNAUTHORİZED alıyoruz. önceki tokenlada attığımızda da yine UNAUTHORİZED alıyoruz.
	// kısacası yeni token üretme işi yüzünden erişemiyoruz user'lara falan oraya bak tam 26:40 da kaldık bu işlemleri backend
	// kısmında yaptık tam fronnta geçecektik ama çalışmadığı için geçemedik.







}
