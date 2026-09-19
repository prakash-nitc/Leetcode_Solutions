class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int consumed = numBottles;
        int emptyBottles= numBottles;
        
        while(emptyBottles>= numExchange)
        {
            int extraFullBottles = emptyBottles/ numExchange;
            int remaining= emptyBottles% numExchange;
            consumed+= extraFullBottles;
            emptyBottles= remaining+ extraFullBottles;
            
        }
        return consumed;
    }
}