/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet.impl.datalayers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import jobeet.common.interfaces.datalayers.IJobDataLayer;
import jobeet.common.interfaces.factories.IConnectionFactory;
import jobeet.common.models.Job;

/**
 *
 * @author thuanpv
 */
public class JobDataLayer implements IJobDataLayer{

    private IConnectionFactory m_ConnectionFactory;
    
    public JobDataLayer(IConnectionFactory factory) {
        m_ConnectionFactory = factory;
    }
    
    @Override
    public Collection<Job> getAllJob() {
        
        EntityManager entityManager = m_ConnectionFactory.getEntityManager();
        Collection results = entityManager.createQuery("select * from Job")
                .getResultList();

        Collection<Job> ret = new ArrayList<Job>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Job job = (Job) iter.next();
            ret.add(job);
        }
        return ret;
    }

    @Override
    public Job getJob(int id) {
        EntityManager entityManager = m_ConnectionFactory.getEntityManager();
        Job job= null;
            job = (Job) entityManager.createQuery("Select * from Job j where j.id = :jid")
                    .setParameter("jid", id)
                    .getSingleResult();
            return job;
    }
    
}
