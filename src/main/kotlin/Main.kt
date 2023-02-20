fun main() {
    print(deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
}


fun deleteAndEarn(nums: IntArray): Int {
    val maxVal = nums.max()

    // Count the frequency of each number in nums
    val freq = IntArray(maxVal + 1)
    for (num in nums) {
        freq[num]++
    }

    // Initialize the DP array
    val dp = IntArray(maxVal + 1)
    dp[1] = freq[1]

    // Compute the maximum number of points that can be earned for each i
    for (i in 2..maxVal) {
        dp[i] = maxOf(dp[i - 1], dp[i - 2] + i * freq[i])
    }

    // Return the last element of the DP array
    return dp[maxVal]
}
