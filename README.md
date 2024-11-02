# MapStruct and Data Transfer Object (DTO)
**Data Transfer Object (DTO)**, veri transferi için kullanılan bir tasarım desenidir. DTO’lar, nesnelerin verilerini bir yerden başka bir yere aktarmak için kullanılır. Genellikle bir veritabanından veri çekilirken veya bir web hizmetine veri gönderilirken DTO’lar kullanılır.
#### **Record keyword**
Java **record** anahtar kelimesi, veri taşıyan nesnelerin oluşturulmasını daha basit, daha güvenli ve daha anlaşılır hale getirir. Immutable yapısı sayesinde veri tutarlılığını artırırken, otomatik olarak oluşturulan metodlar sayesinde geliştiricilere zaman kazandırır. Bu, özellikle DTO'lar gibi basit veri yapıları için oldukça faydalıdır.record kullanarak tanımladığınız sınıflar için Java otomatik olarak şu metodları oluşturur:
- constructor: Tüm alanları alarak bir nesne oluşturur.
- getter'lar: Her alan için otomatik olarak getter metotları oluşturur
- **`toString()` Metodu**: Nesnenin string temsili için bir metot oluşturur.
- **`equals()` ve `hashCode()` Metotları**: İki `record` nesnesinin eşitliğini kontrol etmek ve hash kodunu oluşturmak için gerekli metodlar sağlar.
- `record`'lar sadece final alanlar içerebilir, yani `record`'da değişken tanımlayamazsınız.
- `record`'lar, diğer sınıflar gibi genişletilemez. Bir sınıfı miras alarak geliştiremezsiniz.
## Mapping Çeşitleri

DTO'lar arasında dönüşüm (mapping) yapmak için birkaç popüler kütüphane vardır:

1. **ModelMapper**: Nesneler arasında dinamik bir şekilde dönüşüm yapar. Kullanımı kolaydır ama performansı büyük nesnelerde düşebilir. Özellikle karmaşık nesnelerde daha fazla yapılandırma gerektirebilir.
2. **BeanUtils**: Java'da nesneler arasındaki alanları kopyalamak için basit bir kütüphanedir. Ancak, karmaşık dönüşümler veya derin kopyalamalar için yeterli olmayabilir. Genellikle basit durumlar için kullanılır.(beanutils copyproperties())
3. **MapStruct**: Compile-time (derleme zamanı) olarak çalışır, bu da daha hızlı ve daha güvenilir dönüşümler sağlar. MapStruct, dönüşüm işlemlerini derleme sırasında oluşturduğu için runtime'da performans kaybı yaşanmaz. Ayrıca, tip güvenliği sağlar ve karmaşık dönüşüm senaryolarında oldukça esneklik sunar.

## DTO'larda Record Kullanmanın Avantajları

1. **Immutable (Değişmezlik)**: Record'lar varsayılan olarak immutable'dır. Bu, DTO'ların oluşturulduktan sonra değiştirilmemesini sağlar, böylece veri tutarlılığı artar.
2. **Kısa ve Anlaşılır**: Record kullanarak DTO'ları daha az kod ile tanımlamak mümkündür. Constructor, getter ve toString metotları otomatik olarak oluşturulur.
3. **Veri Taşıma**: Record'lar sadece veri tutmakla kalmaz, aynı zamanda içerdikleri verileri daha düzenli bir şekilde sunar.

## MapStruct

MapStruct, Java bean'leri arasında dönüşüm yapmak için kullanılan bir çerçevedir. Aşağıda MapStruct'un temel özelliklerini bulabilirsiniz:

- **Anotasyon Bazlı**: MapStruct, `@Mapper` anotasyonu ile yapılandırılır. Mapper arayüzleri tanımlanır ve bu arayüzler üzerinde dönüşüm metotları belirtilir.
- **Derleme Zamanı Dönüşümü**: MapStruct, dönüşüm kodunu derleme zamanında oluşturur, bu da runtime hatalarını en aza indirir ve performansı artırır.
- **Özelleştirilebilir**: Dönüşüm metotları özelleştirilebilir ve belirli alanlar için özel dönüşümler tanımlanabilir.
- **Collection Dönüşümleri**: MapStruct, koleksiyonlar üzerinde dönüşüm yapma yeteneğine sahiptir, bu da büyük veri setleriyle çalışırken oldukça kullanışlıdır.
- **Gelişmiş Özellikler**: Enum dönüşümleri, nested DTO'lar, ve özel mapleme stratejileri gibi özellikler sunar.
