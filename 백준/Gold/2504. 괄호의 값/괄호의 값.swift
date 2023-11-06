//
//  main.swift
//  codingTest
//
//  Created by 조유진 on 2023/11/06.
//

import Foundation

// 괄호의 값

var parens = Array(readLine()!).map { String($0) }
var stack = [String]()
var result = 0
var isCorrect = true
var temp = 1

for i in parens.indices {
    
    if parens[i] == "(" {
        temp *= 2
        stack.append(parens[i])
    } else if parens[i] == "[" {
        temp *= 3
        stack.append(parens[i])
    } else if parens[i] == ")" {
        if stack.isEmpty || stack.last != "(" {
            isCorrect = false
            break
        }
        
        if parens[i-1] == "(" {
            result += temp
        }
        stack.removeLast()
        temp /= 2
    } else if parens[i] == "]" {
        if stack.isEmpty || stack.last != "[" {
            isCorrect = false
            break
        }
        
        if parens[i-1] == "[" {
            result += temp
        }
        stack.removeLast()
        temp /= 3
    }
}

if !isCorrect || !stack.isEmpty {
    print(0)
} else {
    print(result)
}

