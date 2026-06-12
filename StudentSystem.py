class Address:
    def __init__(self , street , city , zipcode):
        self.street = street
        self.city = city
        self.zipcode = zipcode

class Student:                  #composition
    def __init__(self , name , age , Address , courses = None):
        self.name = name
        self.Address = Address
        self._age = age

        if courses is None:
            self.courses = []
        else :
            self.courses = courses

    def add_course(self , course_name):
        self.courses.append(course_name)
        print(f"[SYSTEM] '{course_name}' successfully added to {self.name}'s profile.")

    def display(self):
        print("\n--- OPERATIVE PROFILE ---")
        print(f"Name: {self.name} , Age: {self.age} ")
        print(f"Location: {self.Address.street} , {self.Address.city}")
        print(f"Courses: {self.courses}")

    @property       #getter
    def age(self):
        return self._age

    @age.setter     #setter
    def age(self,value):
        if 0 <= value <= 130:
            self._age = value  # here ' _ ' : "This is an internal, protected gear. Don't touch it directly."
        else:
            print(f"[SECURITY ALERT] Invalid age entry: {value}. Access Denied.")
            self._age = 0        

class ScholarshipStudent(Student):
    def __init__(self,name,age,Address,scholarshipAmount,courses = None):
        super().__init__(name,age,Address,courses)
        self.scholarshipAmount = scholarshipAmount

    def display(self):
        super().display()
        print(f"Funding Allocation: {self.scholarshipAmount}")
        print("-------------------------")



#### TEST DATA ####
# 1. Establish the Coordinates (Composition)
hq_address = Address("123 Tech Lane", "Cyber City", "10101")

# 2. Deploy a Standard Operative
agent_smith = Student("Agent Smith", 22, hq_address)
agent_smith.add_course("Python Fundamentals")
agent_smith.display()

# 3. Deploy an Elite Operative
neo = ScholarshipStudent("Neo", 20, hq_address, 50000)
neo.add_course("Advanced AI Architecture")
neo.add_course("System Bypassing")

neo.age = -50  # This will trigger the Security Alert

neo.display()