using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace carFactory
{
    abstract class car
    {
        private string company
        {
            get;
        }
        private string model
        {
            get;
            set;
        }
        private int speed
        {
            get;
            set;
        }
    }

}