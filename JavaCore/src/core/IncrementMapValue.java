package core;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//java 8 introduced some useful methods introduces in the map interface
// putIfAbsent()
// merge()
// getOrDefault()
// computeIfPresent()
public class IncrementMapValue {

	
	public static void main(String[] args) {
		
		Map<String, Integer> hashMap = new HashMap();
		hashMap.put("A", 1);
		
		incrementByPutIfAbsent(hashMap, "A");
		
		int[] Arr = {278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436};
		System.out.println(nonDivisibleSubset(7, Arr));
		int[] Arr1 = {1,7,2,4};
		System.out.println(nonDivisibleSubset(3, Arr1));
		
		int[] Arr2 = {1,2,3,4,5};
		System.out.println(nonDivisibleSubset(1, Arr2));

		
	}
	
	public static<K> void incrementByPutIfAbsent(Map<K, Integer> map, K key) {
		map.putIfAbsent(key, 0);
		map.put(key, map.get(key)+1);
	}
	
	public static<K> void incrementByMerge(Map<K, Integer> map, K key) {
		map.merge(key, 1, Integer::sum);
	}
	
	public static<K> void incrementBygetOrDefault(Map<K, Integer> map, K key) {
		Integer count = map.getOrDefault(key, 0);
		map.put(key, count+1);
	}
	
	public static<K> void incrementByComputeIfPresent(Map<K, Integer> map, K key) {
		if( map.computeIfPresent(key, (k,v) -> v+1) == null) {
			map.put(key, 1);
		}
	}
	
	static int nonDivisibleSubset(int k, int[] S) {
		System.out.println("----");
        Map<Integer, Integer> reminderMap = new TreeMap<Integer, Integer>();
        
        // reminder counter
        for(int i =0; i<S.length; i++){
            int reminder = S[i]%k;
            reminderMap.merge(reminder, 1, Integer::sum);
        }
        
        int largerArraySize = 0;
        boolean isEvenSize = k%2 == 0 ;
        System.out.println(reminderMap);
        
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry : reminderMap.entrySet()) {
        	Integer reminder = entry.getKey();
        	Integer reminderValue = entry.getValue();
        	Integer oppositeReminderValue = reminderMap.getOrDefault(k-reminder, 0);
        	map.put(Math.min(reminder, k-reminder), Math.max(reminderValue, oppositeReminderValue));
        }
        System.out.println(map);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	Integer reminder = entry.getKey();
        	if(reminder <= (k-1)/2) {
	        	if(reminder != 0 ) {
	        		//Integer oppositerReminderCount = reminderMap.getOrDefault(k- reminder, 0);
	        		largerArraySize += Math.max(map.get(reminder), map.getOrDefault(k- reminder, 0));
	        		System.out.println("reminder : "+reminder +" "+largerArraySize);
	        		
	        	}
        	}else {
        		break;
        	}
        }
      
        if(reminderMap.get(0) !=null) largerArraySize +=1;
        if(isEvenSize  && reminderMap.get(k/2) != null) largerArraySize +=1;
        
        return largerArraySize;

	}
}
