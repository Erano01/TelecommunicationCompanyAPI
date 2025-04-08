package me.erano.com.core.usecases;

import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.RouterId;

/*fully dressed use case
        • Actor: Infrastructure Engineer.
        • Goal: Edge router'a yeni network eklemek.
        • Scope: Infrastructure Department
        • Trigger: Network erişimini farklı bir network üzerinden ayırmanın özel bir nedeni.
        • Input Data: Router ID, Network name, address, CIDR
        • Actions:
            1. Router ID'ye bak
            2. Bu Network address'in zaten var olup olmadığını doğrula(validate)
            3. (Classless Inter-Domain Routing)CIDR'nin izin verilen minimum değerin altında olmadığını doğrulayın
            4. Önceki doğrulamalar uygunsa networkü bilgilendirilmiş(informed) router'a ekle.
*/
public interface RouterNetworkUseCase {

    Router addNetworkToRouter(RouterId routerId, Network network);
}
