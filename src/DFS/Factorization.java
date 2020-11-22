package DFS;

import java.util.ArrayList;
import java.util.List;

public class Factorization {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> ans = new ArrayList<>();
		dfs(n,2,new ArrayList<Integer>(),ans);
		return ans;
	}
	private void dfs(int n,int biggerFactor,List<Integer> res,List<List<Integer>>ans) {
		//空队列不能作为结果
		if (!res.isEmpty()) {
			res.add(n);
			ans.add(new ArrayList<Integer>(res));
			res.remove(res.size()-1);
		}
		for (int i = biggerFactor;i <= Math.sqrt(n);i++) {//从biggerFactor--sqrt(n)查找因子
			if (n % i == 0) {//若i是n的因子，则添加，然后将i作为ind去查找更大的因子
				res.add(i);
				dfs(n / i,i,res,ans);
				res.remove(res.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Factorization f = new Factorization();
		f.getFactors(8);
	}
}
