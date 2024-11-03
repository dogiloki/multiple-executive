package com.dogiloki.multipleexecutive.app;

import com.dogiloki.multipleexecutive.domains.Executive;
import com.dogiloki.multitaks.persistent.ExecutionObserver;
import java.io.IOException;

/**
 *
 * @author _dogi
 */

public class ExecutiveService{
    
    public Executive executive;
    
    public ExecutiveService(Executive executive){
        this.executive=executive;
    }
    
    public ExecutionObserver exec() throws IOException{
        return ExecutionObserver.execution(this.executive.command,this.executive.context);
    }
    
}
