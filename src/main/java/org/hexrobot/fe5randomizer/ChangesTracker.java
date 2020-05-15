package org.hexrobot.fe5randomizer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class ChangesTracker implements PropertyChangeListener {
    private final Map<Object, Map<String, Object>> oldValues = new HashMap<>();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if(oldValues.containsKey(e.getSource())) {
            Map<String, Object> propertiesMap = oldValues.get(e.getSource());
            propertiesMap.put(e.getPropertyName(), e.getOldValue());
        } else {
            Map<String, Object> propertiesMap = new HashMap<String, Object>();
            propertiesMap.put(e.getPropertyName(), e.getOldValue());

            oldValues.put(e.getSource(), propertiesMap);
        }
    }
    
    public Map<Object, Map<String, Object>> getChanges() {
        return oldValues;
    }
}
