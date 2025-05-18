import java.util.HashMap;

public class ArrayPartition561 {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        boolean flag = false;
        for (int i = min; i <= max; i++) {
            if (!map.containsKey(i))
                continue;

            if (flag)
            { map.put(i, map.get(i) - 1); }

            int freq = map.get(i);
            if (freq % 2 == 0) {
                result += freq / 2 * i;
                flag = false;
            } else {
                result += freq / 2 * i;
                result += i;
                flag = true;
            }
        }
        return result;
    }
}
