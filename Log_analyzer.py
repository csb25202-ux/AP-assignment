from typing import List, Dict
from collections import defaultdict
from functools import reduce

def total_time_per_user(logs: List[Dict[str, object]]) -> Dict[str, float]:
    def reducer(acc, log):
        acc[log["user"]] += log["duration"]
        return acc
    return reduce(reducer, logs, defaultdict(float))

def most_active_users(logs: List[Dict[str, object]], k: int) -> List[str]: # only top 2
    totals = total_time_per_user(logs)
    return [
        user for user, _ in 
        sorted(totals.items(), key=lambda x: x[1], reverse=True)[:k]
    ]

def unique_actions(logs: List[Dict[str, object]]) -> set[str]:
    return {log["action"] for log in logs}


logs = [
    {"user": "101", "action": "YouTube", "duration": 30.0},
    {"user": "102", "action": "Instagram", "duration": 20.0},
    {"user": "101", "action": "WhatsApp", "duration": 10.0},
    {"user": "103", "action": "YouTube", "duration": 50.0},
]

print("Total Time Per User:")
print(total_time_per_user(logs))

print("\nMost Active Users (Top 2):")
print(most_active_users(logs, 2))

print("\nUnique Actions:")
print(unique_actions(logs))


# COMPLEXITY:
# a) Time Complexity (Top K Users)
#   Computing total time per user: O(n)
#   Sorting users: O(u log u)
#   Final time complexity:
#   O(n + u log u)
#   (where n = number of logs, u = number of unique users) 

# b) Space Complexity (Intermediate Results)
#   Dictionary storing totals per user: O(u)



