1/**
2 * @param {number[]} nums
3 * @return {void}
4 */
5var ArrayWrapper = function(nums) {
6  this.nums = nums;
7};
8
9/**
10 * When used in numeric context, e.g. obj1 + obj2
11 * @return {number}
12 */
13ArrayWrapper.prototype.valueOf = function() {
14  return this.nums.reduce((sum, x) => sum + x, 0);
15};
16
17/**
18 * When converted to string, e.g. String(obj)
19 * @return {string}
20 */
21ArrayWrapper.prototype.toString = function() {
22  return `[${this.nums.join(",")}]`;
23};
24