Feature: Sipariş Verme ve Fatura İndirme

  Scenario: Ürün sepete eklenir ve sipariş verilir
    Given Kullanıcı anasayfadadır
    When Kullanıcı 'Login' butonuna tıklar
    And Kullanıcı email olarak "egemtest@gmail.com" ve şifre olarak "egem12" girip giriş yapar
    And Kullanıcı ürün sayfasına gider ve bir ürün sepete ekler
    And Kullanıcı sepeti görüntüler ve ödeme aşamasına geçer
    And Kullanıcı ödeme bilgilerini doldurur ve siparişi tamamlar
    Then Siparişin başarıyla verildiği mesajı görüntülenir
    When Kullanıcı 'Download Invoice' butonuna tıklar
    Then 'invoice.txt' dosyasının indirildiği doğrulanır
