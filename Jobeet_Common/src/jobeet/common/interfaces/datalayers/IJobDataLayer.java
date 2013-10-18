/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet.common.interfaces.datalayers;

import java.util.Collection;
import jobeet.common.models.Job;

/**
 *
 * @author thuanpv
 */
public interface IJobDataLayer {
    public Collection<Job> getAllJob();
    public Job getJob(int id);
    
}
