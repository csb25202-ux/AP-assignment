Book = [
    {"name":"Bhagavad Gita","stock":9},
    {"name":"How to Win Friends and Influence People  ","stock":13},
    {"name":"Think and Grow Rich","stock":12},
    {"name":"The Power of Your Subconscious Mind    ","stock":11},
    {"name":"Atomic Habits ","stock":5}
]

print("The books whose stock is less than 10 are : ")
for i in Book:
    if i["stock"] < 10:
        print(f"{i['name']} : {i['stock']}")
