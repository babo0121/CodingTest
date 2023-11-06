//
//  main.swift
//  codingTest
//
//  Created by 조유진 on 2023/11/06.
//

import Foundation

// 괄호의 값

var input = Array(readLine()!).map { String($0) }
var stack = [String]()
var result = 0
var isCorrect = true
var temp = 1

for i in input.indices {
    let c = input[i]
    
    if c == "(" {
        temp *= 2
        stack.append(c)
    } else if c == "[" {
        temp *= 3
        stack.append(c)
    } else if c == ")" {
        if stack.isEmpty || stack.last != "(" {
            isCorrect = false
            break
        }
        
        if input[i-1] == "(" {
            result += temp
        }
        stack.removeLast()
        temp /= 2
    } else if c == "]" {
        if stack.isEmpty || stack.last != "[" {
            isCorrect = false
            break
        }
        
        if input[i-1] == "[" {
            result += temp
        }
        stack.removeLast()
        temp /= 3
    }
}

if !isCorrect || !stack.isEmpty {
    result = 0
}
print(result)
