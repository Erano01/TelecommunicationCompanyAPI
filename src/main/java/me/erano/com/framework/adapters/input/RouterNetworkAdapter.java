package me.erano.com.framework.adapters.input;

import me.erano.com.core.usecases.RouterNetworkUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.Network;
import me.erano.com.domain.value.RouterId;
import me.erano.com.domain.value.IP;

import java.util.Map;



public abstract class RouterNetworkAdapter {

    protected Router router;
    protected RouterNetworkUseCase routerNetworkUseCase;

    protected Router addNetworkToRouter(Map<String, String> params){
        var routerId = RouterId.withId(params.get("routerId"));
        var network = new Network(IP.fromAddress(params.get("address")),
                params.get("name"),
                Integer.valueOf(params.get("cidr")));
        return routerNetworkUseCase.addNetworkToRouter(routerId, network);
    }

    public abstract Router processRequest(Object requestParams);
}
