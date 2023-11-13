# Programmer: Olmedo, Johnny
# Submission date: 1/16/2022
# This program is an automobile inventory program, able to add, delete, and modify attributes

class Automobiles:
    def __init__(self, make, model, color, year, mileage):
        # private make member
        self.__make = make
        # private model member
        self.__model = model
        self.__color = color
        self.__year = year
        self.__mileage = mileage

        # private init method

    # public make setter
    def set_make(self, make):
        self.__make = make

    def set_model(self, model):
        self.__model = model

    def set_color(self, color):
        self.__color = color

    def set_year(self, year):
        self.__year = year

    def set_mileage(self, mileage):
        self.__mileage = mileage

    def get_make(self, make):
        return self.__make

    def get_model(self, model):
        return self.__model

    def get_color(self, color):
        return self.__color

    def get_year(self, year):
        return self.__year

    def get_mileage(self, mileage):
        return self.__mileage


# function that adds new vehicles -------------------------------------------------------------
def add_vehicle(inventory):
    # car = Automobiles(make = '', model = '', color = '', year = 0, mileage = 0)
    carDict = dict()  # initialize dictionary
    # get the make of the car
    car_make = input("please enter the make of the car: ")
    car_model = input("please enter the model of the car: ")
    car_color = input("please enter the color of the car: ")
    car_year = input("please enter the year the car was made: ")
    car_mileage = input("please enter the mileage of the car: ")

    vehicles = Automobiles(car_make, car_model, car_color, car_year, car_mileage)
    vehicles.set_make(car_make)
    vehicles.set_model(car_model)
    vehicles.set_color(car_color)
    vehicles.set_year(car_year)
    vehicles.set_mileage(car_mileage)

    make = vehicles.get_make(car_make)
    model = vehicles.get_model(car_model)
    color = vehicles.get_color(car_color)
    year = vehicles.get_year(car_year)
    mileage = vehicles.get_mileage(car_mileage)

    # create dictionary
    carDict['make'] = make
    carDict['model'] = model
    carDict['color'] = color
    carDict['year'] = year
    carDict['mileage'] = mileage

    inventory.append(carDict)
    # format the string and print it out
    format(inventory)

    return inventory


# function that deletes a cars in inventory -------------------------------------------------------
def delete_vehicle(inventory):
    # call format function to print out what the inventory looks like
    format(inventory)
    delete = input("which vehicle would you like to delete? (use numbers to identify vehicle) ")
    # here might be a good input validation method
    for i in inventory:
        index = inventory.index(i)

    if (int(delete) - 1) == index:
        del inventory[index]
    else:
        print("you didn't put a valid entry")
    # show what the inventory looks like now
    format(inventory)
    return inventory

# function that updates a cars in inventory -------------------------------------------------------
def update_vehicle(inventory):
    update = input("which vehicle would you like to update? (use numbers to identify vehicle) ")
    # format(inventory)
    carDict = dict()
    for i in inventory:
        element = inventory.index(i)
        if (int(update) - 1) == element:
            car_make = input("please enter the make of the car: ")
            car_model = input("please enter the model of the car: ")
            car_color = input("please enter the color of the car: ")
            car_year = input("please enter the year the car was made: ")
            car_mileage = input("please enter the mileage of the car: ")

            vehicles = Automobiles(car_make, car_model, car_color, car_year, car_mileage)
            vehicles.set_make(car_make)
            vehicles.set_model(car_model)
            vehicles.set_color(car_color)
            vehicles.set_year(car_year)
            vehicles.set_mileage(car_mileage)

            make = vehicles.get_make(car_make)
            model = vehicles.get_model(car_model)
            color = vehicles.get_color(car_color)
            year = vehicles.get_year(car_year)
            mileage = vehicles.get_mileage(car_mileage)

            # create dictionary
            carDict['make'] = make
            carDict['model'] = model
            carDict['color'] = color
            carDict['year'] = year
            carDict['mileage'] = mileage
            # set the updated dictionary to replace the old vehivle in inventory list
            inventory[element] = carDict
    format(inventory)
    return inventory

# function that formats the data and writes to data file -------------------------------------------------------
def format(inventory):
    vehicle_file = open('vehicle.txt', 'w')
    # vehicle_file.write()
    vehicle_file.write('\n----------------')
    vehicle_file.write('\n   INVENTORY')
    vehicle_file.write('\n----------------')
    # for each dictionary in the list

    for i in inventory:
        element = inventory.index(i) + 1
        vehicle_file.write('\nVehicle #%d' % element)

        # put into correct format
        for k, v in i.items():
            vehicle_file.write('\n{0} : {1}'.format(k, v))
        vehicle_file.write("\n")
    vehicle_file.close()

# function that display the menu for user -------------------------------------------------------
def create_menu():
    print('\n----------------')
    print('     MENU')
    print('----------------')
    menu = {}
    menu['1'] = "Add Vehicle."
    menu['2'] = "Delete Vehicle."
    menu['3'] = "Update Attributes"
    menu['4'] = "Exit"
    # format the menue
    for x, v in menu.items():
        # print the first argument, then the second one after 
        print(f' {x}: {v}')
    print('\n')
    return menu

# function that allows user to choose what to do with inventory -------------------------------------------------------
def choose():
    vehicle_inventory = []
    user = True
    while user:
        create_menu()
        ans = input("What would you like to do? ")
        if ans == "1":
            add = add_vehicle(vehicle_inventory)
        elif ans == "2":
            delete = delete_vehicle(vehicle_inventory)
        elif ans == "3":
            update = update_vehicle(vehicle_inventory)

        elif ans == "4":
            vehicle_file = open('vehicle.txt', 'w')
            for item in vehicle_inventory:
                format(item)
            vehicle_file.close()
            print("\n Goodbye")
            break
        elif ans != "":
            print("\n Invaild Entry")


def main():
    # getuser choice
    user_choice = choose()


main()
