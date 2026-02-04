1/**
2 * @param {Object} context
3 * @param  {...any} args
4 * @return {null|boolean|number|string|Array|Object}
5 */
6Function.prototype.callPolyfill = function (context, ...args) {
7    // Ensure context is an object (per constraints it's non-null)
8    context = Object(context);
9
10    // Use a unique property to avoid collisions
11    const fnKey = Symbol('fn');
12    context[fnKey] = this;
13
14    const result = context[fnKey](...args);
15
16    // Clean up
17    delete context[fnKey];
18
19    return result;
20};
21