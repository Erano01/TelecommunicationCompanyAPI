package me.erano.com.domain.service;

import me.erano.com.domain.entity.Router;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Service
public class RouterSearch {

    //retrieveRouter() method moved to this service from Router
    public static List<Router> retrieveRouter(List<Router> routers, Predicate<Router> predicate){
        return routers.stream()
                .filter(predicate)
                .collect(Collectors.<Router>toList());
    }
}
