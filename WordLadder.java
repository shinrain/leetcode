import java.util.*;
import java.lang.*;

// Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]


class Solution {


	static List<List<String>> findResult(String end,HashMap<String, ArrayList<String>> map)
	{
		System.out.println("Check "+end);
		List<List<String>> re_list = new ArrayList<List<String>>();
		if(!map.containsKey(end))
		{
			
			List<String> re = new ArrayList<String>();
			re.add(end);
			re_list.add(re);
			return re_list;
		}
		List<List<String>> r_list = null;
		ArrayList<String> r = map.get(end);
		for(int i=0; i<r.size(); i++)
		{
			String cur = r.get(i);
			 r_list= findResult(cur, map);
			for(int j=0; j<r_list.size(); j++)
			{
				List<String> li = ((ArrayList<List<String>>)r_list).get(j);
				li.add(end);
				re_list.add(li);
			}
		}
		return re_list;
	}

	static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> re = new LinkedList<List<String>>();
    	if(start.length()!=end.length()) return re;

 		if(start.equals(end))
 		{
 			List<String> r = new LinkedList<String>();
 			r.add(start);
 			re.add(r);
 		}
 		else
 		{
 			dict.remove(start);
 			HashSet<Character> letters = new HashSet<Character>();
 			for(String ss : dict)
 			{
 				for(int i=0;i<ss.length();i++)
 				{
 					if(!letters.contains(ss.charAt(i)))
 						letters.add(ss.charAt(i));
 				}
 			}

 			ArrayList<String> col = new ArrayList<String>();
 			boolean found = false;

 			col.add(start);
 			int left = 0;
 			HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
 			while(!found && col.size()!= left)
 			{
 				int N = col.size();
 				int ind_left  = left;
 				while(left<N)
				{
 					String cur = col.get(left++);

 					int n = cur.length();
 					for(int i=0;i<n;i++)
 					{
 						char[] str = cur.toCharArray();
 						char tmp = str[i];
 						for(char c : letters)
 						{
 							if(c==str[i])
 								continue;
 							str[i] = c;
 							String new_str = new String(str);
 							if(dict.contains(new_str))
 							{
 								col.add(new_str);
 								if(new_str.equals(end))
 								{
 									found = true;
 								}
 								if(map.containsKey(new_str)){
 									ArrayList<String> lis = map.get(new_str);
 									if(!lis.contains(cur))
 									{
	 									lis.add(cur);
	 									map.put(new_str,lis); 										
 									}
 								}
 								else
 								{
 									ArrayList<String> prevList = new ArrayList<String>();
 									prevList.add(cur);
 									map.put(new_str, prevList);
 								}
 							}
 							str[i] = tmp;
 						}
 					}
 				}
 				for(;left<col.size();left++)
 				{
 					if(dict.contains(col.get(left))){

	 					dict.remove(col.get(left));
 					}
 				}

 				left = N;
 			}

 			if(found)
 			{

 				System.out.println(map);
 				re = (List<List<String>>)findResult(end, map);
 			}
 		}
 		return re;
	}

	public static void main(String[] args){
		String[] dict = {"hot","dog","dot"};
		Set<String> d = new HashSet<String>(Arrays.asList(dict));


		System.out.println(findLadders("hot", "dog",d));

	}

}