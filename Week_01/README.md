## 学习笔记
week1 作业目录：

[1.两数之和](#1)     
[21.合并两个有序链表](#21)   
[26.删除排序数组中的重复项](#26)   
[42.接雨水](#42)   
[66.加一](#66)   
[155.最小栈](#155)

<h4 id='1'>1.两数之和</h4>
 + [原题链接](https://leetcode-cn.com/problems/two-sum/)       
 + 选择python作为练习语言是因为python平常用起来比较简单，导致容易忽略很多基础，就连简单的列表循环也是有很多值得注意的，比如说enumerate，应该根据需要选择合适的迭代方式。

<h4 id='21'>21.合并两个有序链表</h4>
 + [原题链接](https://leetcode-cn.com/problems/merge-two-sorted-lists/)         
 + python里面并没有链表的数据结构，因此需要自己定义链表的结构，最开始我是将node和linkedlist分开定义的，没有办法通过leetcode的检测，而且python的链表似乎并非以内存空间来进行下一个节点指定的（至少编码过程中不是使用内存空间的），以21题为例，next指向的其实可以认为是下一个链表，而不是单独的节点，最开始编码的时候将节点和链表分开思考，想了不少时间。
 
<h4 id='26'>26.删除排序数组中的重复项</h4>
 + [原题链接](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)     
 + 双指针的方法在数组操作过程中应该很常见，需要找些类似的题目看下
 + python似乎可以先转成set，排个序，再转成list，充分使用语言特性 -> 赋值的时候使用nums[:]而不是nums，原因是如果直接使用nums,实际上是进行了拷贝 
 + python调用方法时传入的参数需要注意是引用
 
 <h4 id='42'>42.接雨水</h4>
 + [原题链接](https://leetcode.com/problems/trapping-rain-water/)        
 + 使用双列表进行处理，同时改变角度，按行进行处理
 
 <h4 id="66">66.加一</h4>
 + [原题链接](https://leetcode-cn.com/problems/plus-one/)            
 + 如果用直接计算数据大小再转化为数组的方法的话比较容易想到，但是需要注意python对于数的处理，float和int是如何处理的，但是这种方法不能算是跟算法相关的了
 + 第二种方法是通过进位判断是否需要在最前端+1，由于列表开头添加元素是需要O(n)的时间复杂度的，因此看了一下python自带的insert的源码，发现是pass，意味着这部分功能实际上使用C写的，感觉联系算法还是得用编译型语言，不然有很多tricky的地方，会影响判断和思考。
 
 <h4 id="155">155.最小栈</h4>
 + [原题链接](https://leetcode-cn.com/problems/min-stack/)        
 + 如果有最近相关性，就可以使用Stack来解决
 + 语言角度没有什么好说的，两个栈没有想到，同时第二个辅助栈我是觉得只有当第一个栈中push进去的值使最小值发生变化时才要push进最新的最小值，这样会导致pop出去时需要进行判断
 
 <h4>以下两个问题需要用Java实现</h4>
 + 用 add first 或 add last 这套新的 API 改写 Deque 的代码
 + 分析 Queue 和 Priority Queue 的源码