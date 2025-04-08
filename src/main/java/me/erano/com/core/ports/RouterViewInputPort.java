package me.erano.com.core.ports;

import me.erano.com.core.usecases.RouterViewUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.service.RouterSearch;

import java.util.List;
import java.util.function.Predicate;

//Input Port
// Dış dünya (misafir), bu kapıdan içeri girmeye çalışır.
// Ama içeri direkt giremez, önce input adapter (örneğin REST Controller) gelip kapıyı açar.
// Input Portlarında Use Caselerimizi implement ederiz
public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerListOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort) {
        this.routerListOutputPort = routerViewOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerListOutputPort.fetchRouters();
        return RouterSearch.retrieveRouter(routers, filter);
    }
}
