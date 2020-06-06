package org.hexrobot.fe5randomizer;

import java.util.HashMap;
import java.util.Map;

public class WeightedList<T> {
    private Map<T, Float> elements = new HashMap<>();
    private float totalWeights = 0;
    
    public void add(T element, float weight) {
        if(weight <= 0) {
            return;
        }
        
        if(elements.containsKey(element)) {
            totalWeights -= elements.get(element);
            System.out.println("Warning: Element " + element.toString() + "is already in list!");
        }
        
        elements.put(element, weight);
        totalWeights += weight;
    }
    
    public T getSelection(float randomNumber) {
        T selection = null;
        randomNumber *= totalWeights;
        
        for (Map.Entry<T, Float> entry : elements.entrySet()) {
            if(randomNumber < entry.getValue()) {
                selection = entry.getKey();
                break;
            } else {
                randomNumber -= entry.getValue();
            }
        }
        
        return selection;
    }
    
    @Override
    public String toString() {
        String text = "[WeightedList]\n";
        
        for (Map.Entry<T, Float> entry : elements.entrySet()) {
            float chance = entry.getValue() * 100.0f / totalWeights;
            
            text += String.format("%s ---> %.02f (%.02f)\n", entry.getKey().toString(), entry.getValue(), chance);
        }
        
        return text;
    }
}
