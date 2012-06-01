package cse461.snet;

import edu.uw.cs.cse461.sp12.OS.OS;
import edu.uw.cs.cse461.sp12.util.DB461.DB461Exception;
import edu.uw.cs.cse461.sp12.util.DB461SQLite;
import edu.uw.cs.cse461.sp12.util.SNetDB461;
import edu.uw.cs.cse461.sp12.util.SNetDB461.CommunityRecord;

/**
 * wrapper class over SNetDB461
 * @author Pingyang He
 *
 */
public class MDb {

    private static SNetDB461 instance;
    
    private MDb(){}
    
    public static SNetDB461 getInstance() throws DB461Exception{
        if(instance == null){
            instance = new SNetDB461();
            
            //setup root
            CommunityRecord rCr = instance.COMMUNITYTABLE.createRecord();
            rCr.name = "cse461.";
            instance.COMMUNITYTABLE.write(rCr);
            
            CommunityRecord mCr = instance.COMMUNITYTABLE.createRecord();
            mCr.name = OS.config().getProperty("host.name");
            instance.COMMUNITYTABLE.write(mCr);
            
        }
        
        return instance;
    }
}
