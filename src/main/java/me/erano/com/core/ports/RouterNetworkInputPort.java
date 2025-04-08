package me.erano.com.core.ports;

import me.erano.com.core.usecases.RouterNetworkUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.service.NetworkOperation;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.RouterId;

//Input Port
// Dış dünya (misafir), bu kapıdan içeri girmeye çalışır.
// Ama içeri direkt giremez, önce input adapter (örneğin REST Controller) gelip kapıyı açar.
// Input Portlarında Use Caselerimizi implement ederiz
public class RouterNetworkInputPort implements RouterNetworkUseCase {

    private final RouterNetworkOutputPort routerNetworkOutputPort;

    public RouterNetworkInputPort(RouterNetworkOutputPort routerNetworkOutputPort){
        this.routerNetworkOutputPort = routerNetworkOutputPort;
    }

    @Override
    public Router addNetworkToRouter(RouterId routerId, Network network) {
        var router = fetchRouter(routerId);
        return createNetwork(router, network);
    }

    private Router fetchRouter(RouterId routerId) {
        return routerNetworkOutputPort.fetchRouterById(routerId);
    }

    private Router createNetwork(Router router, Network network) {
        var newRouter = NetworkOperation.createNewNetwork(router, network);
        return persistNetwork(router) ? newRouter :
                router;
    }

    private boolean persistNetwork(Router router) {
        return routerNetworkOutputPort.persistRouter(router);
    }

}
