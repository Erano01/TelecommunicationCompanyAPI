package me.erano.com.domain.service;

import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.RouterType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Service
public class RouterSearch {

    //retrieveRouter() method moved to this service from Router
    public static List<Router> getRouters(RouterType type, List<Router> routers) {
        var routersList = new ArrayList<Router>();
        routers.forEach(router -> {
            if(router.isType(type)){
                routersList.add(router);
            }
        });
        return routersList;
    }
}
