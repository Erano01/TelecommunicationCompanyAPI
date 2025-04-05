package me.erano.com.core.ports;

import me.erano.com.domain.entity.Router;

import java.util.List;

//Output Port
//Bir use case'in hedeflerine ulaşmak için external kaynaklardan veri alması gereken durumlar vardır.
// Bu, technology-agnostic olmayan bir şekilde, bir use case'i veya input port işlemlerini gerçekleştirmek için
// dışarıdan hangi tip veriyi alması gerektiğini tanımlayan arayüzler olarak temsil edilen output portlarının rolüdür.
//Agnostik diyorum çünkü output portları, verilerin belirli bir ilişkisel veritabanı(rdbms) teknolojisinden veya
// örneğin bir dosya sisteminden gelip gelmediğini umursamaz. Bu sorumluluğu, kısa süre sonra inceleyeceğimiz
// output adaptörlerine atarız:
public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
