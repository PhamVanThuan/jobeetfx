/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet.impl.serviceproviders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jobeet.common.interfaces.datalayers.IJobDataLayer;
import jobeet.common.interfaces.serviceproviders.IJobServiceProvider;
import jobeet.common.models.Job;

/**
 *
 * @author thuanpv
 */
public class JobServiceProvider implements IJobServiceProvider {

    private IJobDataLayer m_JobDataLayer;

    public JobServiceProvider(IJobDataLayer jobdatalayer) {
        m_JobDataLayer = jobdatalayer;
    }
    
    @Override
    public Job getJob(int id) {
        Job job;
        job = m_JobDataLayer.getJob(id);
        return job;
    }

    @Override
    public ArrayList<Job> getAllJob() {
        Collection c = m_JobDataLayer.getAllJob();
        ArrayList<Job> ret = new ArrayList<Job>();

        for (Iterator iter = c.iterator(); iter.hasNext();) {
            Job job = (Job) iter.next();
            ret.add(job);
        }

        return ret;
    }
    
}
