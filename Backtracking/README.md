## 回溯算法总结

**<font face="微软雅黑" size = 4>解决一个回溯问题，其实就是遍历决策树的过程</font>**

* 路径(path)：已经做出的选择
* 选择列表(selected list)：你当前可以做的选择
* 结束条件(end condition)：到达决策树的底层，无法再做出选择的条件
* 当前进度(level)：当前到了第几层，做记录



**<font face="微软雅黑" size = 4>算法框架</font>**

```
res = [];
void backtrack(path, selected list, level){
	if(Meet the end criteria){
		res.add(path);
		return;
	}
	for choice in selected list{
		exclude illegal options
		make a choice
		backtrack(path, selected list, level + 1);
		revoke the choice
	}
}
```



**<font face="微软雅黑" size = 4>N个树的全排列以及八皇后问题都是经典的回溯算法实例</font>**



