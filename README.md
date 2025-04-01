# Understanding of Project Structure

---

## Domain Hexagon
- Business domains burada bulunur.

## Application (Core) Hexagon
- Business domains constraints (**istenilen/olması gereken fonksiyonların soyutlamaları**) burada yer alır.
- **Input/Output portları ve Use Case’lerin soyutlamaları** burada bulunur.

## Framework Hexagon
- Teknolojilerin belirlenmesi ve teknolojilerin **constraintlerinin** uygulandığı yerdir.
- **Input ve Output Adapterler** burada bulunur.

---

## Driver-Side (Driving Adapter / Driving Actor)
- **Input adaptörleri kullanılır.**
- **Uygulamayı tetikleyen bileşenlerdir.**
- **Örnekler:**  
  - REST (Adapter)  
  - CLI (Adapter)  
  - gRPC (Adapter)  
  - SOAP (Adapter)  
  - **Test Case (Actor)**  

## Driven-Side (Output Adapters)
- **Uygulamanın bağımlı olduğu bileşenlerdir.**
- **Örnekler:**  
  - Repository  
  - HTTP Client  
  - Message Queue  
  - File System  
