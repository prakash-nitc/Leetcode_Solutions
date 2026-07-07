class Solution {
    public int[] nextGreaterElements(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n= arr.length;

        for (int i = 2*n - 1; i >= 0; i--) {

            int idx= i%n;

            while (!stack.isEmpty() && stack.peek() <= arr[idx]) {
                stack.pop();
            }
            if(i<n)
            {
                if (stack.isEmpty())
                    ans.add(-1);
                else
                    ans.add(stack.peek());
            }

            stack.push(arr[idx]);
        }

        Collections.reverse(ans);
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}