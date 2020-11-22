package DFS;

import java.util.*;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		int l = 0;
		int r = 0;
		//求出需要移除的左右括号数目，即为不规范的( 和 )数目
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				l++;
			}
			if(s.charAt(i) == ')'){
				if(l > 0){
					l--;
				}
				else{
					r++;
				}
			}
		}


		dfs(res,s,l,r,0);

		return res;
	}

	private void dfs(List<String> res, String s, int l, int r, int start){

		if(r == 0 && l == 0){

			if(isvalid(s)){
				res.add(s);
			}

			return;
		}
		//for loop操作每次删掉一个多余括号
		for(int i = start; i< s.length();i++){
			//连续多个重复括号删除第一个效果和删掉其他的相同，所有就删第一个。
			if(i != start && s.charAt(i) == s.charAt(i - 1)){
				continue;
			}

			//遇到 （ ，如果 l >0 去掉， 遇到（ 同理
			if(s.charAt(i) == '('){
				String next = s.substring(0,i) + s.substring(i+1);

				if(l > 0)
					dfs(res, next, l - 1, r, i);
			}
			if(s.charAt(i) == ')'){
				String next = s.substring(0,i) + s.substring(i+1);

				if(r > 0)
					dfs(res, next, l, r - 1, i);
			}
		}
	}

	private boolean isvalid(String s) {
		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ')' && arr[i] != '(') {
				continue;
			}
			if (arr[i] == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				} else {
					stack.pop();
				}
			} else {
				stack.add(arr[i]);
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
//		RemoveInvalidParentheses rp = new RemoveInvalidParentheses();
//		rp.removeInvalidParentheses("(a)())()");
//		rp.removeInvalidParentheses(")(");
//		rp.removeInvalidParentheses(")((())))))()(((l((((");

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10);
		pq.add(100);
		pq.add(1);
		pq.add(7);

		pq.poll();
		pq.poll();
		pq.poll();
	}
}
