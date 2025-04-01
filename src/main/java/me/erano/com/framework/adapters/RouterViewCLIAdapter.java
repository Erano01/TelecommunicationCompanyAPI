package me.erano.com.framework.adapters;

import me.erano.com.core.RouterViewInputPort;
import me.erano.com.core.RouterViewUseCase;
import me.erano.com.domain.Router;
import me.erano.com.domain.RouterType;

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
