package main.util;

import java.util.ArrayList;
import main.math.Vector2D;
import main.util.arrays.DataArray;
import main.util.data.Data;

public class Filter {
    public static Data[] filterGeo(Data[] set) {
        ArrayList<Data> filteredSet = new ArrayList<>();
        for(Data item : set)
            if(item.location != null)
                filteredSet.add(item);
        
        return filteredSet.toArray(new Data[filteredSet.size()]);
    }
    
    public static Data[] filterGeoLoc(Data[] set) {
        ArrayList<Data> filteredSet = new ArrayList<>();
        for(Data item : set)
            if(item.point != null)
                filteredSet.add(item);
        
        return filteredSet.toArray(new Data[filteredSet.size()]);
    }
    
    public static Data[] filterHashtag(Data[] set, String hashtag) {
        DataArray array = new DataArray(set.length+1);
        array.add(set[0]);
        for(Data item : set)
            if(item.hashtags.contains(hashtag))
                array.add(item);
        array.add(set[set.length-1]);
        return array.getValues();
    }
    
    public static Data[] filterRetweet(Data[] set) {
        ArrayList<Data> filteredSet = new ArrayList<Data>();
        filteredSet.add(set[0]);
        for(Data item : set)
            if(!item.isRetweet)
                filteredSet.add(item);
        filteredSet.add(set[set.length-1]);
        return filteredSet.toArray(new Data[filteredSet.size()]);
    }
    
    public static Data[] filterNearLocation(Data[] originalSet, Vector2D point) {
        DataArray array = new DataArray(originalSet.length+1);
        array.add(originalSet[0]);
        for(Data item : originalSet)
            if(item.isWithinDistance(point, (double)100))
                array.add(item);
        array.add(originalSet[originalSet.length-1]);
        return array.getValues();
    }
}
