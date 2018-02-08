using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phoneFactory
{
    class Lumia : iSmart
    {
        private string name = "Nokia Lumia";
        public string getName()
        {
            return name;
        }
    }

    class galaxyS2 : iSmart
    {
        private string name = "Samsung galaxy S2";

        public string getName()
        {
            return name;
        }

    }

    class Titan : iSmart
    {
        private string name = "Titan";

        public string getName()
        {
            return name;
        }
    }
}
