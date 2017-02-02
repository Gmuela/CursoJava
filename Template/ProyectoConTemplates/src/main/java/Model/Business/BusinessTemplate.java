package Model.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessTemplate {

//  @Autowired
//  @Qualifier("BusinessImplementationName")
//  BeanDAO beanDAO

    @Transactional
    public void unMetodoCualquiera(){
//      beanDAO.loQueSea();
    }

    /*EL RESTO DE MÉTODOS DEL NEGOCIO*/

}
