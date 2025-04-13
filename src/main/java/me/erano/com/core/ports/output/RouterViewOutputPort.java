package me.erano.com.core.ports.output;

import me.erano.com.domain.entity.Router;

import java.util.List;

// Output Port: Domain’in dış sistemleri çağırması
// Uygulamanın iç kısmı dış dünya ile iletişime geçmek isterse bu kapıdan dışarı çıkar.
// Ama doğrudan çıkamaz, önce bir output adapter (örneğin JPA repository) kapıyı açıp dış kaynakla bağlantıyı kurar.
public interface RouterViewOutputPort {

    List<Router> fetchRelatedRouters();
}
