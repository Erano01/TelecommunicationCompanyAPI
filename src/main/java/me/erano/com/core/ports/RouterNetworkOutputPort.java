package me.erano.com.core.ports;

import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.RouterId;

// Output Port:
// Uygulamanın iç kısmı dış dünya ile iletişime geçmek isterse bu kapıdan dışarı çıkar.
// Ama doğrudan çıkamaz, önce bir output adapter (örneğin JPA repository) kapıyı açıp dış kaynakla bağlantıyı kurar.
public interface RouterNetworkOutputPort {
    Router fetchRouterById(RouterId routerId);

    boolean persistRouter(Router router);
}
