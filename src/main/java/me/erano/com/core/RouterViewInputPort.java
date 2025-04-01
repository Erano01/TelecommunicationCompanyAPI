package me.erano.com.core;

import me.erano.com.domain.Router;

import java.util.List;
import java.util.function.Predicate;

//input port
//Use caseler yalnızca yazılımın ne yaptığını tanımlayan arayüzlerse,
// bu use caselerin arayüzünü gerçekleştirmemiz gerektiğini gösterir.
// Input portunun rolü budur. Application levelinde, use caselerine
// doğrudan bağlı bir component olarak, input portları, domain terimlerinde
// yazılım amacını gerçekleştirmemize olanak tanır. İşte use case'da belirtilen
// yazılım amacını yerine getiren bir gerçekleştirme sağlayan bir input portu
public class RouterViewInputPort implements RouterViewUseCase {

    private RouterViewOutputPort routerListOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort) {
        this.routerListOutputPort = routerViewOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerListOutputPort.fetchRouters();
        return Router.retrieveRouter(routers, filter);
    }
}
