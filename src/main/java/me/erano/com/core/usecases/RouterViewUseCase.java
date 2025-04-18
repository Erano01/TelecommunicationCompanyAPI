package me.erano.com.core.usecases;

import java.util.List;
import java.util.function.Predicate;
import me.erano.com.domain.entity.Router;
import me.erano.com.domain.value.RouterType;

//use case
//Use caseler, domain constraintlerini desteklemek için var olan application-specific işlemler aracılığıyla sistemin davranışını temsil eder. Use caseleri, entityler ve diğer use caseleriyle doğrudan etkileşime girebilir ve bunları esnek componentler haline getirebilir.
//Java'da, use caselerini, yazılımın neler yapabileceğini ifade eden interfaceler tarafından tanımlanan soyutlamalar olarak temsil ederiz. Aşağıdaki kod, routerların filtrelenmiş bir listesini almak için bir işlem sağlayan bir use case'i gösterir:
public interface RouterViewUseCase {

    List<Router> getRelatedRouters(RelatedRoutersCommand relatedRoutersCommand);

    class RelatedRoutersCommand {

        private RouterType type;

        public RelatedRoutersCommand(String type){
            this.type = RouterType.valueOf(type);
        }

        public RouterType getType() {
            return type;
        }
    }
}
