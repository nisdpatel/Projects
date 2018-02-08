/*Name: Nisha Patel
 * Date: 09/19/17
 * File: carFactory include files: carAssembler.cs, car_factory.cs, car,cs, Suzuki.cs,Toyota.cs, Toyota_factory.cs, Suzuki_factroy.cs
 * Description: Implementation of Car Factory Pattern. 
 */




using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace carFactory
{
    class carAssembler
    {

        public void assemblerCar(car_factory factory)
        {
            car new_car = factory.getCar();
            Console.WriteLine(" Car has been manufactured. Maximum speed is  mph");
            Console.WriteLine();
            
        }


        static void Main(string[] args)
        {
           
            car_factory factory = null;

            Console.WriteLine("Which car do you want to build?");

            string input = Console.ReadLine();

            if (input == "Toyota" || input == "toyota")
            {
               factory = new Toyota_factory("Camry", 130);
               
            }

            else
                factory = new Suzuki_factory("Wagonar", 130);

            new carAssembler().assemblerCar(factory);

            Console.ReadLine();
            Console.WriteLine("Good Bye");




        }
    }

}