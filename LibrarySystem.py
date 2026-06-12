from abc import ABC , abstractmethod 

class Library_items(ABC):
    total_items = 0

    def __init__(self,title,year):
        self.title = title
        self.year = year
        Library_items.total_items += 1

    @abstractmethod         # It acts as a blueprint, forcing all non-abstract subclasses to provide their own specific implementation of that method.
    def displayInfo(self):
        pass                #Must be implemented by subclasses"""

class Book(Library_items):
    def __init__(self,title,year,Author):
        super().__init__(title,year)

        self.Author = Author

    def displayInfo(self):
        print(f"Book '{self.title}' , ({self.year}) -- written by '{self.Author}'")

class DVD(Library_items):
    def __init__(self,title,year,Duration,genre):
        super().__init__(title,year)

        self.Duration = Duration
        self.genre = genre

    def displayInfo(self):
        print(f"DVD '{self.title}' , ({self.year}) -- genre: {self.genre} | duration: {self.Duration} mins")



book1 = Book("The Hobbit", 1937, "J.R.R. Tolkien")
book2 = Book("Dune", 1965, "Frank Herbert")
dvd1 = DVD("The Matrix", 1999, 136, "Sci-Fi")
dvd2 = DVD("Gladiator", 2000, 155, "Action")

inventory = (book1,book2,dvd1,dvd2)

print("=== 🎒 OPENING INVENTORY ===")

for item in inventory:
    item.displayInfo()

print("============================")

print(f"Total items in the library : {Library_items.total_items}")

