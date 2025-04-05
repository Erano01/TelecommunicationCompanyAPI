package me.erano.com.domain.specification;

import me.erano.com.domain.specification.shared.AbstractSpecification;

//Classless Inter-Domain Routing
//Network adresinin tüm networkde herhangi bir yerde zaten kullanılıp kullanılmadığını doğrular.
public class CIDRSpecification extends AbstractSpecification<Integer> {

    final static public int MINIMUM_ALLOWED_CIDR = 8;

    @Override
    public boolean isSatisfiedBy(Integer cidr) {
        return cidr > MINIMUM_ALLOWED_CIDR;
    }
}
