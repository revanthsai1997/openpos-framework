package org.jumpmind.pos.persist.impl;

import java.util.ArrayList;
import java.util.List;

import org.jumpmind.db.alter.IModelChange;
import org.jumpmind.db.alter.RemoveColumnChange;
import org.jumpmind.db.model.Database;
import org.jumpmind.db.platform.IAlterDatabaseInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchemaObjectRemoveInterceptor implements IAlterDatabaseInterceptor {
    
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public List<IModelChange> intercept(List<IModelChange> detectedChanges, Database currentModel, Database desiredModel) {
        List<IModelChange> interceptedChanges = new ArrayList<>();
        
        for (IModelChange modelChange : detectedChanges) {
            if ((modelChange instanceof RemoveColumnChange)) {
                RemoveColumnChange removeColumnChange = (RemoveColumnChange)modelChange;
                log.info("Preserve unrecognized column: " + removeColumnChange.getColumn());
            } else {
                interceptedChanges.add(modelChange);                
            }
        }
        
        return interceptedChanges;
    }

}
