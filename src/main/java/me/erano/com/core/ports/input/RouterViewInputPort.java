package me.erano.com.core.ports.input;

import me.erano.com.core.ports.output.RouterViewOutputPort;
import me.erano.com.core.usecases.RouterViewUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.service.RouterSearch;
import me.erano.com.domain.value.RouterType;

import java.util.List;
import java.util.function.Predicate;

//Input Port: Domain’in dış aktörler tarafından çağrılması
// Dış dünya (misafir), bu kapıdan içeri girmeye çalışır.
// Ama içeri direkt giremez, önce input adapter (örneğin REST Controller) gelip kapıyı açar.
// Input Portlarında Use Caselerimizi implement ederiz
public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerListOutputPort;

    private Router router;

    public RouterViewInputPort(RouterViewOutputPort routerGraphOutputPort) {
        this.routerListOutputPort = routerGraphOutputPort;
    }

    @Override
    public List<Router> getRelatedRouters(RelatedRoutersCommand relatedRoutersCommand) {
        var type = relatedRoutersCommand.getType();
        var routers = routerListOutputPort.fetchRelatedRouters();
        return fetchRelatedEdgeRouters(type, routers);
    }

    private List<Router> fetchRelatedEdgeRouters(RouterType type, List<Router> routers){
        return RouterSearch.getRouters(type, routers);
    }
}
