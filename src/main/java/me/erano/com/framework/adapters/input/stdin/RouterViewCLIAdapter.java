package me.erano.com.framework.adapters.input.stdin;

import me.erano.com.core.ports.input.RouterViewInputPort;
import me.erano.com.core.usecases.RouterViewUseCase;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.RouterType;
import me.erano.com.framework.adapters.output.file.RouterViewFileAdapter;
import me.erano.com.core.usecases.RouterViewUseCase.RelatedRoutersCommand;

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
        RelatedRoutersCommand relatedRoutersCommand = new RelatedRoutersCommand(type);
        return routerViewUseCase.getRelatedRouters(relatedRoutersCommand);
    }

    private void setAdapters(){
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }
}
