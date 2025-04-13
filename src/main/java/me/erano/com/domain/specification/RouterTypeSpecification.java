package me.erano.com.domain.specification;

import me.erano.com.domain.entity.Router;
import me.erano.com.domain.specification.shared.AbstractSpecification;
import me.erano.com.domain.value.RouterType;

public class RouterTypeSpecification extends AbstractSpecification<Router> {
    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.isType(RouterType.EDGE);
    }
}