package com.solutions.leetcode;

public class GasStationTest {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;

        for(int i = 0; i<gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }

        if(sumCost>sumGas)
            return -1;

        int total = 0;
        int result = 0;

        for(int i = 0; i< gas.length;i++){
            total += (gas[i]-cost[i]);
            if(total < 0){
                total = 0;
                result = i+1;
            }
        }
        return result;
    }
}
