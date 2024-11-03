package com.dogiloki.multipleexecutive.domains;

import com.dogiloki.multitaks.database.ModelDB;
import com.dogiloki.multitaks.database.annotations.Collect;
import com.google.gson.annotations.Expose;

/**
 *
 * @author _dogi
 */

@Collect(src="executives")
public class Executive extends ModelDB{
    
    @Expose
    public String name;
    @Expose
    public String context;
    @Expose
    public String command;
    
    public Executive(){
        
    }
    
}
