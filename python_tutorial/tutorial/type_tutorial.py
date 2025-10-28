
name = "Test Python"
name2 = 'Test Python'
age = 21
height = 180.5
heigh2 = 0.3123
isTest = True

print(name, name2, age, height, heigh2, isTest)
print(type(name), type(name2), type(age), type(height), type(heigh2), type(isTest))
print(height + heigh2)
print(age + height)
print(name + age) # TypeError: can only concatenate str (not "int") to str
print("Test End !!")