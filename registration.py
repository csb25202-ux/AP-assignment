import re

class InvalidEmailError(ValueError):
    def __init__(self, email):
        message = f"Access Denied: '{email}' is not a valid email format."
        super().__init__(message)

class UnderageError(ValueError):
    def __init__(self, age):
        message = f"Level too low: Age {age} does not meet the 18+ requirement."
        super().__init__(message)

class RegistrationService:
    def register_user(self, email: str, age: int) -> bool:
        assert isinstance(email, str), "System Error: Email payload must be a string."
        assert email.strip() != "", "System Error: Email string cannot be empty."
        assert isinstance(age, int), "System Error: Age payload must be an integer."

        pattern = r"^[^@\s]+@[^@\s]+\.[^@\s]+$"
        
        if not re.match(pattern, email):
            raise InvalidEmailError(email)

        if age < 18:
            raise UnderageError(age)

        return True