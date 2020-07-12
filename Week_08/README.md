学习笔记
+ 位运算
  + 基本功
  + 位运算符号：
  
  |  操作   | 符号  | 示例  |
  |  ----  | ----  | ----  |
  | 左移  | << | 0011<<1  左移一格 =》 0110 |
  | 右移  | >> | 0011>>1  右移一格 =》 0011 |
  | 按位与  | & | 0011 & 1011   =》 0011 |
  | 按位或  | \| | 0011 \| 1011 =》 1011 |
  | 按位取反  | ~ | ~0011    =》 1100 |
  | 按位异或（相同为0不同为1）  | ^ | 0011 ^ 1011 =》 1000 |
  + 异或操作：
    + x^0 = x
    + x^1s = ~x
    + x^(~x) = 1s
    + x^x = 0
    + c=a^b  =>  a^c=b, b^c=a
  
  + 指定位置的位运算：
    1. 将x最右边的n位清零： x&（~0<<n）
    2. 获取x的第n位值（0或者1）： (x>>n)&1
    3. 获取x的第n位幂值： x&(1<<n)
    4. 仅将第n位位置置1： x|(1<<n)
    5. 仅将第n位位置置0： x&(~(1<<n))
    6. 将x最高位至第n位清0： x&((1<<n)-1)
  
  + 实战位运算要点：
    + 判断奇数偶数： x%2==1 ->  x&1 == 1
    + x>>1 -> x/2
    + x&(x-1) 去掉最低位的1
+ 布隆过滤器与LLRU缓存
+ 排序算法
  + 基础排序
    + 选择排序
      ```java
      public static void selectionSort(int[] arr) {
          int min, temp, len = arr.length;
          for (int i = 0; i < len - 1; i++) {
              min = i;//未排序序列中最小数据数组下标
              for (int j = i + 1; j < len; j++) { 
                  //在未排序元素中继续寻找最小元素，并保存其下标
                  if (arr[min] > arr[j]) {
                      min = j;
                  }
              }
              if (min != i) {
                  temp = arr[min]; 
                  //将最小元素放到已排序序列的末尾
                  arr[min] = arr[i];
                  arr[i] = temp;
              }
          }
      }
      ```
    + 插入排序
      ```java
      public static <T extends Comparable> void insertionSort(T[] arr) {
        int j;
        
        // 从数组第二个元素开始，向前比较
        for (int p = 1; p < arr.length; p++) {
            T tmp = arr[p];
            // 循环，向前依次比较
            // 如果比前面元素小，交换位置
            for (j = p; (j > 0) && (tmp.compareTo(arr[j - 1]) < 0); j--) {
                arr[j] = arr[j - 1];
            }
            // 如果比前面元素大或者相等，那么这就是元素的位置，交换
            arr[j] = tmp;
        }
      }
      ```
    + 冒泡排序
      ```java
      public static void bubbleSort(int[] arr) {
          int temp = 0;
          for (int i = arr.length - 1; i > 0; --i) { // 每次需要排序的长度
              for (int j = 0; j < i; ++j) { // 从第一个元素到第i个元素
                  if (arr[j] > arr[j + 1]) {
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
      }
      ```