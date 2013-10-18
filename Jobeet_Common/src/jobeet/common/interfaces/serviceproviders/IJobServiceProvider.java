/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobeet.common.interfaces.serviceproviders;

import java.util.ArrayList;
import jobeet.common.models.Job;

/**
 *
 * @author thuanpv
 */
public interface IJobServiceProvider {
    public Job getJob(int id);
    public ArrayList<Job> getAllJob() ;
}
