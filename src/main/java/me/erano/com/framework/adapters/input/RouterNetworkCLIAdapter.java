package me.erano.com.framework.adapters.input;

import me.erano.com.core.ports.RouterNetworkInputPort;
import me.erano.com.core.usecases.RouterNetworkUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.RouterId;
import me.erano.com.framework.adapters.output.RouterNetworkFileAdapter;

public class RouterNetworkCLIAdapter {

    RouterNetworkUseCase routerNetworkUseCase;

    public RouterNetworkCLIAdapter(){
        setAdapters();
    }

    public Router addNetwork(RouterId routerId, Network network){
        return routerNetworkUseCase.addNetworkToRouter(routerId, network);
    }

    private void setAdapters(){
        this.routerNetworkUseCase = new RouterNetworkInputPort(RouterNetworkFileAdapter.getInstance());
    }

}
