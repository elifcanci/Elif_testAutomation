Feature: Kullanıcı Kaydı Oluşturma ve Bilgi Değiştirme

  Scenario: Yeni kullanıcı kaydı oluşturma ve bilgileri güncelleme
    Given Kullanıcı anasayfaya gider
    When Kullanıcı 'Signup Login' sekmesine tıklar
    And Kullanıcı ad olarak "Egem Test", email olarak "elifff@gmail.com" girer
    And Kullanıcı 'Signup' butonuna tıklar
    And Kullanıcı bilgilerini doldurur ve hesabı oluşturur
    Then Hesabın başarıyla oluşturulduğu mesajı görülür
