package org.jboss.seam.forge.persistence;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.io.Serializable;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
@ConversationScoped
public class DatasourceProducer implements Serializable {
    private static final long serialVersionUID = -5267593171036179836L;
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    @ConversationScoped
    public EntityManager create() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        em.close();
    }
}
