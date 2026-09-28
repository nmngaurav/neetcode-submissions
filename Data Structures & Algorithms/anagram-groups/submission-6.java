class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
	   // check empty or null or min size
	   if(strs == null || strs.length == 0){
	       return new ArrayList<List<String>>(); 
	   }
	   
	   Map<String, List<String>> map = new HashMap<String, List<String>>();
	   for(String str : strs){
	       char[] chArray = str.toCharArray();
	       Arrays.sort(chArray);
	       String sortedStr = new String(chArray);
	    //    List<String> listStr = new ArrayList<>();
	    //    if(!map.containsKey(sortedStr)){
	    //        listStr.add(str);
	    //    }else{
	    //        listStr = map.get(sortedStr);
	    //        listStr.add(str);
	    //    }
	    //     map.put(sortedStr, listStr);
	       map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
	   }
	       return new ArrayList<>(map.values());
    }
}
