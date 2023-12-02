
import Foundation

let t = Int(readLine()!)!

for _ in 0..<t {
    let _ = Int(readLine()!)!
    let coins = readLine()!.split(separator: " ").map { Int(String($0))! }
    let m = Int(readLine()!)!
    var dp = [Int](repeating: 0, count: m+1)
    dp[0] = 1
    
    for coin in coins {
        if coin > m { continue }
        for won in coin...m {
            dp[won] += dp[won-coin]
        }
    }
    print(dp[m])
}