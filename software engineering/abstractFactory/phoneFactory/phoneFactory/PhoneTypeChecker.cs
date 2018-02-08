/* Name: Nisha Patel
 * Date: 09/19/2017
 * File: phonefactory include files : PhoneTypeChecker.cs, factories.cs, iDumb_I.cs, iDumbPhones.cs, iSmart_I.cs, iSmartPhones.cs, IPhoneFactory.cs
 * Description: Implementation of Abstract Factory Pattern of Phone Factory
 */



using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phoneFactory
{

    enum MANUFACTURERS
    {
        SAMSUNG,
        HTC,
        NOKIA,
    }

    class PhoneTypeChecker {
        private iDumb samsung;
        private iSmart htc;
        private IPhoneFactory factory;
        private MANUFACTURERS manu;


        private PhoneTypeChecker(MANUFACTURERS m)
        {
            manu = m;
        }

        public void CheckProducts()
        {
            switch (manu)
            {

                case MANUFACTURERS.HTC:
                    factory = new HTCFactory();
                    break;
                case MANUFACTURERS.SAMSUNG:
                    factory = new SamsungFactory();
                    break;
                case MANUFACTURERS.NOKIA:
                    factory = new NokiaFactory();
                    break;
            }

            Console.WriteLine(manu.ToString() + ":\nSmart Phone: " + factory.getSmart().getName() + "\nDumb Phone: " + factory.getDumb().getName());
            //NokiaFactory nf  = new NokiaFactory();
            
        }


        static void Main(string[] args)
        {
            // Testing
            PhoneTypeChecker checker = new PhoneTypeChecker(MANUFACTURERS.SAMSUNG);

            checker.CheckProducts();
            Console.ReadLine();

            checker = new PhoneTypeChecker(MANUFACTURERS.HTC);

            checker.CheckProducts();
            Console.ReadLine();

            checker = new PhoneTypeChecker(MANUFACTURERS.NOKIA);

            checker.CheckProducts();
            Console.Read();
        }

    }
}