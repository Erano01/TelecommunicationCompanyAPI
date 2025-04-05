package me.erano.com.framework.adapters;

import me.erano.com.core.ports.RouterViewInputPort;
import me.erano.com.core.usecases.RouterViewUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.RouterType;

import java.util.List;

// Framework hexagonda
//Driver-side(driving adapter / driving actor -> test case) için Input adaptörleri
//Uygulamayı **tetikleyen** bileşenlerdir.
// Örneğin: REST(Adapter), CLI(Adapter), gRPC(Adapter), SOAP(Adapter), Test Case (Actor)
public class RouterViewCLIAdapter {

    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter(){
        setAdapters();
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type)));
    }

    private void setAdapters(){
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }
}
