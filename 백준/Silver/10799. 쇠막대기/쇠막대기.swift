//
//  main.swift
//  codingTest
//
//  Created by 조유진 on 2023/11/06.
//

import Foundation

let line = readLine()!.map{ String($0) }
var stack = 0
var count = 0

for i in 0..<line.count {
    if line[i] == "(" {
        stack += 1
    } else {
        stack -= 1
        if line[i-1] == "(" {
            count += stack
        } else {
            count += 1
        }
    }
}

print(count)
