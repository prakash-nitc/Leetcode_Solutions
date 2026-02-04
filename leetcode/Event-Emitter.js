1class EventEmitter {
2  constructor() {
3    this.events = {}; // { eventName: [callback, ...] }
4  }
5
6  /**
7   * @param {string} eventName
8   * @param {Function} callback
9   * @return {{unsubscribe: Function}}
10   */
11  subscribe(eventName, callback) {
12    if (!this.events[eventName]) {
13      this.events[eventName] = [];
14    }
15    const listeners = this.events[eventName];
16    listeners.push(callback);
17
18    return {
19      unsubscribe: () => {
20        const idx = listeners.indexOf(callback);
21        if (idx !== -1) {
22          listeners.splice(idx, 1);
23        }
24        return undefined;
25      }
26    };
27  }
28
29  /**
30   * @param {string} eventName
31   * @param {Array} args
32   * @return {Array}
33   */
34  emit(eventName, args = []) {
35    const listeners = this.events[eventName];
36    if (!listeners || listeners.length === 0) return [];
37    const res = [];
38    for (const cb of listeners) {
39      res.push(cb(...args));
40    }
41    return res;
42  }
43}
44